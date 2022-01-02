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


class StatsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        val tbStats = view.findViewById<Toolbar>(R.id.tb_stats)
        if(activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(tbStats)
        }

        val backBtnStats = view.findViewById<ImageView>(R.id.backBtnStats)
        backBtnStats.setOnClickListener {
            findNavController().navigate(R.id.action_statsFragment_to_homeFragment)
        }

        return view
    }


}