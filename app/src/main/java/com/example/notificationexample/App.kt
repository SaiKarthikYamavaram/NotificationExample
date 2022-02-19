package com.example.notificationexample

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    val channel_1_id = "channel1"
    val channel_2_id = "channel2"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()

    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channel_1_id,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = ("This is channel 1")
            val channel2 = NotificationChannel(
                channel_2_id,
                "Channel 1",
                NotificationManager.IMPORTANCE_LOW
            )
            channel2.description = ("This is channel 2")
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }


    }

}