package contagiouscode.mirsengar.debtdo.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import contagiouscode.mirsengar.debtdo.ui.shared.ActivityTemplate
import contagiouscode.mirsengar.debtdo.ui.main.components.ActivityContent
import contagiouscode.mirsengar.debtdo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
     
     private val mainViewModel : MainViewModel by viewModels()
     
     override fun onCreate(savedInstanceState : Bundle?) {
          super.onCreate(savedInstanceState)
          
          setContent {
               ActivityTemplate(
                         content = {
                              ActivityContent(this , mainViewModel)
                         }
               )
          }
     }
}