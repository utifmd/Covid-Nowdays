package com.dudegenuine.covidnowdays.model.remote.official

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AgeScope(
	@SerializedName("key")
	val key: String? = null,
	
	@SerializedName("doc_count")
	val docCount: Int? = null,
	
	@SerializedName("usia")
	val age: Age? = null
): Serializable