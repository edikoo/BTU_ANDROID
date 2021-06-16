package com.example.davaleba10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.meeqvseproject.adapters.ViewPagerFragmentAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = viewPagerFragmentAdapter

    }
}