package com.dudegenuine.covidnowdays.model.remote

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.adapter.MODEL_TYPE_NEWS
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
data class News(
    val title: String? = null, // @DrawableRes val thumbnail: Int,
    val url: String? = null,
    val timestamp: Long? = null,

    override val modelType: Int = MODEL_TYPE_NEWS

): ModelContract, Parcelable, KoinComponent {
    val utility: IUtility by inject()

    val viewTime: String get() = utility.getStrPrettyTime(timestamp ?: Date().time)

    /* GENERATED */
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeValue(timestamp)
        parcel.writeInt(modelType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }
}
