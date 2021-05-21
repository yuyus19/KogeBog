package com.example.kogebog.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class entity(
   @PrimaryKey
    var uid: Int = 0,
   @ColumnInfo
   var name : String? = null,
   @ColumnInfo
   var address : String? = null,
   @ColumnInfo
   var dateOfBirth: Long = 0
)
