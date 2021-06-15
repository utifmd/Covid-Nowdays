package com.dudegenuine.covidnowdays.model.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
data class Province(
    @SerializedName("attributes")
    val attributes: AttrProvince? = null
): Serializable

data class AttrProvince(
    @SerializedName("FID")
    val fId: Int? = null,

    @SerializedName("Kode_Provi")
    val provinceCode: Int? = null,

    @SerializedName("Provinsi")
    val province: String? = null,

    @SerializedName("Kasus_Posi")
    val casePositive: Int? = null,

    @SerializedName("Kasus_Semb")
    val caseRecovered: Int? = null,

    @SerializedName("Kasus_Meni")
    val caseDeath: Int? = null
): Serializable
