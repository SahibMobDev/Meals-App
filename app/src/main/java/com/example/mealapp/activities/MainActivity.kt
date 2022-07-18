package com.example.mealapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.mealapp.R
import com.example.mealapp.databinding.ActivityMainBinding
import com.example.mealapp.db.MealDatabase
import com.example.mealapp.mvvm.HomeViewModel
import com.example.mealapp.mvvm.HomeViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by lazy {
        val mealDatabase = MealDatabase.getInstance(this)
        val homeViewModelFactory = HomeViewModelFactory(mealDatabase)
        ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.btmNav
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
}