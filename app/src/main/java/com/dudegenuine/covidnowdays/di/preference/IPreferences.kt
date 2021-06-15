package com.dudegenuine.covidnowdays.di.preference

import android.app.Application
import android.content.SharedPreferences

/**
 * Covid Nowdays created by utifmd on 09/06/21.
 */
interface IPreferences {
    fun prefs(): SharedPreferences
    fun editor(): SharedPreferences.Editor

    companion object{
        const val DEFAULT = "default"
        const val PREFS_PROVINCE_NAME = "prefs_province_name"
    }
}