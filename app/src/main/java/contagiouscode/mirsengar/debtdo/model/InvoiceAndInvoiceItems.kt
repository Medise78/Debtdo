package contagiouscode.mirsengar.debtdo.model

import androidx.room.Embedded
import androidx.room.Relation

data class InvoiceAndInvoiceItems(
          @Embedded
          val invoice : Invoice ,
          @Relation(
                    parentColumn = "id" ,
                    entityColumn = "parentInvoiceId"
          )
          val items : List<InvoiceItem> ,
)