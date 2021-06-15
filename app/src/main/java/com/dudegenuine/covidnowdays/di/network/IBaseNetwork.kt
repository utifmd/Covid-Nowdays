package com.dudegenuine.covidnowdays.di.network

import com.dudegenuine.covidnowdays.data.api.ICoronaService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */

interface IBaseNetwork{
    fun builder(): Retrofit.Builder
    fun client(): OkHttpClient
}

/*
interface INetworks {

    interface IThirdPartyNetwork{
        fun getRetrofit(): Retrofit.Builder
    }

    interface IService{
        fun getService(): ICoronaService
    }
} */
