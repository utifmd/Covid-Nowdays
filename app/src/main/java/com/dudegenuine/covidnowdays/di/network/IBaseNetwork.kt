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

    companion object {
        const val CONNECT_TIMEOUT = 10L
        const val WRITE_TIMEOUT = 1L
        const val READ_TIMEOUT = 20L
    }
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
