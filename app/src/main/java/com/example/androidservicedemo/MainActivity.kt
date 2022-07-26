package com.example.androidservicedemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startServiceButton = Button(this)
        startServiceButton.text = "Start service"
        startServiceButton.setOnClickListener {
            startService(Intent(this, MyService::class.java))
            Toast.makeText(this, "Music started", Toast.LENGTH_SHORT).show()
        }

        val stopServiceButton = Button(this)
        stopServiceButton.text = "Stop service"
        stopServiceButton.setOnClickListener {
            stopService(Intent(this, MyService::class.java))
            Toast.makeText(this, "Music stopped", Toast.LENGTH_SHORT).show()
        }

        val linearLayout = LinearLayout(this).apply {
            addView(startServiceButton)
            addView(stopServiceButton)
        }

        setContentView(linearLayout)

    }

}