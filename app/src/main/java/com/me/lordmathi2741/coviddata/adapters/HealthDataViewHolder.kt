package com.me.lordmathi2741.coviddata.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.coviddata.R

class HealthDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dateTextView: TextView = itemView.findViewById(R.id.tvDateInfo)
    val positiveTextView : TextView = itemView.findViewById(R.id.tvPositiveInfo)
    val negativeTextView : TextView = itemView.findViewById(R.id.tvNegativeInfo)
    val deathTextView : TextView = itemView.findViewById(R.id.tvDeathInfo)

}