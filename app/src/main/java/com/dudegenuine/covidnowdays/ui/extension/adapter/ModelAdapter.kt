package com.dudegenuine.covidnowdays.ui.extension.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.databinding.ItemCommonBinding
import com.dudegenuine.covidnowdays.databinding.ItemHospitalBinding
import com.dudegenuine.covidnowdays.databinding.ItemNewsBinding
import com.dudegenuine.covidnowdays.databinding.ItemTitleBinding
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.holder.CommonViewHolder
import com.dudegenuine.covidnowdays.ui.extension.holder.TitleViewHolder
import com.dudegenuine.covidnowdays.ui.fragment.help.HospitalViewHolder
import com.dudegenuine.covidnowdays.ui.fragment.informs.NewsViewHolder

/**
 * Covid Nowdays created by utifmd on 08/05/21.
 */

const val MODEL_TYPE_TITLE = 101
const val MODEL_TYPE_COMMON = 102
const val MODEL_TYPE_NEWS = 103
const val MODEL_TYPE_HOSPITAL = 104

class ModelAdapter(
    private var items: List<ModelContract>,
    private val listener: ModelContract.EventListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            MODEL_TYPE_TITLE -> TitleViewHolder(
                ItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false), listener )
            MODEL_TYPE_COMMON -> CommonViewHolder(
                ItemCommonBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false), listener )
            MODEL_TYPE_HOSPITAL -> HospitalViewHolder(
                ItemHospitalBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false), listener )
            MODEL_TYPE_NEWS -> NewsViewHolder(
                ItemNewsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false), listener )
            else -> throw IllegalStateException("Invalid viewHolder!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(items[position] as Header)
            is CommonViewHolder -> holder.bind(items[position] as Common)
            is HospitalViewHolder -> holder.bind(items[position] as Hospital)
            is NewsViewHolder -> holder.bind(items[position] as News)
            else -> throw IllegalStateException("Invalid viewType!")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].modelType
    }

    fun pushData(list: List<ModelContract>) {
        items += list
    }
}