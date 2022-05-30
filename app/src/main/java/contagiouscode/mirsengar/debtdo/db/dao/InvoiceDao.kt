package contagiouscode.mirsengar.debtdo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import contagiouscode.mirsengar.debtdo.model.Invoice

@Dao
interface InvoiceDao {
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addInvoice(invoice : Invoice)
     
     @Query("SELECT * FROM invoices")
     fun readAllInvoices() : LiveData<List<Invoice>>
     
     @Query("SELECT * FROM invoices WHERE id=:id")
     fun getInvoiceById(id : String?) : LiveData<Invoice>
     
     @Update
     suspend fun updateInvoice(invoice : Invoice)
     
     @Delete
     suspend fun deleteInvoice(invoice : Invoice)
}