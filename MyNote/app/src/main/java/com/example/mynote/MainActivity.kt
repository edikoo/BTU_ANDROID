package com.example.mynote

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val savedText = sharedPref.getStringSet("keySet", HashSet<String>())

        val sets = ArrayList<String>()
        sets.add("13")
        sets.add("43")

        recyclerViewAdapter = RecyclerViewAdapter(sets)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = recyclerViewAdapter

        /*
        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val savedText = sharedPref.getString("NOTE", "")
        */





        /*
        button.setOnClickListener {

            val input = editTextNote.text.toString()

            var sets: MutableSet<String?> = HashSet()

            if(input.isNotEmpty()) {

                if (savedText != null) {
                    //Log.w("ki", savedText.toString())

                    if (savedText.contains("13")) {
                        Log.w("ki", "ki")
                        val text = textView.text.toString()

                        val resultText = input + '\n' + text

                        textView.text = resultText.toString()

                        sets.add(resultText.toString())

                        editTextNote.setText("")

                        //sharedPref.edit().putString("NOTE", resultText).apply()
                        sharedPref.edit().putStringSet("keySet", sets).apply()
                    }
                }
            }
        }
         */
    }
}