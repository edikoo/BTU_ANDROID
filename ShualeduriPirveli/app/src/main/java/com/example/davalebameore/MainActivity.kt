package com.example.davalebameore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Double.parseDouble

class MainActivity : AppCompatActivity() {

    private lateinit var cartType: EditText
    private lateinit var nameAndSurname: EditText
    private lateinit var cartNumber: EditText
    private lateinit var month: EditText
    private lateinit var year: EditText
    private lateinit var cvvCode: EditText
    private lateinit var buyNowButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cartType = findViewById(R.id.cartType)
        nameAndSurname = findViewById(R.id.nameAndSurname)
        cartNumber = findViewById(R.id.cartNumber)
        month = findViewById(R.id.month)
        month.filters = arrayOf<InputFilter>(MinMaxFilter("1", "12"))
        cvvCode = findViewById(R.id.cvvCode)
        buyNowButton = findViewById(R.id.buyNowButton)


        buyNowButton.setOnClickListener {

            val cartType: String = cartType.text.toString()
            val nameAndSurname: String = nameAndSurname.text.toString()
            val cartNumber: String = cartNumber.text.toString()
            val cvvCode: String = cvvCode.text.toString()

            /*
            if(!checkCardType(cartType)) {
                return@setOnClickListener
            }
            if(nameAndSurname.isEmpty()) {
                Toast.makeText(this, "შეავსეთ სახელისა და გვარის ველი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            */


            if (!checkCartNumberLength(cartType, cartNumber)) {
                return@setOnClickListener
            }

            if (!checkCvvCode(cartType, cvvCode)) {
                return@setOnClickListener
            }

            //დააბრუნე წარმატების პასუხი


        }
    }

    fun checkCardType(cartType: String): Boolean {

        val validCardTypes = arrayOf("Visa", "Mastercard", "Amex")

        if (cartType.isEmpty()) {
            Toast.makeText(this, "შეავსეთ ბარათის ტიპი", Toast.LENGTH_SHORT).show()
            return false
        }

        if (cartType !in validCardTypes) {
            Toast.makeText(this, "შეავსეთ სწორი ბარათის ტიპი", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun checkCartNumberLength(cartType: String, cartNumber: String): Boolean {
        if (cartNumber.isEmpty()) {
            Toast.makeText(this, "შეავსეთ ბარათის ნომერი", Toast.LENGTH_SHORT).show()
            return false
        }

        cartNumber.replace("\\s".toRegex(), "")

        try {
            val num = parseDouble(cartNumber)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "გთხოვთ შეიყვანეთ მხოლოდ ციფრები", Toast.LENGTH_SHORT).show()
            return false
        }

        when (cartType) {
            "Visa", "Mastercard" -> {
                if (cartNumber.length != 16) {
                    Toast.makeText(
                        this,
                        "ბარათის ნომერი უნდა იყოს 16 ციფრისგან შემდგარი",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            }
            "Amex" -> {
                if (cartNumber.length != 15) {
                    Toast.makeText(
                        this,
                        "ბარათის ნომერი უნდა იყოს 15 ციფრისგან შემდგარი",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            }
        }

        return true
    }

    fun checkCvvCode(cartType: String, cvvCode: String): Boolean {
        if (cvvCode.isEmpty()) {
            Toast.makeText(this, "შეავსეთ CVV კოდი", Toast.LENGTH_SHORT).show()
            return false
        }
        cvvCode.replace("\\s".toRegex(), "")

        try {
            val num = parseDouble(cvvCode)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "გთხოვთ შეიყვანეთ მხოლოდ ციფრები", Toast.LENGTH_SHORT).show()
            return false
        }

        when (cartType) {
            "Visa", "Mastercard" -> {
                if (cvvCode.length != 3) {
                    Toast.makeText(
                        this,
                        "CVV კოდი უნდა იყოს 3 ციფრისგან შემდგარი",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            }
            "Amex" -> {
                if (cvvCode.length != 4) {
                    Toast.makeText(
                        this,
                        "CVV კოდი უნდა იყოს 4 ციფრისგან შემდგარი",
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            }
        }

        return true
    }

    inner class MinMaxFilter() : InputFilter {
        private var intMin: Int = 0
        private var intMax: Int = 0

        constructor(minValue: String, maxValue: String) : this() {
            this.intMin = Integer.parseInt(minValue)
            this.intMax = Integer.parseInt(maxValue)
        }

        override fun filter(
            source: CharSequence,
            start: Int,
            end: Int,
            dest: Spanned,
            dStart: Int,
            dEnd: Int
        ): CharSequence? {
            try {
                val string = month.text.toString()
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(intMin, intMax, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }

        private fun isInRange(a: Int, b: Int, c: Int): Boolean {
            return if (b > a) c in a..b else c in b..a
        }
    }
}

