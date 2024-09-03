package com.me.lordmathi2741.coviddata.support

import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.coviddata.adapters.HealthDataAdapter
import com.me.lordmathi2741.coviddata.factories.HealthDataServiceFactory
import com.me.lordmathi2741.coviddata.models.HealthData
import com.me.lordmathi2741.coviddata.service.HealthDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Configuration private  constructor(){
    companion object{
        private lateinit var service : HealthDataService
        @Volatile
        private var instance: Configuration? = null
        fun getInstance() : Configuration {
            if (instance == null)  {
                synchronized(this) {
                    if (instance == null) {
                        instance = Configuration()
                    }
                }
            }
            return instance!!
        }

    }

    fun setUpRetrofit(){
        val factory = HealthDataServiceFactory
        service = factory.createHealthDataServiceInstance()
    }

    suspend fun getHealthData() : List<HealthData>{
        return service.getHealthData()
    }


    suspend fun setUpRecyclerView(recyclerView: RecyclerView){
        val healthData = getHealthData()
        withContext(Dispatchers.Main){
            recyclerView.adapter = HealthDataAdapter(healthData)
        }
    }




}