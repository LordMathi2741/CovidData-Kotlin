package com.me.lordmathi2741.coviddata


import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.me.lordmathi2741.coviddata.adapters.HealthDataAdapter
import com.me.lordmathi2741.coviddata.receiver.AlarmNotification
import com.me.lordmathi2741.coviddata.receiver.AlarmNotification.Companion.NOTIFICATION_ID
import com.me.lordmathi2741.coviddata.support.Configuration
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private var instance = Configuration.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvHealthData)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HealthDataAdapter(emptyList())
        setUpNotification()
        scheduleNotification()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        instance.setUpRetrofit()
        lifecycleScope.launch {
            instance.getHealthData()
        }
        lifecycleScope.launch {
            instance.setUpRecyclerView(recyclerView)
        }



    }


    private fun setUpNotification() {

        val infoButton: FloatingActionButton = findViewById(R.id.flBInfo)
        val notification = AlarmNotification()
        infoButton.setOnClickListener {
            notification.onReceive(this,null)
            }

        }

    @SuppressLint("ScheduleExactAlarm")
    private fun scheduleNotification() {
        val intent = Intent(applicationContext, AlarmNotification::class.java)
       val pendingIntent = PendingIntent.getBroadcast(
           applicationContext,
           NOTIFICATION_ID,
           intent,
           PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
       )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,Calendar.getInstance().timeInMillis + 15000,pendingIntent)
    }
}
