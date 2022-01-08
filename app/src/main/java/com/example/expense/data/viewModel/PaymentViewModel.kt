package com.example.expense.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expense.data.db.ExpenseDatabase
import com.example.expense.data.db.entities.Payment
import com.example.expense.data.repositories.PaymentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaymentViewModel(application: Application): AndroidViewModel(application) {

    val getAllPayment: LiveData<List<Payment>>
    private val paymentRepository: PaymentRepository

    init {
        val paymentDao = ExpenseDatabase.getDatabase(application).getPaymentDao()
        paymentRepository = PaymentRepository(paymentDao)
        getAllPayment = paymentRepository.getAllPayment
    }

    fun insertPayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        paymentRepository.insertPayment(payment)
    }

    fun updatePayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        paymentRepository.updatePayment(payment)
    }

    fun deleteSinglePayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        paymentRepository.deleteSinglePayment(payment)
    }

    suspend fun deleteAllPayment() = viewModelScope.launch(Dispatchers.IO) {
        paymentRepository.deleteAllPayment()
    }
}