package com.example.expense.data.viewModel

import android.app.Application
import androidx.lifecycle.*

import com.example.expense.data.db.ExpenseDatabase
import com.example.expense.data.db.entities.Category
import com.example.expense.data.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CategoryViewModel(application: Application) : AndroidViewModel(application){

    private val getAllCategory: LiveData<List<Category>>
    private val categoryRepository: CategoryRepository

    init {
        val catDao = ExpenseDatabase.getDatabase(application).getCategoryDao()
        categoryRepository = CategoryRepository(catDao)
        getAllCategory = categoryRepository.getAllCategory
    }

    fun getAllCategory(): LiveData<List<Category>> {
        return getAllCategory
    }

    fun insertCategory(category: Category){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.insertCategory(category)
        }

    }

    fun deleteSingleCategory(category: Category) = viewModelScope.launch {
        categoryRepository.deleteSingleCategory(category)
    }

    fun deleteAllCategory() = viewModelScope.launch {
        categoryRepository.deleteAllCategory()
    }

}
//
//class CategoryViewModelFacory(private val catRepository: CategoryRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return CategoryViewModel(catRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}