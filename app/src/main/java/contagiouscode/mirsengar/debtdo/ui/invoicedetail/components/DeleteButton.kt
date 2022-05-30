package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.model.enums.InvoiceButton
import contagiouscode.mirsengar.debtdo.ui.shared.CustomButton
import contagiouscode.mirsengar.debtdo.viewmodel.InvoiceDetailViewModel

@Composable
fun DeleteButton(
          invoice : Invoice ,
          invoiceDetailViewModel : InvoiceDetailViewModel ,
          activity : Activity ,
) {
     val openDialog = rememberSaveable { mutableStateOf(false) }
     DeleteDialog(invoice , invoiceDetailViewModel , activity , openDialog)
     CustomButton(
               InvoiceButton.Delete ,
               Modifier
                         .clip(RoundedCornerShape(90.dp))
                         .clickable {
                              openDialog.value = true
                         })
}