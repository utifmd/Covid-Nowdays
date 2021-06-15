package com.dudegenuine.covidnowdays.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.base.BaseActivity
import com.dudegenuine.covidnowdays.databinding.ActivityMainBinding

// TODO: 12/06/21
/*
* -[x] Handle Internet
* -[] Handle onBack WebView
* -[] Handle Share App
* -[] Warning Build
* */
class MainActivity: BaseActivity() {
    val TAG: String = javaClass.name
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding.apply {
            lifecycleOwner = this@MainActivity

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
            val navController = navHostFragment.navController

            binding.bottomNavigationView.apply {
                setupWithNavController(navController)
                setOnNavigationItemReselectedListener { Log.d(TAG, "onCreate: navReselected.") }
            }
        }
    }
}