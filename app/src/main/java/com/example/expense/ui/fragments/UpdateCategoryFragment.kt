package com.example.expense.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.expense.data.db.entities.Category
import com.example.expense.data.viewModel.CategoryViewModel

import com.example.expense.databinding.FragmentUpdateCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class UpdateCategoryFragment : BottomSheetDialogFragment() {

    //Setup view binding
    private var _binding: FragmentUpdateCategoryBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<UpdateCategoryFragmentArgs>()

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Setup view binding
        _binding = FragmentUpdateCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        // Placing clicked category inside edittext
        setCurrentCategoryText()

        // Listener for submit button
        onSubmitClick()

        // Listener for delete button
        deleteSingleCategory()


        return view
    }

    private fun onSubmitClick() {
        binding.idBtnUpdateCategory.setOnClickListener {
            updateCategory()
        }
    }

    private fun updateCategory() {
        val newText = binding.edtTieUpdateCategory.text.toString()
        val newCategory = Category(args.currentCategory.id, newText)
        categoryViewModel.updateCategory(newCategory)
        Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()

        //clear text
        clearText()

    }

    private fun setCurrentCategoryText() {
        binding.edtTieUpdateCategory.setText(args.currentCategory.category)
    }

    private fun deleteSingleCategory() {
        binding.btnDelete.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes") {_, _ ->
                categoryViewModel.deleteSingleCategory(args.currentCategory)
                Toast.makeText(requireContext(), "Successfully deleted", Toast.LENGTH_LONG).show()
                clearText()
            }
            builder.setNegativeButton("No") {_, _ ->

            }
            builder.setTitle("Delete")
            builder.setMessage("Are you sure you want to delete ${args.currentCategory.category}?")
            builder.create().show()
        }
    }

    private fun clearText() {
        binding.edtTieUpdateCategory.setText(" ")
    }

}