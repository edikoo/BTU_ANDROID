package com.example.davaleba10.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.davaleba10.R


class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var imageView: ImageView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView2 = view.findViewById(R.id.textView2)
        textView3 = view.findViewById(R.id.textView3)
        imageView = view.findViewById(R.id.imageView)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        checkAndGet(view)

    }

    fun checkAndGet(view: View) {
        val foto = sharedPreferences.getString("foto", "")
        val saxeli = sharedPreferences.getString("saxeli", "")
        val gvari = sharedPreferences.getString("gvari", "")

        if (foto == "" || saxeli == "" || gvari == "" )
        {
            var builder = AlertDialog.Builder(requireContext())
            builder.setTitle("ყურადღება!")
            builder.setMessage("შეავსეთ მონაცემები")
            builder.setPositiveButton("კარგი") { dialog, i ->
                dialog.dismiss()
            }
            builder.setCancelable(false)
            builder.show()
            return
        }

        Glide.with(view)
                .load(foto)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView)

        textView2.text = saxeli
        textView3.text = gvari

    }

}