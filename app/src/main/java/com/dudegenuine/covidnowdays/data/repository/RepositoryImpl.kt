package com.dudegenuine.covidnowdays.data.repository

import com.dudegenuine.covidnowdays.data.remote.IRemoteDataSource
import com.dudegenuine.covidnowdays.di.preference.IPreferences
import com.dudegenuine.covidnowdays.model.remote.Country
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Province
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
class RepositoryImpl(
    val dataSource: IRemoteDataSource,
    val prefs: IPreferences,

): IRepository {
    override fun getSavedProvince(): String {
        return prefs.prefs().getString(
            IPreferences.PREFS_PROVINCE_NAME,
            "DKI Jakarta") ?: ""
    }

    override suspend fun getGovCovidData(): GovCovidData =
        dataSource.getGovCovidData()

    override suspend fun getGovCovidDataItem(): CovidItem =
        getGovCovidData().listData?.first {
            it?.key?.lowercase()?.contains(getSavedProvince().lowercase()) ?: false
        } ?: getGovCovidData().listData?.first() ?: CovidItem()

    override suspend fun getHospitals(): List<Hospital> {
        return dataSource.getHospitals().filter {
            it.province?.lowercase()?.contains(getSavedProvince().lowercase()) ?: false
        }
    }

    override suspend fun getNews(): List<News> =
        dataSource.getNews().sortedByDescending { it.timestamp }

    override suspend fun getCountriesData(): List<Country> =
        dataSource.getCountriesData()

    override suspend fun getInaProvincesData(): List<Province> =
        dataSource.getInaProvincesData()

}