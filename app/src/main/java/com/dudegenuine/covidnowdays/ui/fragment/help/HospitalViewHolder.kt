package com.dudegenuine.covidnowdays.ui.fragment.help

import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.databinding.ItemHospitalBinding
import com.dudegenuine.covidnowdays.databinding.ItemTitleBinding
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.ui.extension.ModelContract

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */
class HospitalViewHolder (
    val binding: ItemHospitalBinding,
    val listener: ModelContract.EventListener
): RecyclerView.ViewHolder(binding.root){

    fun bind(mHospital: Hospital) {
        binding.apply {
            hospital = mHospital

            root.apply {
                setOnClickListener { listener.onItemSelected(it, mHospital) }
            }
        }
    }
}