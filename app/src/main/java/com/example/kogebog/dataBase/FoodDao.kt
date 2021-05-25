package com.example.kogebog.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodDao {
    //Our database queries
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFood(food: Food)

    @Query("SELECT * FROM food_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Food>>

    @Query("DELETE FROM food_table")
    suspend fun deleteAllFood()






}