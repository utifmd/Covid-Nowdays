package com.dudegenuine.covidnowdays.ui.fragment.informs

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dudegenuine.covidnowdays.data.repository.IRepository
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Resource
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.navigate
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers

/**
 * Covid Nowdays created by utifmd on 12/06/21.
 */
class InformViewModel(repository: IRepository): ViewModel() {
    val TAG: String = javaClass.simpleName
    val isLoading = MutableLiveData<Boolean>()

    /*
    * Instantiate
    * */
    val stateUrl = MutableLiveData<String>().apply {
        /*viewModelScope.launch(Dispatchers.IO) {
            value = repository.
        }*/
    }

    /*
    * Request
    * */
    val news = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(repository.getNews())
    }

    /*
    * Listener
    * */
    // HOME
    fun onNewsItemSelected(view: View, model: ModelContract){
        when(model) {
            is Header -> Log.d(TAG, "onHeaderSelected: header ${model.title}")
            is Common -> Log.d(TAG, "onCommonSelected: common ${model.label}")
            is News -> {
                if(model.url.isNullOrBlank()){
                    Snackbar.make(view, "Maaf, halaman tidak tersedia.", Snackbar.LENGTH_SHORT).show()
                    return
                }
                navigate(view, InformFragmentDirections.actionInformFragmentToInformDetailFragment(model))
            }
        }
    }
}