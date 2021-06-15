package com.dudegenuine.covidnowdays.data.repository

import com.dudegenuine.covidnowdays.model.remote.Country
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Province
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
interface IRepository {
    fun getSavedProvince(): String
    suspend fun getGovCovidData(): GovCovidData
    suspend fun getGovCovidDataItem(): CovidItem
    suspend fun getCountriesData(): List<Country>
    suspend fun getHospitals(): List<Hospital>
    suspend fun getNews(): List<News>
    suspend fun getInaProvincesData(): List<Province>
}