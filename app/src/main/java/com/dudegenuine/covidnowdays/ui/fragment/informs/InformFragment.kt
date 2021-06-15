package com.dudegenuine.covidnowdays.ui.fragment.informs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.databinding.FragmentInformBinding
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.adapter.ModelAdapter
import com.dudegenuine.covidnowdays.ui.fragment.help.HelpFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Covid Nowdays created by utifmd on 03/05/21.
 */

class InformFragment: Fragment(R.layout.fragment_inform) {
    private val TAG = javaClass.simpleName
    private lateinit var binding: FragmentInformBinding
    private val viewModel: InformViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@InformFragment
            informViewModel = this@InformFragment.viewModel
        }
    }
}