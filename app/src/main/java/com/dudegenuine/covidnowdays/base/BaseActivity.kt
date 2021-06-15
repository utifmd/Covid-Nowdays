package com.dudegenuine.covidnowdays.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Covid Nowdays created by utifmd on 03/05/21.
 */
open class BaseActivity: AppCompatActivity() {
    protected inline fun <reified T: ViewDataBinding> binding(resId: Int): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, resId)
    }
}