package com.example.expense.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "payment_table")
data class Payment(

    @PrimaryKey(autoGenerate = true)
    val pid: Int,
    val payment: String
) : Parcelable
