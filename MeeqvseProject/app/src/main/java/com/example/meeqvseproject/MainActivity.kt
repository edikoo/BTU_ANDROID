package com.example.meeqvseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.meeqvseproject.adapters.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)


        viewPager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Object ${position + 1}"
        }.attach()


    }
}