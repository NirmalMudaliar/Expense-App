package com.example.expense.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expense.R
import com.example.expense.data.adapters.ManagePaymentAdapter
import com.example.expense.data.viewModel.PaymentViewModel
import com.example.expense.databinding.FragmentManagePaymentBinding


class ManagePaymentFragment : Fragment() {

    private var _binding: FragmentManagePaymentBinding? = null
    private val binding get() = _binding!!

    private lateinit var paymentViewModel: PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManagePaymentBinding.inflate(inflater, container, false)
        val view = binding.root

        // Setup Action Bar
        setupActionBar()

        onBackClick()

        // Setup Recyclerview
        setUpRecyclerView()

        // Listener for extended floating button
        onAddPaymentClick()






        return view

    }

    private fun setupActionBar() {
        val tbManagePayment = binding.tbManagePayment
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(tbManagePayment)
        }

    }

    private fun onAddPaymentClick() {
        binding.fbAddPayment.setOnClickListener {
            findNavController().navigate(R.id.action_managePaymentFragment_to_addPaymentFragment)
        }
    }

    private fun setUpRecyclerView() {
        val rcyManagePayment = binding.rcyManagePayment
        val adapter = ManagePaymentAdapter()
        rcyManagePayment.adapter = adapter
        rcyManagePayment.layoutManager = LinearLayoutManager(requireContext())
        rcyManagePayment.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        paymentViewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        paymentViewModel.getAllPayment.observe(viewLifecycleOwner, Observer { payment ->
            adapter.setData(payment)
        })
    }

    private fun onBackClick() {
        binding.backBtnManagePayment.setOnClickListener {
            findNavController().navigate(R.id.action_managePaymentFragment_to_settingsFragment)
        }
    }
}