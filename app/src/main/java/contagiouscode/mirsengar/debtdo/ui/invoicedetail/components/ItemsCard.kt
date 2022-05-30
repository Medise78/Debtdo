package contagiouscode.mirsengar.debtdo.ui.invoicedetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.ui.theme.getCardOnCardBlackColor
import contagiouscode.mirsengar.debtdo.ui.theme.getCardOnCardColor
import contagiouscode.mirsengar.debtdo.utils.Constants
import contagiouscode.mirsengar.debtdo.utils.getTotal

@Composable
fun ItemsCard(invoice : Invoice) {
     Card(
               shape = Constants.cardShape ,
               backgroundColor = getCardOnCardColor() ,
               modifier = Modifier
                         .padding(top = 30.dp , bottom = 20.dp)
                         .clip(Constants.cardShape)
     ) {
          Column(
                    modifier = Modifier
                              .fillMaxWidth()
                              .height(IntrinsicSize.Min) ,
          ) {
               Column(
                         modifier = Modifier.padding(Constants.cardPadding) ,
                         verticalArrangement = Arrangement.spacedBy(20.dp)
               ) {
                    invoice.items.forEach { item ->
                         Item(item)
                    }
               }
               Row(
                         modifier = Modifier
                                   .fillMaxWidth()
                                   .background(color = getCardOnCardBlackColor())
                                   .padding(Constants.cardPadding) ,
                         horizontalArrangement = Arrangement.SpaceBetween ,
               ) {
                    Text(
                              text = "Amount Due" ,
                              style = MaterialTheme.typography.caption ,
                              color = MaterialTheme.colors.onBackground ,
                              modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                              text = getTotal(invoice.items) ,
                              fontSize = 22.sp ,
                              color = MaterialTheme.colors.onBackground ,
                              modifier = Modifier.padding(bottom = 5.dp)
                    )
               }
          }
     }
}