package com.example.expense.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expense.R
import com.example.expense.data.adapters.ManageCategoryAdapter
import com.example.expense.data.viewModel.CategoryViewModel
import com.example.expense.databinding.FragmentManageCategoryBinding

class ManageCategoryFragment : Fragment() {

    // Setup View Binding
    private var _binding: FragmentManageCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Setup View Binding
        _binding = FragmentManageCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        // SetUp Action Bar
        setUpActionBar()

        // Listener for back button
        onBackClick()

        setupRecylerView()

        // Listener for AddCategory floating button
        onAddCategoryClick()

        return view
    }

    private fun onAddCategoryClick() {
        binding.fbAddCategory.setOnClickListener {
            findNavController().navigate(R.id.action_manageCategoryFragment_to_addCategoryFragment)
        }
    }

    private fun onBackClick() {
        binding.backBtnManageCategory.setOnClickListener {
            findNavController().navigate(R.id.action_manageCategoryFragment_to_settingsFragment)
        }
    }

    private fun setUpActionBar() {
        val tbManageCategory = binding.tbManageCategory
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(tbManageCategory)
        }
    }

    private fun setupRecylerView() {
        val rcyManageCategory = binding.rcyManageCategory
        val adapter = ManageCategoryAdapter()
        rcyManageCategory.adapter = adapter
        rcyManageCategory.layoutManager = LinearLayoutManager(requireContext())
        rcyManageCategory.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        categoryViewModel.getAllCategory.observe(viewLifecycleOwner, Observer {category->
            adapter.setData(category)
        })
    }


}