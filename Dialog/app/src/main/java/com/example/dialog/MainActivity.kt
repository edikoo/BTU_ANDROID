package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.init()

        this.registerListeners()


    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
    }

    private fun registerListeners() {
        button1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("გადარიცხვა")
            builder.setMessage("ნამდვილად გსურთ გადარიცხვა?")
            builder.setPositiveButton("დიახ") { dialog, i ->
                Toast.makeText(this, "დიახ!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            builder.setNegativeButton("არა") { dialog, i ->
                Toast.makeText(this, "არა!", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            builder.setNeutralButton("არ ვიცი") { dialog, i ->
                Toast.makeText(this, "არ ვიცი!", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            builder.setCancelable(false)
            builder.show()
        }

        button2.setOnClickListener {
            CustomDialog(this).show()
        }
    }
}