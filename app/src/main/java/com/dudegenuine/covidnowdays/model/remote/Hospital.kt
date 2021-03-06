package com.dudegenuine.covidnowdays.model.remote

import android.os.Parcel
import android.os.Parcelable
import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.adapter.MODEL_TYPE_HOSPITAL
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */

// @Parcelize ~> Experimental
data class Hospital(
    val address: String? = null,

    val province: String? = null,

    val phone: String? = null,

    val name: String? = null,

    val region: String? = null,

    override val modelType: Int = MODEL_TYPE_HOSPITAL

): Parcelable, KoinComponent, ModelContract {
    private val utility: IUtility by inject()

    val viewHospitalDetail: String
        get() = "$name, ${utility.getStrTitleCase(region ?: "")}, ${utility.getStrTitleCase(address ?: "")}, $province, Indonesia."

    val viewName: String
        get() = utility.getStrTitleCase(name ?: "")

    /*
    private val nameMaxLen = 16
    val previewHospitalName: String
        get() = """
            Nama        : ${if (name!!.length > nameMaxLen) utility.getStrTitleCase(name.substring(0..nameMaxLen).trim()+"..") else utility.getStrTitleCase(name)}
            Region      : ${region?.lowercase()?.replaceFirstChar { it.titlecase(Locale.getDefault()) }}
        """.trimIndent()*/

    /*GENERATED by Parcelable*/
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(province)
        parcel.writeString(phone)
        parcel.writeString(name)
        parcel.writeString(region)
        parcel.writeInt(modelType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hospital> {
        override fun createFromParcel(parcel: Parcel): Hospital {
            return Hospital(parcel)
        }

        override fun newArray(size: Int): Array<Hospital?> {
            return arrayOfNulls(size)
        }
    }
}
