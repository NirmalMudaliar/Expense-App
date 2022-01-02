package com.example.expense.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String
)