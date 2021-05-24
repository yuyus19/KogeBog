package com.example.kogebog.dataBase

import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val readAllData: LiveData<List<Food>> = foodDao.readAllData()

    suspend fun addFood(food: Food){
        foodDao.addFood((food))

    }

    suspend fun updateFood(food: Food){
        foodDao.updateFood(food)
    }

    suspend fun deleteFood(food: Food){
        foodDao.deleteFood(food)
    }

    suspend fun deleteAllFood(){
        foodDao.deleteAllFood()
    }
    fun isFood(FoodTitle: String){
        foodDao.isFood(FoodTitle)
    }
}