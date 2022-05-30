package contagiouscode.mirsengar.debtdo.ui.newinvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.ui.newinvoice.components.ActivityContent
import contagiouscode.mirsengar.debtdo.ui.newinvoice.components.BottomBar
import contagiouscode.mirsengar.debtdo.ui.shared.ActivityTemplate
import contagiouscode.mirsengar.debtdo.viewmodel.NewInvoiceViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class NewInvoiceActivity : ComponentActivity() {
     
     private val newInvoiceViewModel : NewInvoiceViewModel by viewModels()
     
     override fun onCreate(savedInstanceState : Bundle?) {
          super.onCreate(savedInstanceState)
          
          setContent {
               val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
               newInvoiceViewModel.setInvoiceData(
                         intent.getSerializableExtra("invoice") as Invoice?
               )
               
               ActivityTemplate(
                         content = {
                              ActivityContent(
                                        toggleBottomBar = {
                                             bottomBarState.value = it
                                        } ,
                                        newInvoiceViewModel = newInvoiceViewModel
                              )
                         } ,
                         showGoBack = true ,
                         activity = this ,
                         bottomBar = {
                              if (bottomBarState.value) {
                                   BottomBar(this , newInvoiceViewModel)
                              }
                         }
               )
          }
     }
}