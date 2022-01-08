package com.example.expense.data.repositories

import androidx.lifecycle.LiveData
import com.example.expense.data.db.dao.PaymentDao
import com.example.expense.data.db.entities.Payment

class PaymentRepository(private val paymentDao: PaymentDao) {

    val getAllPayment: LiveData<List<Payment>> = paymentDao.getAllPayment()

    suspend fun insertPayment(payment: Payment) {
        paymentDao.insertPayment(payment)
    }

    suspend fun updatePayment(payment: Payment) {
        paymentDao.updatePayment(payment)
    }

    suspend fun deleteSinglePayment(payment: Payment) {
        paymentDao.deleteSinglePayment(payment)
    }

    suspend fun deleteAllPayment() {
        paymentDao.deleteAllPayment()
    }
}