package contagiouscode.mirsengar.debtdo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import contagiouscode.mirsengar.debtdo.model.InvoiceAndInvoiceItems
import contagiouscode.mirsengar.debtdo.model.InvoiceItem

@Dao
interface InvoiceItemDao {
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addItem(item : InvoiceItem)
     
     @Transaction
     @Query("SELECT * FROM invoices WHERE id = :id")
     fun readAllItems(id : String) : LiveData<List<InvoiceAndInvoiceItems>>
     
     @Update
     suspend fun updateItem(item : InvoiceItem)
     
     @Delete
     suspend fun deleteItem(item : InvoiceItem)
}