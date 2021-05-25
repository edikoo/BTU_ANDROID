package com.example.mysqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var carDbHelper: CarDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carDbHelper = CarDbHelper(this)

        carDbHelper.insert("Mercedes Benz C63", 2016, 6.3F)
        carDbHelper.insert("Mercedes Benz C300", 2015, 2.0F)
        carDbHelper.insert("Maserati MC20", 2020, 3.0F)

        carDbHelper.selectByYear(2010)

        carDbHelper.updateCarName(3, "GrandTurismo")

        carDbHelper.selectByYear(2010)

        carDbHelper.updateToPorsche()

        carDbHelper.selectByYear(2010)

        carDbHelper.deleteCar(1)

        carDbHelper.selectByYear(2010)

        carDbHelper.deleteAll()

        Log.d("MyData", "11111")

        carDbHelper.selectByYear(2010)

    }
}