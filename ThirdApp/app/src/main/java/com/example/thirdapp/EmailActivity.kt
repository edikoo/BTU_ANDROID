package com.example.thirdapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EmailActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var emailNextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        emailEditText = findViewById(R.id.emailEditText)
        emailNextButton = findViewById(R.id.emailNextButton)

        val name = intent.extras?.getString("NAME")
        emailNextButton.setOnClickListener {
            val emailEditText: String = emailEditText.text.toString()

            if(emailEditText.isEmpty()) {
                return@setOnClickListener
            }

            val email: String = emailEditText.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("EMAIL", email)
            startActivity(intent)
        }
    }
}