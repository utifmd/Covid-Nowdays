package com.dudegenuine.covidnowdays.model.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
data class ApiResponse<T>(
    @SerializedName("statusCode")
    val status: Int? = null,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("body")
    val data: T
): Serializable {
    /*val listData: List<T>
        get() = listOf()*/
}
