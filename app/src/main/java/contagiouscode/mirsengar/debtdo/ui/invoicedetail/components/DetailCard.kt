package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.utils.Constants

@Composable
fun DetailCard(invoice : Invoice) {
     Card(
               shape = Constants.cardShape ,
               backgroundColor = MaterialTheme.colors.surface ,
               modifier = Modifier
                         .clip(Constants.cardShape)
                         .padding(bottom = 140.dp)
     ) {
          Column(
                    modifier = Modifier
                              .fillMaxWidth()
                              .height(IntrinsicSize.Min)
                              .padding(Constants.cardPadding) ,
          ) {
               Body(invoice)
          }
     }
}