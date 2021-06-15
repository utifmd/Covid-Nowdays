package com.dudegenuine.covidnowdays.di.network

import com.dudegenuine.covidnowdays.di.network.IResponseHandler.Companion.TIMEOUT_CODE
import com.dudegenuine.covidnowdays.model.remote.Resource
import okhttp3.internal.http2.ErrorCode
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException

/**
 * Covid Nowdays created by utifmd on 15/06/21.
 */
class ResponseHandlerImpl: IResponseHandler {
    override fun <T> onSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    override fun <T> onException(exception: Exception): Resource<T> {
        return when(exception){
            is HttpException ->
                Resource.error(null, onErrorMessage(exception.code()) )
            is SocketTimeoutException ->
                Resource.error(null, onErrorMessage(TIMEOUT_CODE))
            else ->
                Resource.error(null, onErrorMessage(Int.MAX_VALUE))
        }
    }

    override fun onErrorMessage(code: Int): String {
        return when(code){
            TIMEOUT_CODE -> "Timeout"
            401 -> "Unauthorised"
            404 -> "Not Found"
            else -> "No Internet Connection" // "Something Went Wrong"
        }
    }
}