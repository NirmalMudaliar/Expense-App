package com.example.expense.data.repositories

import androidx.lifecycle.LiveData
import com.example.expense.data.db.dao.CategoryDao
import com.example.expense.data.db.entities.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val catDao: CategoryDao) {

    val getAllCategory: LiveData<List<Category>> = catDao.getAllCategory()

    suspend fun insertCategory(category: Category) {
        catDao.insertCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        catDao.updateCategory(category)
    }

    suspend fun deleteAllCategory() {
        catDao.deleteAllCategory()
    }

    suspend fun deleteSingleCategory(category: Category) {
        catDao.deleteSingleCategory(category)
    }

    fun searchPayment(searchQuery: String): Flow<List<Category>> {
        return catDao.searchPayment(searchQuery)
    }
}