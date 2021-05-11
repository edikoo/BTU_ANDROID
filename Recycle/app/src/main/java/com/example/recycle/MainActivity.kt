package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var recyclerView: RecyclerView


    //glide es gamoiyene ----!! suratebistvis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerViewAdapter = RecyclerViewAdapter(getData())
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun getData(): List<Person> {
        val persons = ArrayList<Person>()

        persons.add(
            Person(
                2,
                "giorgi",
                "dato",
                "https://editorial.fxstreet.com/miscelaneous/24aw5Y30SvolnlS9E17by39A5oVXE3C9DRlFEERx/FEB14-%20ADA-637488814712700475.png"
            )
        )

        return persons
    }
}
