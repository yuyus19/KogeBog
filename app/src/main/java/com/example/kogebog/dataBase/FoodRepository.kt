package com.example.kogebog.dataBase

import android.util.Log
import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    val readAllData: LiveData<List<Food>> = foodDao.readAllData()


   suspend fun isFood(FoodTitle: String): Boolean{
        Log.i("isFood_repository","This was activated in runtime")
        return foodDao.isFood(FoodTitle)
    }

    suspend fun addFood(food: Food){
        foodDao.addFood((food))

    }



    suspend fun deleteFood(food: Food){
        foodDao.deleteFood(food)
    }

    suspend fun deleteAllFood(){
        foodDao.deleteAllFood()
    }

}