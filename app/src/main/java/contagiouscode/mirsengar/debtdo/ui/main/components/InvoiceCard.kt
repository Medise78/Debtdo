package contagiouscode.mirsengar.debtdo.ui.main.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.ui.invoicedetail.InvoiceDetailActivity
import contagiouscode.mirsengar.debtdo.ui.shared.InvoiceId
import contagiouscode.mirsengar.debtdo.ui.shared.StatusButton
import contagiouscode.mirsengar.debtdo.utils.Constants
import contagiouscode.mirsengar.debtdo.utils.getDueDate
import contagiouscode.mirsengar.debtdo.utils.getStatus
import contagiouscode.mirsengar.debtdo.utils.getTotal

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun InvoiceCard(context : Context , invoice : Invoice , modifier : Modifier) {
     Card(
               shape = Constants.cardShape ,
               backgroundColor = MaterialTheme.colors.surface ,
               modifier = modifier
                         .clip(Constants.cardShape)
                         .clickable {
                              val intent = Intent(context , InvoiceDetailActivity::class.java)
                              intent.putExtra("id" , invoice.id)
                              context.startActivity(intent)
                         }
     ) {
          Column(
                    modifier = Modifier
                              .fillMaxWidth()
                              .height(IntrinsicSize.Min)
                              .padding(Constants.cardPadding) ,
          ) {
               Row(
                         modifier = Modifier.fillMaxWidth() ,
                         horizontalArrangement = Arrangement.SpaceBetween
               ) {
                    InvoiceId(invoice.id)
                    Text(
                              text = invoice.clientName ,
                              style = MaterialTheme.typography.subtitle1 ,
                              color = MaterialTheme.colors.onBackground
                    )
               }
               Row(
                         modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(top = 20.dp) ,
                         horizontalArrangement = Arrangement.SpaceBetween
               ) {
                    Column {
                         Text(
                                   text = "Due ${getDueDate(invoice.invoiceDate , invoice.paymentTerms)}" ,
                                   style = MaterialTheme.typography.subtitle1 ,
                                   color = MaterialTheme.colors.onBackground ,
                                   modifier = Modifier.padding(bottom = 5.dp)
                         )
                         Text(
                                   text = getTotal(invoice.items) ,
                                   style = MaterialTheme.typography.body1 ,
                                   color = MaterialTheme.colors.onBackground
                         )
                    }
                    StatusButton(
                              modifier = Modifier
                                        .align(Alignment.CenterVertically) ,
                              type = getStatus(invoice.status)
                    )
               }
          }
     }
}