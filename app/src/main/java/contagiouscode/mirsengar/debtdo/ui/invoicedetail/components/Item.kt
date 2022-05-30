package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.InvoiceItem
import contagiouscode.mirsengar.debtdo.utils.getItemTotal
import contagiouscode.mirsengar.debtdo.utils.getPrice

@Composable
fun Item(item : InvoiceItem) {
     Row(
               modifier = Modifier.fillMaxWidth() ,
               horizontalArrangement = Arrangement.SpaceBetween ,
     ) {
          Column {
               Text(
                         text = item.name ,
                         style = MaterialTheme.typography.subtitle1 ,
                         color = MaterialTheme.colors.onBackground ,
                         modifier = Modifier.padding(bottom = 5.dp)
               )
               Text(
                         text = "${item.quantity} x ${getPrice(item.price)}" ,
                         style = MaterialTheme.typography.subtitle1 ,
                         color = MaterialTheme.colors.onSurface ,
               )
          }
          Text(
                    text = getItemTotal(item) ,
                    style = MaterialTheme.typography.subtitle1 ,
                    color = MaterialTheme.colors.onBackground ,
                    modifier = Modifier.align(Alignment.CenterVertically)
          )
     }
}