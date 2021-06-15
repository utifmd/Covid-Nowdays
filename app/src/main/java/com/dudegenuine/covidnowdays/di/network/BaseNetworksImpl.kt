package com.dudegenuine.covidnowdays.di.network

import com.dudegenuine.covidnowdays.BuildConfig
import com.dudegenuine.covidnowdays.di.network.IBaseNetwork.Companion.CONNECT_TIMEOUT
import com.dudegenuine.covidnowdays.di.network.IBaseNetwork.Companion.READ_TIMEOUT
import com.dudegenuine.covidnowdays.di.network.IBaseNetwork.Companion.WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */

class BaseNetworksImpl(
    private val baseUrl: String

    ): IBaseNetwork {

    override fun builder(): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }

    override fun client(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            if (BuildConfig.DEBUG){
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()
    }
}

/*class ThirdPartyNetworkImpl(
    private val client: OkHttpClient,
    private val baseUrl: String): INetworks.IThirdPartyNetwork {

    override fun getRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
    }
}*/
