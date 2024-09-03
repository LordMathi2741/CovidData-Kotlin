package com.me.lordmathi2741.coviddata.service

import com.me.lordmathi2741.coviddata.constants.Constants
import com.me.lordmathi2741.coviddata.models.HealthData
import retrofit2.http.GET

interface HealthDataService {
    @GET(Constants.BASE_URL + Constants.END_POINT)
    suspend fun getHealthData(): List<HealthData>
}