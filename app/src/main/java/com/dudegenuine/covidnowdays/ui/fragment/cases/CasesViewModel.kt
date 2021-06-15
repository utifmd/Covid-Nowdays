package com.dudegenuine.covidnowdays.ui.fragment.cases

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.dudegenuine.covidnowdays.data.repository.IRepository
import com.dudegenuine.covidnowdays.di.network.IResponseHandler
import com.dudegenuine.covidnowdays.di.preference.IPreferences
import com.dudegenuine.covidnowdays.model.remote.Resource
import com.dudegenuine.covidnowdays.model.remote.Status
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData
import com.dudegenuine.covidnowdays.ui.extension.navigate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
class CasesViewModel(val repository: IRepository): ViewModel(), KoinComponent {
    val TAG: String = javaClass.simpleName

    private val prefs: IPreferences by inject()

    /*
    * State
    * */
    // val isLoading = MutableLiveData<Boolean>()
    val isCollapse = MutableLiveData<Boolean>()

    val stateCovidItem = MutableLiveData<CovidItem>().apply {
        viewModelScope.launch(Dispatchers.IO) {
            this@apply.postValue(Resource.loading(null).data)
            this@apply.postValue(repository.getGovCovidDataItem().data)
        }
    }

    /*
    * Request
    * */
    val officialCovid: LiveData<Resource<GovCovidData>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(repository.getGovCovidData())
    }

    /*
    * Listeners
    * */
    val onProvinceSelected : (CovidItem) -> Unit = {
        stateCovidItem.postValue(it)
        // isCollapse.postValue(true)
        prefs.editor().putString(IPreferences.PREFS_PROVINCE_NAME, it.key).apply()
        Log.d(TAG, "onProvinceClicked: ${it.key}")
    }

    fun onCardToDetail(view: View) = navigate(view,
        CaseFragmentDirections.actionCaseFragmentToCaseDetailFragment(
            stateCovidItem.value ?: CovidItem()))

}