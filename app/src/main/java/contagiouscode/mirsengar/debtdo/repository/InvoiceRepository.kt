package contagiouscode.mirsengar.debtdo.repository

import androidx.lifecycle.LiveData
import contagiouscode.mirsengar.debtdo.db.dao.InvoiceDao
import contagiouscode.mirsengar.debtdo.model.Invoice
import javax.inject.Inject

class InvoiceRepository @Inject constructor(
          private val invoiceDao : InvoiceDao ,
) {
     
     val invoices : LiveData<List<Invoice>> = invoiceDao.readAllInvoices()
     
     suspend fun addAllInvoices(invoices : List<Invoice>) {
          for (invoice in invoices) {
               invoiceDao.addInvoice(invoice)
          }
     }
     
     fun getInvoiceById(id : String?) : LiveData<Invoice> {
          return invoiceDao.getInvoiceById(id)
     }
     
     suspend fun createInvoice(invoice : Invoice) {
          invoiceDao.addInvoice(invoice)
     }
     
     suspend fun updateInvoice(invoice : Invoice) {
          invoiceDao.updateInvoice(invoice)
     }
     
     suspend fun deleteInvoice(invoice : Invoice) {
          invoiceDao.deleteInvoice(invoice)
     }
     
     suspend fun markInvoiceAsPaid(invoice : Invoice) {
          invoiceDao.updateInvoice(invoice)
     }
     
}