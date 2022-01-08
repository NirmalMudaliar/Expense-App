package com.example.expense.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.expense.R
import com.example.expense.databinding.FragmentStatsBinding


class StatsFragment : Fragment() {

    // Setup View Binding
    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setup View Binding
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val view = binding.root

        // Setup Toolbar
        setupActionBar()

        // Listener for back button
        backButton()

        return view
    }

    private fun backButton() {
        val backBtnStats = binding.backBtnStats
        backBtnStats.setOnClickListener {
            findNavController().navigate(R.id.action_statsFragment_to_homeFragment)
        }
    }

    private fun setupActionBar() {
        val tbStats = binding.tbStats
        if(activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(tbStats)
        }
    }

}