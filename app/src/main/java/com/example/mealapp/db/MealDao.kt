package com.example.mealapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mealapp.pojo.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun upsert(meal: Meal)

    @Delete
 fun delete(meal: Meal)

    @Query("SELECT * FROM mealInformation")
    fun getAllMeal(): LiveData<List<Meal>>
}