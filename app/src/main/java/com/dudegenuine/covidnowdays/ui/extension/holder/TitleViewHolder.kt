package com.dudegenuine.covidnowdays.ui.extension.holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.databinding.ItemTitleBinding
import com.dudegenuine.covidnowdays.ui.extension.ModelContract

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */
class TitleViewHolder(
    val binding: ItemTitleBinding,
    val listener: ModelContract.EventListener
): RecyclerView.ViewHolder(binding.root){

    fun bind(mHeader: Header) {
        binding.apply {
            header = mHeader

            root.apply {
                setOnClickListener { listener.onItemSelected(this, mHeader) }
            }
        }
    }
}