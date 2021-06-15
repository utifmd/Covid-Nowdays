package com.dudegenuine.covidnowdays.ui.fragment.informs

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.databinding.ItemNewsBinding
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.ui.extension.ModelContract

/**
 * Covid Nowdays created by utifmd on 12/06/21.
 */
class NewsViewHolder(
    val binding: ItemNewsBinding, // val items: List<ModelContract>,
    val listener: ModelContract.EventListener
): RecyclerView.ViewHolder(binding.root){

    fun bind(mNews: News) {
        binding.apply {
            news = mNews

            root.apply {
                setOnClickListener {
                    Log.d("NewsViewHolder", "onclick: triggered")

                    listener.onItemSelected(it, mNews)
                }
            }
        }
    }
}