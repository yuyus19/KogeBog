package com.example.kogebog.dataBase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//our database table

@Entity(tableName = "food_table")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="food_titel") val FoodTitle: String,
    val ingredients: String,
    val procedure: String,

    )
