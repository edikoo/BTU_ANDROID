package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        App.instance.db.getCarsDao().deleteAll()

        var car1 = Car(0, "Maserati MC20", 3.0F, 2020)
        var car2 = Car(0, "Opel", 1.8F, 1995)
        var car3 = Car(0, "Tesla", 5.0F, 2020)

        App.instance.db.getCarsDao().insert(car1, car2, car3)

        App.instance.db.getCarsDao().getAllCars().forEach {
            car -> Log.d("MyData", car.toString())
        }

    }
}