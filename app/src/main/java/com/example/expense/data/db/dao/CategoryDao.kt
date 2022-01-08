package com.example.expense.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expense.data.db.entities.Category
import com.example.expense.data.db.entities.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Query("DELETE FROM category_table")
    suspend fun deleteAllCategory()

    @Delete
    suspend fun deleteSingleCategory(category: Category)

    @Query("SELECT * FROM category_table")
    fun getAllCategory(): LiveData<List<Category>>

    @Query("SELECT * FROM category_table WHERE category LIKE :searchQuerry")
    fun searchPayment(searchQuerry: String): Flow<List<Category>>

}