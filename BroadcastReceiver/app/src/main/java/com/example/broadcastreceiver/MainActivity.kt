package com.example.broadcastreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    companion object {
        const val ACTION_NAME = "com.example.broadcastreceiver.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button)
            .setOnClickListener {
                val intent: Intent = Intent()
                intent.action = ACTION_NAME
                intent.apply {
                    putExtra("NAME", "Giba")
                    putExtra("Car", "Bmw")
                }
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES) //ისეთ აპლიკაციებსაც გადასცემს შეტყობინებას რომელიცდახურულია
                sendBroadcast(intent)
            }
    }
}