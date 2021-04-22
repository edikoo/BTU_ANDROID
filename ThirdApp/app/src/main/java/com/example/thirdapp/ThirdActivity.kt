package com.example.thirdapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        nameTextView = findViewById(R.id.textView)
        ageTextView = findViewById(R.id.textView2)
        emailTextView = findViewById(R.id.textView3)


        nameTextView.text = intent.extras?.getString("NAME")
        emailTextView.text = intent.extras?.getString("EMAIL")
        ageTextView.text = intent.extras?.getInt("AGE").toString()

    }
}