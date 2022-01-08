package com.example.expense.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.example.expense.R
import com.example.expense.data.db.entities.Payment
import com.example.expense.data.viewModel.PaymentViewModel
import com.example.expense.databinding.FragmentUpdatePaymentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UpdatePaymentFragment : BottomSheetDialogFragment() {

    // Setup view binding
    private var _binding: FragmentUpdatePaymentBinding? = null
    private val binding get() = _binding!!

    private lateinit var paymentViewModel: PaymentViewModel

    private val args by navArgs<UpdatePaymentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdatePaymentBinding.inflate(inflater, container, false)
        val view = binding.root

        paymentViewModel = ViewModelProvider(this)[PaymentViewModel::class.java]

        // set Current Payment Text
        setCurrentPaymentText()

        //Listener for update button
        onUpdateClick()

        // Listener for delete single payment
        deleteSinglePayment()


        return view
    }

    private fun deleteSinglePayment() {
        binding.btnDelete.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes") {_, _ ->
                paymentViewModel.deleteSinglePayment(args.currentPayment)
                Toast.makeText(requireContext(), "Successfully deleted", Toast.LENGTH_LONG).show()
                clearText()
            }
            builder.setNegativeButton("No") {_, _ ->

            }
            builder.setTitle("Delete")
            builder.setMessage("Are you sure you want to delte ${args.currentPayment.payment}")
            builder.show()
        }
    }

    private fun setCurrentPaymentText() {
        binding.edtTieUpdatePayment.setText(args.currentPayment.payment)
    }

    private fun onUpdateClick() {
        binding.idBtnUpdatePayment.setOnClickListener {
            updatePayment()
        }
    }

    private fun updatePayment() {
        val newPayment = Payment(args.currentPayment.pid, binding.edtTieUpdatePayment.text.toString())
        paymentViewModel.updatePayment(newPayment)
        Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()

        // clear text
        clearText()
    }

    private fun clearText() {
        binding.edtTieUpdatePayment.setText(" ")
    }
}