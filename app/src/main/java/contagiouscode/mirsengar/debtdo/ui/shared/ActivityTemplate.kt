package contagiouscode.mirsengar.debtdo.ui.shared

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import contagiouscode.mirsengar.debtdo.ui.theme.DebtdoTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivityTemplate(
          content : @Composable () -> Unit ,
          bottomBar : @Composable () -> Unit = {} ,
          showGoBack : Boolean = false ,
          activity : Activity? = null ,
) {
     DebtdoTheme() {
          Scaffold(
                    topBar = {
                         TopAppBar(showGoBack , activity)
                    } ,
                    bottomBar = {
                         bottomBar()
                    } ,
                    content = {
                         content()
                    } ,
                    modifier = Modifier
                         .fillMaxSize()
                         .background(color = MaterialTheme.colors.background)
          )
     }
}