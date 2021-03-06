package contagiouscode.mirsengar.debtdo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.repository.InvoiceRepository
import contagiouscode.mirsengar.debtdo.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewInvoiceViewModel @Inject constructor(
          private val repository : InvoiceRepository ,
          application : Application ,
) : AndroidViewModel(application) {
     
     lateinit var invoice : Invoice
     var isNew = true
     
     fun setInvoiceData(received : Invoice?) {
          if (! this::invoice.isInitialized) {
               if (received != null) {
                    invoice = received
                    isNew = false
               }
               else {
                    invoice = Invoice()
                    isNew = true
               }
          }
     }
     
     fun createInvoice() {
          invoice.status = Constants.pending
          if (isNew) {
               viewModelScope.launch(Dispatchers.IO + NonCancellable) {
                    repository.createInvoice(invoice)
               }
          }
          else {
               editInvoice()
          }
     }
     
     fun saveInvoiceAsDraft() {
          invoice.status = Constants.draft
          if (isNew) {
               viewModelScope.launch(Dispatchers.IO + NonCancellable) {
                    repository.createInvoice(invoice)
               }
          }
          else {
               editInvoice()
          }
     }
     
     private fun editInvoice() {
          viewModelScope.launch(Dispatchers.IO + NonCancellable) {
               repository.updateInvoice(invoice)
          }
     }
     
}