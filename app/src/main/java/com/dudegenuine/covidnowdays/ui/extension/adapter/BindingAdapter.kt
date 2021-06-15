package com.dudegenuine.covidnowdays.ui.extension

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData
import com.dudegenuine.covidnowdays.ui.extension.adapter.ModelAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Covid Nowdays created by utifmd on 04/05/21.
 */
@BindingAdapter("bind:provinceAdapter", "bind:provinceListener")
fun setProvincesAdapter(
    view: AutoCompleteTextView,
    govCovidData: GovCovidData?,
    listener: (CovidItem) -> Unit
){
    govCovidData?.listData?.let { list ->
        view.apply {
            setAdapter( ArrayAdapter(view.context, android.R.layout.simple_list_item_activated_1, list.map { it?.key }) )
            setOnItemClickListener { _, _, position, _ ->
                listener.invoke(list[position] ?: CovidItem())
            }
            clearFocus()
        }
    }
}

@BindingAdapter("bind:hospitalAdapter", "bind:helpListener")
fun setHospitalAdapter(
    view: RecyclerView,
    hospitals: List<Hospital>?,
    listener: ModelContract.EventListener
){
    view.apply {
        val mAdapter = ModelAdapter (mutableListOf(
                Header(title = resources.getString(R.string.help_title), desc = resources.getString(R.string.desc_hospital)),
                Common(label = R.string.label_hospital, icon = R.drawable._05_first_aid_kit),
                Header(title = hospitals?.first()?.province, desc = resources.getString(R.string.desc_help))
        ), listener)

        adapter = mAdapter
        hospitals?.apply {
            mAdapter.pushData(this)
        }
    }
}

@BindingAdapter("bind:newsAdapter", "bind:newsListener")
fun setNewsAdapter(
    view: RecyclerView,
    newsList: List<News>?,
    listener: ModelContract.EventListener
){
    view.apply {
        val mAdapter = ModelAdapter (mutableListOf( /*Header(title = resources.getString(R.string.info_title), desc = resources.getString(R.string.desc_info)), Common(label = R.string.label_mengenal, icon = R.drawable.mask), Common(label = R.string.label_mencegah, icon = R.drawable.wash_your_hands),*/
            Header(title = resources.getString(R.string.news_title), resources.getString(R.string.desc_news))
        ), listener)

        adapter = mAdapter
        newsList?.apply {
            mAdapter.pushData(this)
        }
    }
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.apply {
        adapter = baseAdapter
    }
}

@BindingAdapter("bind:detailToolbar")
fun setToolbar(view: Toolbar, mTitle: String){
    (view.context as AppCompatActivity).apply {
        setSupportActionBar(view)

    }.supportActionBar?.apply {
        setDisplayShowHomeEnabled(true)
        setDisplayHomeAsUpEnabled(true)

        title = mTitle
    }
    view.setNavigationOnClickListener {
        Navigation.findNavController(view).navigateUp()
    }
}

@BindingAdapter("bind:popUpMenu", "bind:popUpListener")
fun setPopupMenuAdapter(
    view: FloatingActionButton, haveButton: Boolean,
    listener: (View, MenuItem) -> Boolean){
    if (!haveButton) return

    view.setOnClickListener {
        PopupMenu(view.context, view).apply {
            inflate(R.menu.more_menu)
            setOnMenuItemClickListener{ menuItem -> listener(it, menuItem) }
            show()
        }
    }
}

@BindingAdapter("bind:src")
fun setImageViewResource(view: ImageView, @DrawableRes resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("bind:marquee")
fun setImageViewResource(view: TextView, value: Boolean) {
    view.isSelected = value
}

@BindingAdapter("bind:webView")
fun setWebView(view: WebView, url: String){
    view.apply {
        val progress = ProgressBar(view.context).apply {
            setPadding(6, 6, 6, 6)
        }

        val client = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                addView(progress)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                removeView(progress)
            }
        }

        settings.apply {
            userAgentString = resources.getString(R.string.mobile_user_agent)
            domStorageEnabled = true
            webViewClient = client
        }

        loadUrl(url)
    }
}

/*
* Extension functions
* */
fun ViewModel.navigate(view: View, direction: NavDirections){
    Navigation.findNavController(view).navigate(direction)
}
fun ViewModel.navigateUp(view: View){
    Navigation.findNavController(view).navigateUp()
}

/*
fun Toolbar.changeToolbarFont(){
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if (view is TextView && view.text == title) {
            view.typeface = Typeface.createFromAsset(view.context.assets, "fonts/customFont")
            break
        }
    }
}
* */

