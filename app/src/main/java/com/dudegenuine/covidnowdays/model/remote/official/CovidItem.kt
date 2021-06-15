package com.dudegenuine.covidnowdays.model.remote.official

import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.di.utility.IUtility
import com.google.gson.annotations.SerializedName
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.Serializable

data class CovidItem(
	@SerializedName("key")
	val key: String? = null,

	@SerializedName("doc_count")
	val docCount: Double? = null,

	@SerializedName("jumlah_kasus")
	val total: Int? = null,

	@SerializedName("jumlah_sembuh")
	val recovered: Int? = null,

	@SerializedName("jumlah_meninggal")
	val death: Int? = null,

	@SerializedName("jumlah_dirawat")
	val treated: Int? = null,

	@SerializedName("jenis_kelamin")
	val genders: List<Gender?>? = null,

	@SerializedName("kelompok_umur")
	val ageScopes: List<AgeScope?>? = null,

	@SerializedName("lokasi")
	val location: Location? = null,

	@SerializedName("penambahan")
	val addition: Addition? = null

): Serializable, KoinComponent {
	private val utility: IUtility by inject()

	val previewTotal: String
		get() = utility.getStrPrettyIdr(total ?: 0)

	val previewRecovered: String
		get() = utility.getStrPrettyIdr(recovered ?: 0)

	val previewDeath: String
		get() = utility.getStrPrettyIdr(death ?: 0)

	val viewTotal: String
		get() = utility.getStrNormalIdr(total ?: 0)

	val viewRecovered: String
		get() = utility.getStrNormalIdr(recovered ?: 0)

	val viewTreated: String
		get() = utility.getStrNormalIdr(treated ?: 0)

	val viewDeath: String
		get() = utility.getStrNormalIdr(death ?: 0)

	val viewDescHeader: String
		get() = "Data resmi Pemerintah Pusat secara keseluruhan menyimpulkan kasus covid-19 di wilayah $key mencapai,"

	val viewMale: String
		get() = utility.getStrNormalIdr(genders?.get(0)?.docCount ?: 0)

	val viewFemale: String
		get() = utility.getStrNormalIdr(genders?.get(1)?.docCount ?: 0)

	val viewBaby: String
		get() = utility.getStrNormalIdr(ageScopes?.get(0)?.docCount ?: 0)

	val viewChild: String
		get() = utility.getStrNormalIdr(ageScopes?.get(1)?.docCount ?: 0)

	val viewTeen: String
		get() = utility.getStrNormalIdr(ageScopes?.get(2)?.docCount ?: 0)

	val viewAdult: String
		get() = utility.getStrNormalIdr(ageScopes?.get(3)?.docCount ?: 0)

	val viewElderly: String
		get() = utility.getStrNormalIdr(ageScopes?.get(4)?.docCount ?: 0)

	val viewOlderly: String
		get() = utility.getStrNormalIdr(ageScopes?.get(5)?.docCount ?: 0)


	/*val previewGender: String
		get() = "${genders?.joinToString(
			transform = { "${it?.key} : ${utility.getStrNormalIdr(it?.docCount ?: 0)} Orang.\n" },
			separator = "")}"

	val previewAgeScope: String
		get() = "${ageScopes?.joinToString(
			transform = { "${it?.key} : ${utility.getStrNormalIdr(it?.docCount ?: 0)} Orang.\n" },
			separator = "")}"*/
}
