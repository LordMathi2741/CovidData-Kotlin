package com.me.lordmathi2741.coviddata.models

data class HealthData (
    val date: Int,
    val states: Int,
    val positive: Int,
    val negative: Int,
    val pending: Int,
    val hospitalizedCurrently: Int,
    val hospitalizedCumulative: Int,
    val inIcuCurrently: Int,
    val inIcuCumulative: Int,
    val onVentilatorCurrently: Int,
    val onVentilatorCumulative: Int,
    val dateChecked: String,
    val death: Int,
    val hospitalized: Int,
    val totalTestResults: Int,
    val lastModified: String,
    val recovered: Any?,
    val total: Int,
    val posNeg: Int,
    val deathIncrease: Int,
    val hospitalizedIncrease: Int,
    val negativeIncrease: Int,
    val positiveIncrease: Int,
    val totalTestResultsIncrease: Int,
    val hash: String

)