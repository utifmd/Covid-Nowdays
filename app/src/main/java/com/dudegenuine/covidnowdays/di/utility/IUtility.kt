package com.dudegenuine.covidnowdays.di.utility

import android.content.Context

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */
interface IUtility {
    fun getStrPrettyIdr(item: Int): String
    fun getStrPrettyTime(item: Long): String
    fun getStrNormalIdr(item: Int): String
    fun getStrTitleCase(item: String): String
    fun getWidgetAlertMessage(context: Context, title: String, message: String)
    fun getWidgetShareText(context: Context, title: String, text: String)
}