package com.me.lordmathi2741.coviddata.receiver

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.me.lordmathi2741.coviddata.R

class AlarmNotification: BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent?) {
        createNotification(context)
    }
    @SuppressLint("MissingPermission")
    private fun createNotification(context: Context){
        val channelId = CHANNEL_ID
        val channelName = CHANNEL_NAME
        val priority = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, channelName, priority)
        val manager = getSystemService(context, NotificationManager::class.java) as NotificationManager
        manager.createNotificationChannel(channel)
        val notification = NotificationCompat.Builder(context, channelId).apply {
            setContentTitle("Covid Data")
            setContentText("Información de Covid actualizada.")
            setSmallIcon(R.drawable.health_and_safety_24dp_5f6368_fill0_wght400_grad0_opsz24)
            setPriority(NotificationCompat.PRIORITY_HIGH)
        }.build()

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        const val NOTIFICATION_ID = 1
        const val CHANNEL_ID = "chat"
        const val CHANNEL_NAME = "Chat Notifications"
    }
}