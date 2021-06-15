package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.data.repository.IRepository
import com.dudegenuine.covidnowdays.data.repository.RepositoryImpl
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
val repositoryModule = module {
    single<IRepository> { RepositoryImpl(dataSource = get(), prefs = get()) }
}