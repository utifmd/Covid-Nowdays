package com.dudegenuine.covidnowdays.ui.extension.holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.databinding.ItemCommonBinding
import com.dudegenuine.covidnowdays.ui.extension.ModelContract

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
class CommonViewHolder(
    val binding: ItemCommonBinding,
    val listener: ModelContract.EventListener

): RecyclerView.ViewHolder(binding.root) {

    fun bind(mCommon: Common){
        binding.apply {
            common = mCommon

            root.apply {
                setOnClickListener {
                    listener.onItemSelected(this, mCommon)
                }
            }
        }
    }
}