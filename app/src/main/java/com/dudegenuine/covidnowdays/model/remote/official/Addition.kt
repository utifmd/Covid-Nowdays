package com.dudegenuine.covidnowdays.model.remote.official

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Addition(
	@SerializedName("meninggal")
	val death: Int? = null,
	
	@SerializedName("positif")
	val positive: Int? = null,
	
	@SerializedName("sembuh")
	val recovered: Int? = null
): Serializable