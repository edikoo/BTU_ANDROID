package com.example.finalurigamocda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.backToRegistration).setOnClickListener {
            finish()
        }

        val loginButton = findViewById<Button>(R.id.loginButton)


        loginButton.setOnClickListener {

            val email = findViewById<EditText>(R.id.loginEmail).text.toString()
            val password = findViewById<EditText>(R.id.loginPassword).text.toString()

            if (email.isEmpty()) {
                Toast.makeText(applicationContext, "enter email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(applicationContext, "enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth
                    .signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Avtorizacia warmatebit shesrulda!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
        }

    }
}