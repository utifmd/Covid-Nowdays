package com.dudegenuine.covidnowdays.model.local

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.dudegenuine.covidnowdays.BuildConfig
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.adapter.MODEL_TYPE_TITLE
import java.lang.IllegalStateException

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
data class Header(
    val title: String? = null,
    val desc: String? = null,

    override val modelType: Int = MODEL_TYPE_TITLE
): ModelContract {

    val isHideTitle: Boolean =
        title == null

    val isHideDesc: Boolean =
        desc == null
}
