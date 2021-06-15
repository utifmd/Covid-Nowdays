package com.dudegenuine.covidnowdays.data.repository

import com.dudegenuine.covidnowdays.model.remote.*
import com.dudegenuine.covidnowdays.model.remote.official.CovidItem
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
interface IRepository {
    fun getSavedProvince(): String

    suspend fun getGovCovidData(): Resource<GovCovidData>
    suspend fun getGovCovidDataItem(): Resource<CovidItem>
    suspend fun getHospitals(): Resource<List<Hospital>>
    suspend fun getNews(): Resource<List<News>>

    suspend fun getCountriesData(): List<Country>
    suspend fun getInaProvincesData(): List<Province>
}