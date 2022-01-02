package com.example.expense.data.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expense.data.db.dao.CategoryDao
import com.example.expense.data.db.dao.PaymentDao
import com.example.expense.data.db.entities.Category
import com.example.expense.data.db.entities.Payment

@Database(entities = [Category::class, Payment::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase: RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDao
    abstract fun getPaymentDao(): PaymentDao

    companion object {
        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        fun getDatabase(context: Context): ExpenseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}