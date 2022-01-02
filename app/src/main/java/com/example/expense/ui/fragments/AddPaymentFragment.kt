package com.example.expense.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.expense.R
import com.example.expense.data.db.entities.Payment
import com.example.expense.data.viewModel.PaymentViewModel
import com.example.expense.databinding.FragmentAddPaymentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText


class AddPaymentFragment : BottomSheetDialogFragment() {

    // Setup View Binding
    private var _binding: FragmentAddPaymentBinding? = null
    private val binding get() = _binding!!

    private lateinit var paymentViewModel: PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setup View Binding
        _binding = FragmentAddPaymentBinding.inflate(inflater, container, false)
        val view = binding.root

        paymentViewModel = ViewModelProvider(this)[PaymentViewModel::class.java]


        // Listener for Submit Payment button
        onSubmitClick()

        return view
    }

    private fun onSubmitClick() {
        binding.idBtnAddPayment.setOnClickListener {
            insertPayment()
        }
    }

    private fun insertPayment() {
        val dataPayment = binding.idEdtTiePayment.text.toString()
        val payment = Payment(0, dataPayment)

        paymentViewModel.insertPayment(payment)
        Log.d("NEW PAMENT ->", dataPayment)
        Toast.makeText(requireContext(), "Successfully inserted payment!", Toast.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}