package com.example.davaleba10.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.davaleba10.R

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var foto: EditText
    private lateinit var saxeli: EditText
    private lateinit var gvari: EditText

    private lateinit var button: Button

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foto = view.findViewById(R.id.foto)
        saxeli = view.findViewById(R.id.saxeli)
        gvari = view.findViewById(R.id.gvari)

        button = view.findViewById(R.id.save)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        editor = sharedPreferences.edit()


        button.setOnClickListener {
            editor.putString("foto", foto.text.toString())
            editor.commit()
            editor.putString("saxeli", saxeli.text.toString())
            editor.commit()
            editor.putString("gvari", gvari.text.toString())
            editor.commit()

            Toast.makeText(getActivity(), "damaxsovrebulia", Toast.LENGTH_SHORT).show();

        }



    }


}