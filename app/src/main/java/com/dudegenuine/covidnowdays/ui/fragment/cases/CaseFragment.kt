package com.dudegenuine.covidnowdays.ui.fragment.cases

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.databinding.FragmentCaseBinding
import com.dudegenuine.covidnowdays.ui.extension.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Covid Nowdays created by utifmd on 03/05/21.
 */
class CaseFragment : Fragment(R.layout.fragment_case) {
    private val TAG: String = javaClass.name

    private val mViewModel: CasesViewModel by viewModel()
    private lateinit var binding: FragmentCaseBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCaseBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@CaseFragment
            caseViewModel = this@CaseFragment.mViewModel
        }
    }
}