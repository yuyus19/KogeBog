package com.example.kogebog.dataBase

import android.provider.UserDictionary
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
@Query("SELECT * FROM user")
fun getAlphabetizedWords() : List<UserDictionary.Words>
@Insert (onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(words: UserDictionary.Words)
@Query("DELETE FROM user")
suspend fun deleteAll()
}