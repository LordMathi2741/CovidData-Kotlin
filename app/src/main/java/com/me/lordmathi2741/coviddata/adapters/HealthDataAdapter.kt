package com.me.lordmathi2741.coviddata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.coviddata.R
import com.me.lordmathi2741.coviddata.models.HealthData

class HealthDataAdapter(private val healthDataList: List<HealthData>) : RecyclerView.Adapter<HealthDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthDataViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.health_data, parent, false)
        return HealthDataViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return healthDataList.size
    }

    override fun onBindViewHolder(holder: HealthDataViewHolder, position: Int) {
        val healthData = healthDataList[position]
        holder.dateTextView.text = healthData.date.toString()
        holder.positiveTextView.text = healthData.positive.toString()
        holder.negativeTextView.text = healthData.negative.toString()
        holder.deathTextView.text = healthData.death.toString()

    }
}