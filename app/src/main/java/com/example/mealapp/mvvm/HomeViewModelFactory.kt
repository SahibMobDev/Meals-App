package com.example.mealapp.mvvm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mealapp.db.MealDatabase

class HomeViewModelFactory(private val mealDatabase: MealDatabase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return HomeViewModel(mealDatabase) as T
    }
}