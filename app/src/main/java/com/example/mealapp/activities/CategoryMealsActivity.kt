package com.example.mealapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealapp.R
import com.example.mealapp.adapters.CategoryMealsAdapter
import com.example.mealapp.databinding.ActivityCategoryMealsBinding
import com.example.mealapp.fragments.HomeFragment
import com.example.mealapp.mvvm.CategoriesMealsViewModel

class CategoryMealsActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryMealsBinding
    lateinit var categoryMealsViewModel: CategoriesMealsViewModel
    lateinit var categoryMealsAdapter : CategoryMealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        categoryMealsViewModel = ViewModelProvider(this)[CategoriesMealsViewModel:: class.java]

        categoryMealsViewModel.getMealsByCategory(intent.getStringExtra(HomeFragment.CATEGORY_NAME)!!)

        categoryMealsViewModel.observeCategoriesMealsLiveData().observe(this, Observer {
            mealList ->
            binding.tvCategoryCount.text = mealList.size.toString()
            categoryMealsAdapter.setMealList(mealList)
        })
    }

    private fun prepareRecyclerView() {
        categoryMealsAdapter = CategoryMealsAdapter()
        binding.rvMeals.apply {
            layoutManager = GridLayoutManager(context, 2,GridLayoutManager.VERTICAL, false)
            adapter = categoryMealsAdapter
        }
    }
}