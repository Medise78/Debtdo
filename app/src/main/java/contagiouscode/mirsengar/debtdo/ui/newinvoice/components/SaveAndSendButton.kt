package contagiouscode.mirsengar.debtdo.ui.newinvoice.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.enums.InvoiceButton
import contagiouscode.mirsengar.debtdo.ui.shared.CustomButton
import contagiouscode.mirsengar.debtdo.viewmodel.NewInvoiceViewModel

@Composable
fun SaveAndSendButton(activity : Activity , newInvoiceViewModel : NewInvoiceViewModel) {
     CustomButton(
               InvoiceButton.SaveAndSend ,
               Modifier
                         .clip(RoundedCornerShape(90.dp))
                         .clickable {
                              newInvoiceViewModel.createInvoice()
                              activity.finish()
                         })
}