package com.example.someclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(mAuth.currentUser != null) {
            gotoProfile()
            return
        }

        setContentView(R.layout.activity_main)

        val email: String = "e2dd@gmail.com"
        val password = "12345678"

        mAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    gotoProfile()
                } else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun gotoProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish() //თუ ბექ ღილაკს დააწვება უკან არ გამოაგდებს ავტორიზაციიაზე როცა იქნება ავტორიზირებული
    }
}