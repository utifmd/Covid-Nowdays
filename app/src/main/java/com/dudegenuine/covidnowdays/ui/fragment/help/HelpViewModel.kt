package com.dudegenuine.covidnowdays.ui.fragment.help

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.*
import com.dudegenuine.covidnowdays.BuildConfig
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.data.repository.IRepository
import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.dudegenuine.covidnowdays.model.local.Common
import com.dudegenuine.covidnowdays.model.local.Header
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.Resource
import com.dudegenuine.covidnowdays.ui.extension.ModelContract
import com.dudegenuine.covidnowdays.ui.extension.navigate
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.IllegalStateException

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */
class HelpViewModel(val repository: IRepository): ViewModel(), KoinComponent {
    val TAG: String = javaClass.simpleName

    private val utility: IUtility by inject()

    val isLoading = MutableLiveData<Boolean>()
    val isExpand = MutableLiveData<Boolean>()
    val stateHospital = MutableLiveData<Hospital>().apply {
        /*viewModelScope.launch(Dispatchers.IO) {
            stateHospital.value ?: stateHospital.postValue(repository.getHospitals().first())
        }*/
    }

    /*
    * Requests
    * */
    val unofficialHospitals: LiveData<Resource<List<Hospital>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(repository.getHospitals())
    }
    // val savedProvince: String get() = repository.getSavedProvince()

    /*
    * Listeners
    * */
    // HOME
    fun onHelpItemSelected(view: View, model: ModelContract){
        when(model) {
            is Header -> Log.d(TAG, "onHeaderSelected: header ${model.title}")
            is Common -> Log.d(TAG, "onCommonSelected: common ${model.label}")
            is Hospital -> {
                Log.d(TAG, "onHospitalSelected: hospital ${model.name}")
                navigate(view, HelpFragmentDirections.actionHelpFragmentToHelpDetailFragment(model))
            }
        }
    }
    val onMenuItemSelected: (View, MenuItem) -> Boolean = { v, menu ->
        when(menu.itemId){
            R.id.about ->
                utility.getWidgetAlertMessage(v.context, "Copyright", "App Version ${BuildConfig.VERSION_NAME}\n\nDeveloped by utifmd@gmail.com")
            R.id.share ->
                utility.getWidgetShareText(v.context, "Share Covid Update App", "https://utifmd.github.io/portfolio/")
            else ->
                throw IllegalStateException("Invalid menu.")
        }
        true
    }

    // DETAIL
    fun onButtonsClickOnce(view: View, viewType: Int, model: Hospital){
        if (model.phone.isNullOrBlank()){
            Snackbar.make(view, "Maaf, nomor telfon ${model.name} tidak tersedia.", Snackbar.LENGTH_SHORT).show()

            return
        }

        when(viewType){
            0 -> view.context.startActivity(Intent().apply {
                action = Intent.ACTION_SENDTO
                data = Uri.parse("smsto:${model.phone}") // type = "text/plain" putExtra("sms_body", "This is my text to send.")
            })
            1 -> view.context.startActivity(Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:${model.phone}")
            })
            2 -> view.context.startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(
                    "https://api.whatsapp.com/send?phone=${if (model.phone.first() == '0') model.phone.replaceFirstChar { "+62" } else "+62${model.phone}"}"
                )
            })
        }
    }
}