package com.example.kogebog.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food_table")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titel: String,
    val ingredients: String,
    val procedure: String
)
