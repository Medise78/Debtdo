package contagiouscode.mirsengar.debtdo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import contagiouscode.mirsengar.debtdo.db.dao.InvoiceDao
import contagiouscode.mirsengar.debtdo.db.dao.InvoiceItemDao
import contagiouscode.mirsengar.debtdo.model.Invoice
import contagiouscode.mirsengar.debtdo.model.InvoiceItem
import contagiouscode.mirsengar.debtdo.model.converter.AddressConverter
import contagiouscode.mirsengar.debtdo.model.converter.InvoiceItemConverter

@Database(entities = [Invoice::class , InvoiceItem::class] , version = 1)
@TypeConverters(AddressConverter::class , InvoiceItemConverter::class)
abstract class InvoiceDatabase : RoomDatabase() {
     abstract fun getInvoiceDao() : InvoiceDao
     abstract fun getInvoiceItemDao() : InvoiceItemDao
}