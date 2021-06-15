package com.dudegenuine.covidnowdays.ui.fragment.help.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.databinding.FragmentHelpDetailBinding
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.ui.fragment.help.HelpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Covid Nowdays created by utifmd on 09/06/21.
 */
class HelpDetailFragment : Fragment(R.layout.fragment_help_detail) {
    private val TAG: String = javaClass.simpleName
    private lateinit var binding: FragmentHelpDetailBinding
    private lateinit var hospital: Hospital
    private val helpViewModel: HelpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHelpDetailBinding.bind(view)
        hospital = requireArguments().getParcelable<Hospital>(KEY_HOSPITAL_MODEL) as Hospital

        binding.apply {
            helpViewModel = this@HelpDetailFragment.helpViewModel
            hospital = this@HelpDetailFragment.hospital
        }
    }

    companion object {
        const val KEY_HOSPITAL_MODEL = "key_hospital_model"
    }
}