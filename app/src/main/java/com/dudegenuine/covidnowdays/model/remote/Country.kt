package com.dudegenuine.covidnowdays.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */

data class Country(
	@SerializedName("attributes")
	val attributes: AttrCountry? = null
)

class AttrCountry(
	@SerializedName("OBJECTID")
	val objectId: Int? = null,

	@SerializedName("Country_Region")
	val countryRegion: String? = null,

	@SerializedName("Last_Update")
	val lastUpdate: Long? = null,

	@SerializedName("Lat")
	val latitude: Double? = null,

	@SerializedName("Long_")
	val longitude: Double? = null,

	@SerializedName("Confirmed")
	val confirmed: Int? = null,

	@SerializedName("Recovered")
	val recovered: Int? = null,

	@SerializedName("Deaths")
	val deaths: Int? = null,

	@SerializedName("Active")
	val active: Int? = null
)
