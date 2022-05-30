package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.model.enums.InvoiceButton
import contagiouscode.mirsengar.debtdo.ui.shared.CustomButton
import contagiouscode.mirsengar.debtdo.viewmodel.InvoiceDetailViewModel

@Composable
fun MarkAsPaidButton(
          invoice : Invoice ,
          invoiceDetailViewModel : InvoiceDetailViewModel ,
) {
     CustomButton(
               InvoiceButton.MarkAsPaid ,
               Modifier
                         .clip(RoundedCornerShape(90.dp))
                         .clickable {
                              invoiceDetailViewModel.markInvoiceAsPaid(invoice)
                         })
}