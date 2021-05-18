package com.example.kogebog.EntityClass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favoritter")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "idcate")
    var idcate : Int,
    @ColumnInfo(name = "titel")
    var titel : String,
    @ColumnInfo(name = "ingredients")
    var ingredient : String

)
