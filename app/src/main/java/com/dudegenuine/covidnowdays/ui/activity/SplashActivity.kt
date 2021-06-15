package com.dudegenuine.covidnowdays.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dudegenuine.covidnowdays.ui.fragment.cases.CasesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Covid Nowdays created by utifmd on 13/06/21.
 */
class SplashActivity: AppCompatActivity() {
    private val TAG: String = javaClass.simpleName
    private val casesViewModel: CasesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        casesViewModel.officialCovidData.observe(this, {
            startActivity(
                Intent(this, MainActivity::class.java)
            ).apply {
                finish()
            }
        })
    }
}