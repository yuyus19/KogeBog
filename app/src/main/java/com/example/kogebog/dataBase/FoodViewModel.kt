package com.example.kogebog.dataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Food>>
    private val repository: FoodRepository

    init {
        val foodDao = FoodDatabase.getDatabase(application).foodDao()
        repository = FoodRepository(foodDao)
        readAllData = repository.readAllData
    }

    fun addFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFood(food)
        }
    }
    fun updateFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFood(food)
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
    }
}