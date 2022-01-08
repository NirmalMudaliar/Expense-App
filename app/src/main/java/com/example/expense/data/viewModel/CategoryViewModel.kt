package com.example.expense.data.viewModel

import android.app.Application
import androidx.lifecycle.*

import com.example.expense.data.db.ExpenseDatabase
import com.example.expense.data.db.entities.Category
import com.example.expense.data.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CategoryViewModel(application: Application) : AndroidViewModel(application){

    val getAllCategory: LiveData<List<Category>>
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
    fun updateCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.updateCategory(category)
        }
    }

//    hello
    fun deleteSingleCategory(category: Category) = viewModelScope.launch {
        categoryRepository.deleteSingleCategory(category)
    }

    fun deleteAllCategory() = viewModelScope.launch {
        categoryRepository.deleteAllCategory()
    }

    fun searchPayment(searchQuery: String): LiveData<List<Category>> {
        return categoryRepository.searchPayment(searchQuery).asLiveData()
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