package com.example.broadcastreceviersecondapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action == "com.example.broadcastreceiver.MainActivity") {
            Toast
                .makeText(context, intent.extras?.getString("NAME"), Toast.LENGTH_SHORT)
                .show()
        } else if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            Toast
                .makeText(context, "Message received", Toast.LENGTH_SHORT)
                .show()
        }

    }
}