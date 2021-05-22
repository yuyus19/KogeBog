package com.example.kogebog.dataBase

import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val readAllData: LiveData<List<Food>> = FoodDao.readALLData()

    suspend fun addFood(food: Food){
        foodDao.addFood((food))

    }
}