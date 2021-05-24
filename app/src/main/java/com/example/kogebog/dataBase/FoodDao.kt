package com.example.kogebog.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFood(food: Food)

    @Query("SELECT * FROM food_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Food>>

    @Update
    suspend fun updateFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Query("DELETE FROM food_table")
    suspend fun deleteAllFood()

    @Query( "SELECT EXISTS(SELECT 1 FROM food_table WHERE  food_titel= :FoodTitle LIMIT 1)")
    fun isFood(FoodTitle: String) :Boolean




}