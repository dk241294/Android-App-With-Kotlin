package com.example.android.navigation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController=findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onNavigateUp(): Boolean {
        val navController=findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }

}