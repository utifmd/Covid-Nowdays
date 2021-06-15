package com.dudegenuine.covidnowdays.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dudegenuine.covidnowdays.model.remote.Status
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

        casesViewModel.officialCovid.observe(this, {
            val starting = Intent(this@SplashActivity, MainActivity::class.java)
            when(it.status){
                Status.LOADING -> Log.d(TAG, "onCreate: loading..")
                else -> startActivity( starting ).apply { finish() }
            }
        })
    }
}