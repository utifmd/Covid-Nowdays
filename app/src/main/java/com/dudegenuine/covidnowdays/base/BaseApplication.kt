package com.dudegenuine.covidnowdays.base

import android.app.Application
import com.dudegenuine.covidnowdays.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(dataSourceModule)
            modules(networkModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(preferencesModule)
            modules(utilityModule)
        }
    }
}