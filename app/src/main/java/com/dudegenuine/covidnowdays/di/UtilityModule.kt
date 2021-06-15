package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.dudegenuine.covidnowdays.di.utility.UtilityIml
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */

val utilityModule = module {
    factory<IUtility> { UtilityIml(androidContext = get()) }
}