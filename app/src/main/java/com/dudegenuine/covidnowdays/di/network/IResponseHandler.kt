package com.dudegenuine.covidnowdays.di.network

import com.dudegenuine.covidnowdays.model.remote.Resource
import java.lang.Exception

/**
 * Covid Nowdays created by utifmd on 15/06/21.
 */
interface IResponseHandler {
    fun<T> onSuccess(data: T): Resource<T>
    fun<T> onException(exception: Exception) : Resource<T>
    fun onErrorMessage(code: Int): String

    companion object{
        const val TIMEOUT_CODE: Int = 33313
    }
}