package com.dudegenuine.covidnowdays.ui.fragment.informs.detail

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.databinding.FragmentInformDetailBinding
import com.dudegenuine.covidnowdays.model.remote.News

/**
 * Covid Nowdays created by utifmd on 12/06/21.
 */
class InformDetailFragment: Fragment(R.layout.fragment_inform_detail) {
    private val TAG: String = javaClass.simpleName
    private lateinit var binding: FragmentInformDetailBinding
    private lateinit var news: News

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformDetailBinding.bind(view)
        news = requireArguments().getParcelable<News>(KEY_NEW_MODEL) as News

        binding.apply {
            lifecycleOwner = this@InformDetailFragment
            news = this@InformDetailFragment.news

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
                object: OnBackPressedCallback(true){
                    override fun handleOnBackPressed() {
                        if (webView.canGoBack()) webView.goBack()
                        else Navigation.findNavController(view).navigateUp()
                    }
                }
            )
        }
    }

    companion object{
        const val KEY_NEW_MODEL = "key_news_model"
    }
}