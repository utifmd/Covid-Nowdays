package com.dudegenuine.covidnowdays.ui.extension

import android.view.View
import java.io.Serializable

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
interface ModelContract{
    val modelType: Int

    interface EventListener {
        fun onItemSelected(view: View, modelContract: ModelContract)
    }
}