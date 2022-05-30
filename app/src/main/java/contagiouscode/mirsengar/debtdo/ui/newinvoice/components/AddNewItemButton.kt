package contagiouscode.mirsengar.debtdo.ui.newinvoice.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import contagiouscode.mirsengar.debtdo.model.enums.InvoiceButton
import contagiouscode.mirsengar.debtdo.ui.shared.CustomButton

@Composable
fun AddNewItemButton(modifier : Modifier) {
     CustomButton(InvoiceButton.AddNewItem , modifier)
}