package com.dudegenuine.covidnowdays.model.remote.official

import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.google.gson.annotations.SerializedName
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.Serializable
import java.text.DateFormat
import java.util.*

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
): Serializable, KoinComponent {
	private val utility: IUtility by inject()

	val previewLastDate: String
		get() = "Terakhir diupdate pada $lastDate"
}
