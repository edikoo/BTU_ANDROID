package com.example.meeqvseproject.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.meeqvseproject.R

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments
            ?.takeIf { it.containsKey("STRING") }
            ?.apply {
                view.findViewById<TextView>(R.id.textView).text = getString("STRING").toString()
            }

    }

}