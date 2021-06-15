package com.dudegenuine.covidnowdays.ui.fragment.help

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.databinding.FragmentHelpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Covid Nowdays created by utifmd on 03/05/21.
 */
class HelpFragment: Fragment(R.layout.fragment_help) {
    private val TAG = javaClass.simpleName
    lateinit var binding: FragmentHelpBinding
    private val viewModel: HelpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHelpBinding.bind(view)

        binding.apply {

            lifecycleOwner = this@HelpFragment
            viewModel = this@HelpFragment.viewModel
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.more_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about -> Log.d(TAG, "onOptionsItemSelected: about")
            R.id.share -> Log.d(TAG, "onOptionsItemSelected: share")
        }
        return super.onOptionsItemSelected(item)
    }
}