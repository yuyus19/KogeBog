package com.example.kogebog.dataBase

import android.util.Log
import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val readAllData: LiveData<List<Food>> = foodDao.readAllData()

    suspend fun addFood(food: Food){
        foodDao.addFood((food))

    }

    suspend fun deleteAllFood(){
        foodDao.deleteAllFood()
    }

}