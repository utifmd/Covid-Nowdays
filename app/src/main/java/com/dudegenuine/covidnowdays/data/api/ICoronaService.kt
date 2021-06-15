package com.dudegenuine.covidnowdays.data.api

import com.dudegenuine.covidnowdays.model.remote.Country
import com.dudegenuine.covidnowdays.model.remote.Hospital
import com.dudegenuine.covidnowdays.model.remote.News
import com.dudegenuine.covidnowdays.model.remote.Province
import com.dudegenuine.covidnowdays.model.remote.official.GovCovidData
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
interface ICoronaService {
    @GET("prov.json")
    suspend fun getGovCovidData(): GovCovidData

    @GET
    suspend fun getHospitals(@Url url: String): List<Hospital>

    @GET
    suspend fun getNews(@Url url: String): List<News>

    @GET
    suspend fun getCountriesData(@Url emptyUrl: String? = ""): List<Country>

    @GET
    suspend fun getInaProvincesData(): List<Province>

    /* @GET("api/characters/house/{house}")
    suspend fun getCharacters(@Path("house") type: String): List<Character>*/
}