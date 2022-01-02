package com.example.expense.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.expense.R
import com.example.expense.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    // Setup View Binding
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setup View Binding
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        //Setup Action bar
        setupActionBar()

        val cvAddPayment = view?.findViewById<CardView>(R.id.id_cv_addPayment)

        // Listener for back button
        backButton()

        // Listener for cardView(AddCategory)
        onAddCategoryClick()

        //Listener for cardView(AddPayment)
        onAddPaymentClick()


        return view
    }

    private fun setupActionBar() {
        val tbSettings = binding.tbSettings
        if(activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(tbSettings)
        }
    }

    private fun backButton() {
        binding.backBtnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_homeFragment)
        }
    }

    private fun onAddCategoryClick() {
        binding.idCvAddCategory.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_addCategoryFragment)
        }
    }

    private fun onAddPaymentClick() {
        binding.idCvAddPayment.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_addPaymentFragment)
        }
    }



}