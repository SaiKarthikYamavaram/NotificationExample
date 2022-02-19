package com.example.notificationexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var notificationManagerCompat: NotificationManagerCompat
    private val app = App()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notificationManagerCompat = NotificationManagerCompat.from(this)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        binding.ed1

        binding.ed2


        binding.btnNotification.setOnClickListener {
            sendOnChannel1()
        }
        binding.btnNotification10.setOnClickListener {
            sendOnChannel2()

        }
    }

    private fun sendOnChannel2() {
        val title: String = binding.ed1.text.toString()
        val message: String = binding.ed2.text.toString()
        val notificaiton = NotificationCompat.Builder(this, app.channel_2_id)
            .setSmallIcon(R.drawable.ic_2)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManagerCompat.notify(1, notificaiton)
    }

    private fun sendOnChannel1() {
        val title: String = binding.ed1.text.toString()
        val message: String = binding.ed2.text.toString()
        val notificaiton = NotificationCompat.Builder(this, app.channel_1_id)
            .setSmallIcon(R.drawable.ic_1)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManagerCompat.notify(2, notificaiton)
    }


}