package com.example.androidservicedemo

import android.R
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat


class MyService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private val FOREGROUND_ID = 1337
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        // this command don't start the service
        // its only tells that this service will be started as ForegroundService
        startForeground(FOREGROUND_ID, buildForegroundNotification());
        
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun buildForegroundNotification(): Notification {

        return NotificationCompat.Builder(this, "test_notification_channel_id")
            .setContentTitle("Media Player Service")
            .setContentText("Music is now playing")
            .setTicker("Media Player Service Ticker")
            .setSmallIcon(R.drawable.stat_sys_headset)
            .build()

    }



}