package com.me.lordmathi2741.coviddata.factories

import com.me.lordmathi2741.coviddata.constants.Constants
import com.me.lordmathi2741.coviddata.service.HealthDataService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HealthDataServiceFactory {
     fun createHealthDataServiceInstance() : HealthDataService{
         return Retrofit.Builder().baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(HealthDataService::class.java)

    }
}