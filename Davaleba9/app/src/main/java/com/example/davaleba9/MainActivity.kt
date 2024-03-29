package com.example.davaleba9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submit).setOnClickListener {

            val email = findViewById<EditText>(R.id.email).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()
            val repassword = findViewById<EditText>(R.id.repassword).text.toString()

            if (email.isEmpty()) {
                Toast.makeText(applicationContext, "enter email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                if (!email.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())) {
                    Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            if (password.isEmpty()) {
                Toast.makeText(applicationContext, "enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                if (!isValidPassword(password)) {
                    Toast.makeText(applicationContext, "Invalid Password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            if (repassword.isEmpty()) {
                Toast.makeText(applicationContext, "enter repeat password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                if (!isValidPassword(repassword)) {
                    Toast.makeText(applicationContext, "Invalid Repeat Password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            if(password == repassword) {
                mAuth
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registracia warmatebit shesrulda!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Toast.makeText(applicationContext, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#\$%^&+=])(?=\\S+$).{8,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

}