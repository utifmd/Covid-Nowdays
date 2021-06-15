package com.dudegenuine.covidnowdays.model.remote.official

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(
	@SerializedName("lon")
	val lon: Double? = null,
	
	@SerializedName("lat")
	val lat: Double? = null
): Serializable