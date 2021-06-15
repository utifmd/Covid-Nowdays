package com.dudegenuine.covidnowdays.data.remote

import com.dudegenuine.covidnowdays.model.remote.Country
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Province
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
interface IRemoteDataSource {
    suspend fun getGovCovidData(): GovCovidData
    suspend fun getHospitals(): List<Hospital>
    suspend fun getNews(): List<News>
    suspend fun getCountriesData(): List<Country>
    suspend fun getInaProvincesData(): List<Province>
}
