package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.di.preference.IPreferences
import com.dudegenuine.covidnowdays.di.preference.PreferencesIml
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 09/06/21.
 */

val preferencesModule = module {
    single<IPreferences> { PreferencesIml(application = androidApplication()) }
}