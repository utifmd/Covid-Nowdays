package com.dudegenuine.covidnowdays.di

import com.dudegenuine.covidnowdays.ui.fragment.cases.CasesViewModel
import com.dudegenuine.covidnowdays.ui.fragment.help.HelpViewModel
import com.dudegenuine.covidnowdays.ui.fragment.informs.InformViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
val viewModelModule = module {
    viewModel { CasesViewModel(repository = get()) }
    viewModel { InformViewModel(repository = get()) }
    viewModel { HelpViewModel(repository = get()) }
}