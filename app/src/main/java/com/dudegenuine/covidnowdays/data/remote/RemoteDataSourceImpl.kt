package com.dudegenuine.covidnowdays.data.remote

import com.dudegenuine.covidnowdays.BuildConfig
import com.dudegenuine.covidnowdays.data.api.ICoronaService
import com.dudegenuine.covidnowdays.model.remote.Country
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Province
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
class RemoteDataSourceImpl(val service: ICoronaService): IRemoteDataSource {
    override suspend fun getCountriesData(): List<Country> =
        service.getCountriesData()

    override suspend fun getInaProvincesData(): List<Province> =
        service.getInaProvincesData()

    override suspend fun getGovCovidData(): GovCovidData =
        service.getGovCovidData()

    override suspend fun getHospitals(): List<Hospital> =
        service.getHospitals(BuildConfig.UNOFFICIAL_HOSPITAL_URL)

    override suspend fun getNews(): List<News> =
        service.getNews(BuildConfig.UNOFFICIAL_NEWS_URL)
}