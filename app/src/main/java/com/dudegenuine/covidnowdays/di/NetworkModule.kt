package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.BuildConfig
import com.dudegenuine.covidnowdays.data.api.ICoronaService
import com.dudegenuine.covidnowdays.di.network.BaseNetworksImpl
import com.dudegenuine.covidnowdays.di.network.IBaseNetwork
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */

val networkModule = module {

    single<IBaseNetwork> {
        BaseNetworksImpl(BuildConfig.BASE_URL)
    }

    single{
        get<IBaseNetwork>().builder().build().create(ICoronaService::class.java)
    }

    /*single<INetworks.IThirdPartyNetwork> {
        ThirdPartyNetworkImpl(get(), BuildConfig.BASE_URL_UNOFFICIAL_FIRST)
    }*/
}