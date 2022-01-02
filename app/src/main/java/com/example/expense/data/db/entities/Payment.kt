package com.example.expense.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment_table")
data class Payment(

    @PrimaryKey(autoGenerate = true)
    val pid: Int,
    val payment: String
)
