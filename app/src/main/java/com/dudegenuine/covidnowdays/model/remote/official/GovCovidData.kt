package com.dudegenuine.covidnowdays.model.remote.official

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
data class GovCovidData(
	@SerializedName("missing_data")
	val missingData: Double? = null,

	@SerializedName("tanpa_provinsi")
	val unProvince: Int? = null,

	@SerializedName("current_data")
	val currentData: Double? = null,

	@SerializedName("list_data")
	val listData: List<CovidItem?>? = null,

	@SerializedName("last_date")
	val lastDate: String? = null
): Serializable {

	val previewLastDate: String
		get() = "Terakhir diupdate pada $lastDate"
}
