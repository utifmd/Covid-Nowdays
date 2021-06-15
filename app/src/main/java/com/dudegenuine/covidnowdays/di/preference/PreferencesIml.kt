package com.dudegenuine.covidnowdays.di.preference

import android.app.Application
import android.content.SharedPreferences

/**
 * Covid Nowdays created by utifmd on 09/06/21.
 */
class PreferencesIml(
    val application: Application

): IPreferences {
    override fun prefs(): SharedPreferences =
        application.getSharedPreferences(IPreferences.DEFAULT, android.content.Context.MODE_PRIVATE)

    override fun editor(): SharedPreferences.Editor =
        prefs().edit()
}