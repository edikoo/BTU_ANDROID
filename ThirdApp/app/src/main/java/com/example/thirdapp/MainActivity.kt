package com.example.thirdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivityTag"


    private lateinit var nameEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        nameEditText = findViewById(R.id.nameEditText)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {

            val name: String = nameEditText.text.toString()

            if(name.isEmpty()) {
                return@setOnClickListener
            }

            val intent = Intent(this, EmailActivity::class.java)
            intent.putExtra("NAME", name)
            startActivity(intent)
            // finish() -stopActivity
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onCreate")

    }

}