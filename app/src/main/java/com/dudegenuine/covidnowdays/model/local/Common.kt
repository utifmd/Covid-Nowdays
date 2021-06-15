package com.dudegenuine.covidnowdays.model.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.adapter.MODEL_TYPE_COMMON

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
data class Common(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,

    val header: Header? = null,
    val faqs: List<CommonFaq?>? = null,
    val attachments: List<CommonAttachment?>? = null,

    override val modelType: Int = MODEL_TYPE_COMMON,
): ModelContract

data class CommonFaq(
    val answer: String,
    val question: String
)

data class CommonAttachment(
    val label: String,
    @DrawableRes val resImage: Int
)
