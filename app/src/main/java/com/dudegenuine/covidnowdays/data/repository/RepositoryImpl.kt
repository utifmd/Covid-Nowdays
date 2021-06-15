package com.dudegenuine.covidnowdays.data.repository

import com.dudegenuine.covidnowdays.data.remote.IRemoteDataSource
import com.dudegenuine.covidnowdays.di.network.IResponseHandler
import com.dudegenuine.covidnowdays.di.preference.IPreferences
import com.dudegenuine.covidnowdays.model.remote.*
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData
import java.lang.Exception

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
class RepositoryImpl(
    val dataSource: IRemoteDataSource,
    val prefs: IPreferences,
    private val responseHandler: IResponseHandler
): IRepository {
    override fun getSavedProvince(): String {
        return prefs.prefs().getString(
            IPreferences.PREFS_PROVINCE_NAME,
            "DKI Jakarta") ?: ""
    }

    override suspend fun getGovCovidData(): Resource<GovCovidData> {
        return try {
            responseHandler.onSuccess(dataSource.getGovCovidData())
        }catch (e: Exception){
            responseHandler.onException(e)
        }
    }

    override suspend fun getGovCovidDataItem(): Resource<CovidItem> {
        return try {
            responseHandler.onSuccess(
                getGovCovidData().data?.listData?.first {
                    it?.key?.lowercase()?.contains(getSavedProvince().lowercase())
                        ?: false }
                    ?: getGovCovidData().data?.listData?.first()
                ?: CovidItem()
            )
        }catch (e: Exception){
            responseHandler.onException(e)
        }
    }
    override suspend fun getHospitals(): Resource<List<Hospital>> {
        return try {
            responseHandler.onSuccess(
                dataSource.getHospitals().filter {
                    it.province?.lowercase()?.contains(getSavedProvince().lowercase()) ?: false
                }
            )
        }catch (e: Exception){
            responseHandler.onException(e)
        }
    }

    override suspend fun getNews(): Resource<List<News>> {
        return try {
            responseHandler.onSuccess(dataSource.getNews().sortedByDescending { it.timestamp })
        }catch (e: Exception){
            responseHandler.onException(e)
        }
    }


    override suspend fun getCountriesData(): List<Country> =
        dataSource.getCountriesData()

    override suspend fun getInaProvincesData(): List<Province> =
        dataSource.getInaProvincesData()

}