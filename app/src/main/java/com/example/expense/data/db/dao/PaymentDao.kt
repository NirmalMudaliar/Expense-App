package com.example.expense.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expense.data.db.entities.Payment

@Dao
interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPayment(payment: Payment)

    @Update
    suspend fun updatePayment(payment: Payment)

    @Delete
    suspend fun deleteSinglePayment(payment: Payment)

    @Query("DELETE FROM payment_table")
    suspend fun deleteAllPayment()

    @Query("SELECT * FROM payment_table")
    fun getAllPayment(): LiveData<List<Payment>>
}