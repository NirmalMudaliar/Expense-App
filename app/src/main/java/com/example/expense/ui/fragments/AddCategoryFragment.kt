package com.example.expense.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.expense.R
import com.example.expense.data.db.entities.Category
import com.example.expense.data.viewModel.CategoryViewModel
import com.example.expense.databinding.FragmentAddCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class AddCategoryFragment : BottomSheetDialogFragment() {
    //setup view binding
    private var _binding: FragmentAddCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryViewModel: CategoryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Setup view binding
        _binding = FragmentAddCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        // Listener of Submit Category button
        onSubmitClick()

        return view
    }
    private fun onSubmitClick() {
        binding.idBtnAddCategory.setOnClickListener {
            insertCategoryToDatabase()
        }

    }
    private fun insertCategoryToDatabase() {

        val dataCategory = binding.idEdtTieCategory.text.toString()
        val category = Category(0, dataCategory)

        categoryViewModel.insertCategory(category)
        Log.d("NEW CATEGORY -> ", dataCategory)
        Toast.makeText(requireContext(), "Successfully added to database", Toast.LENGTH_LONG).show()
        binding.idEdtTieCategory.setText("")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}