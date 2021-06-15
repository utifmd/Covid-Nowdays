package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.data.remote.IRemoteDataSource
import com.dudegenuine.covidnowdays.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
val dataSourceModule = module {
    single<IRemoteDataSource> { RemoteDataSourceImpl(service = get()) }
}