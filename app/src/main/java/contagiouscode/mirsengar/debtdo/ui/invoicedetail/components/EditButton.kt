package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.model.enums.InvoiceButton
import contagiouscode.mirsengar.debtdo.ui.newinvoice.NewInvoiceActivity
import contagiouscode.mirsengar.debtdo.ui.shared.CustomButton

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun EditButton(invoice : Invoice , activity : Activity) {
     CustomButton(
               InvoiceButton.Edit ,
               Modifier
                         .clip(RoundedCornerShape(90.dp))
                         .clickable {
                              activity.finish()
                              val intent = Intent(activity , NewInvoiceActivity::class.java)
                              intent.putExtra("invoice" , invoice)
                              activity.startActivity(intent)
                         })
}