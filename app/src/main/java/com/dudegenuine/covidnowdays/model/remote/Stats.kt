package com.dudegenuine.covidnowdays.model.remote

/**
 * Covid Nowdays created by utifmd on 30/05/21.
 */
data class Stats(
	val regions: List<RegionsItem?>? = null,
	val name: String? = null,
	val numbers: Numbers? = null,
	val type: String? = null,
	val timestamp: Long? = null
)

data class RegionsItem(
	val name: String? = null,
	val numbers: Numbers? = null,
	val type: String? = null
)

data class Numbers(
	val infected: Int? = null,
	val recovered: Int? = null,
	val fatal: Int? = null
)

