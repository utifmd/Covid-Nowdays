package com.dudegenuine.covidnowdays.ui.fragment.cases.detail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.databinding.FragmentCaseDetailBinding
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
/**
 * Covid Nowdays created by utifmd on 09/06/21.
 */
class CaseDetailFragment : Fragment(R.layout.fragment_case_detail) {
    private val TAG: String = javaClass.simpleName
    private lateinit var binding: FragmentCaseDetailBinding
    private lateinit var covidItem: CovidItem

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCaseDetailBinding.bind(view)
        covidItem = requireArguments().getSerializable(KEY_COVID_MODEL) as CovidItem

        binding.apply {
            lifecycleOwner = this@CaseDetailFragment
            covidItem = this@CaseDetailFragment.covidItem
            headerGender = Header(
                title = resources.getString(R.string.gender),
                desc = resources.getString(R.string.desc_gender))
            headerAgeScope = Header(
                title = resources.getString(R.string.age_scope),
                desc = resources.getString(R.string.desc_age_scope))
            headerUpdate = Header(
                title = resources.getString(R.string.preview_covid_update),
                desc = covidItem?.viewDescHeader)
        }
    }

    companion object{
        const val KEY_COVID_MODEL = "key_covid_model"
    }
}