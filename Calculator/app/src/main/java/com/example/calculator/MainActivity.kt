package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var equalsButton: Button
    private lateinit var cleanButton: Button

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        equalsButton = findViewById(R.id.equalsButton)
        cleanButton = findViewById(R.id.cleanButton)

        cleanButton.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                resultTextView.text = ""
                return true
            }
        })

        equalsButton.setOnClickListener {
            val secondOperandText = resultTextView.text.toString()
            var secondOperand: Double = 0.0

            if(!secondOperandText.isEmpty()) {
                secondOperand = secondOperandText.toDouble()
            }

            when(operation) {
                "+" -> resultTextView.text = (operand + secondOperand).toString()
                "-" -> resultTextView.text = (operand - secondOperand).toString()
                "/" -> resultTextView.text = (operand / secondOperand).toString()
                "*" -> resultTextView.text = (operand * secondOperand).toString()
            }
        }
    }

    fun numberClick(view: View) {
        if(view is Button) {
            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if(result == "0") {
                result = ""
            }

            resultTextView.text = result + number
        }
    }

    fun operationClick(view: View){
        if(view is Button) {
            if(!resultTextView.text.isEmpty()) {
               operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()
        }
    }

    fun clean(view: View) {
        if(view is Button) {
            var result: String = resultTextView.text.toString()
            if(!result.isEmpty()) {
                resultTextView.text = result.substring(0, result.length - 1);
            }
        }
    }

    fun point(view: View) {
        if(view is Button) {
            var result: String = resultTextView.text.toString()
            if(result.isEmpty()) {
                return
            }
            if(result.contains(".")) {
                return
            }
            resultTextView.text = result + "."
        }
    }

    fun percent(view: View) {
        if(view is Button) {
            var result: String = resultTextView.text.toString()
            if(!result.isEmpty()) {
                resultTextView.text = (result.toDouble() / 100).toString()
            }
        }
    }

    fun positiveOrNegative(view: View) {
        if(view is Button) {
            var result: String = resultTextView.text.toString()
            if(!result.isEmpty()) {
                resultTextView.text = ((result.toDouble() * -1).toString())
            }
        }
    }

    fun getSqrt(view: View) {
        if(view is Button) {
            var result: String = resultTextView.text.toString()
            if(!result.isEmpty()) {
                resultTextView.text = ((sqrt(result.toDouble())).toString())
            }
        }
    }
}