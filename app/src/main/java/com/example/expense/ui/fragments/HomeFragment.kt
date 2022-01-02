package com.example.expense.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.expense.R
import com.example.expense.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    // Setup View Binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Setup View Binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // On floating button pressed
        onFbClick()
        return view
    }

    private fun onFbClick() {
        binding.floatingActionButton.setOnClickListener {
            //TODO
        }
    }


}