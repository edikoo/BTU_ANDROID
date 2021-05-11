package com.example.meeqvseproject.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meeqvseproject.Person
import com.example.meeqvseproject.R
import com.example.meeqvseproject.RecyclerViewAdapter

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerViewAdapter = RecyclerViewAdapter(getData())
        recyclerView.layoutManager = GridLayoutManager(getActivity(), 2)
        recyclerView.adapter = recyclerViewAdapter

    }


    private fun getData(): List<Person> {
        val persons = ArrayList<Person>()

        persons.add(
                Person(
                        1,
                        "giorgi",
                        "tinikashvili",
                        "https://editorial.fxstreet.com/miscelaneous/24aw5Y30SvolnlS9E17by39A5oVXE3C9DRlFEERx/FEB14-%20ADA-637488814712700475.png"
                )
        )

        persons.add(
                Person(
                        2,
                        "kaxa",
                        "cicqidze",
                        "https://mediapool.bmwgroup.com/cache/P9/202010/P90403620/P90403620-bmw-m4-competition-x-kith-10-2020-2002px.jpg"
                )
        )

        persons.add(
                Person(
                        3,
                        "avto",
                        "maisuradze",
                        "https://cdn.motor1.com/images/mgl/vEJmQ/s1/bmw-i8-m-rendering.jpg"
                )
        )

        persons.add(
                Person(
                        4,
                        "gela",
                        "samxaradze",
                        "https://media2.s-nbcnews.com/j/newscms/2019_26/2914436/190628-bmw-m-next-al-1002_18c897ef97cc5847e516173c93a76dab.nbcnews-fp-1200-630.jpg"
                )
        )

        return persons
    }
}