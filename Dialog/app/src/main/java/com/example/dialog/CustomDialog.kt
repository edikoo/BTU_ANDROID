package com.example.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CustomDialog(context: Context) : Dialog(context) {

    init {
        setCancelable(false)
    }

    private lateinit var yesButton: Button
    private lateinit var noButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog)

        init()

        registerListeners()
    }

    private fun init() {
        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)
    }

    private fun registerListeners() {
        yesButton.setOnClickListener {
            dismiss()
        }

        noButton.setOnClickListener {

        }
    }

}