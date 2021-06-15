package com.dudegenuine.covidnowdays.ui.extension

import android.graphics.Rect
import android.view.View
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView

/**
 * Covid Nowdays created by utifmd on 06/05/21.
 */
class OptionItemDecoration(private val largePadding: Int, private val smallPadding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = smallPadding
        outRect.right = largePadding
        outRect.top = smallPadding
    }
}