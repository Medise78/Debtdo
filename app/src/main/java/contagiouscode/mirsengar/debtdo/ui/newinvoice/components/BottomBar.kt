package contagiouscode.mirsengar.debtdo.ui.newinvoice.components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.viewmodel.NewInvoiceViewModel

@Composable
fun BottomBar(
          activity : Activity ,
          newInvoiceViewModel : NewInvoiceViewModel ,
) {
     Row(
               verticalAlignment = Alignment.CenterVertically ,
               horizontalArrangement = Arrangement.SpaceEvenly ,
               modifier = Modifier
                         .fillMaxWidth()
                         .height(IntrinsicSize.Min)
                         .background(color = MaterialTheme.colors.surface)
                         .padding(20.dp)
     ) {
          DiscardButton(activity)
          SaveAsDraftButton(activity , newInvoiceViewModel)
          SaveAndSendButton(activity , newInvoiceViewModel)
     }
}