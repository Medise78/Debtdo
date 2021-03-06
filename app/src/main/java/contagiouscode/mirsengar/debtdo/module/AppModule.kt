package contagiouscode.mirsengar.debtdo.module

import android.content.Context
import androidx.room.Room
import contagiouscode.mirsengar.debtdo.db.InvoiceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
     
     @Singleton
     @Provides
     fun provideInvoicesDatabase(
               @ApplicationContext app : Context ,
     ) = Room.databaseBuilder(
               app ,
               InvoiceDatabase::class.java ,
               "invoices_db"
     ).build()
     
     @Singleton
     @Provides
     fun provideInvoiceDao(db : InvoiceDatabase) = db.getInvoiceDao()
     
     @Singleton
     @Provides
     fun provideInvoiceItemDao(db : InvoiceDatabase) = db.getInvoiceItemDao()
     
}