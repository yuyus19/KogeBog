package com.example.kogebog.dataBase

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch




class FoodViewModel(application: Application): AndroidViewModel(application) {
    var is_Food: Boolean = false
    val readAllData: LiveData<List<Food>>
    private val repository: FoodRepository

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()
        repository = FoodRepository(foodDao)
        readAllData = repository.readAllData
        Log.i("init_foodviewModel","This was activated in runtime")

    }


     fun isFood(FoodTitle: String): kotlin.Boolean {
         viewModelScope.launch(Dispatchers.IO) {
            is_Food = repository.isFood(FoodTitle)
         }
         return is_Food
    }

    fun addFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFood(food)
        }
    }


    fun deleteFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFood(food)
        }
    }

    fun deleteAllFood(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFood()
        }


    }}
