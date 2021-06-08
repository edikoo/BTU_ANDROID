package com.example.broadcastreceviersecondapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private val timeBroadcastReceiver by lazy { makeBroadcastReceiver() }

    companion object {
        private fun getCurrentTime(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val date = Date()
            return sdf.format(date)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textview)
    }

    override fun onResume() {
        super.onResume()
        textView.text = getCurrentTime()
        registerReceiver(timeBroadcastReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
    }

    override fun onPause() {
        super.onPause()
        try {
            unregisterReceiver(timeBroadcastReceiver)
        } catch (e: IllegalArgumentException) {
            Log.e("MyData", "Exception...", e)
        }
    }

    private fun makeBroadcastReceiver() : BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
                    textView.text = getCurrentTime()
                }
            }

        }
    }
}