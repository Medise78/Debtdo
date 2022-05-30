package contagiouscode.mirsengar.debtdo.model.converter

import androidx.room.TypeConverter
import contagiouscode.mirsengar.debtdo.model.InvoiceItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class InvoiceItemConverter {
     @TypeConverter
     fun itemsToString(items : List<InvoiceItem>) : String = Gson().toJson(items)
     
     @TypeConverter
     fun stringToItems(string : String) : List<InvoiceItem> =
          Gson().fromJson(string , object : TypeToken<List<InvoiceItem>>() {}.type)
}