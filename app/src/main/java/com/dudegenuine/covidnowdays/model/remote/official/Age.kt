package com.dudegenuine.covidnowdays.model.remote.official

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Age(
	@SerializedName("value")
	val value: Double? = null
): Serializable