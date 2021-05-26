package com.example.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rest.api.RetrofitClient
import com.example.rest.api.dto.ReqResData
import com.example.rest.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    private lateinit var userIdTextView: TextView
    private lateinit var nameLastname: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val id = intent.extras?.getLong("id").toString()

        userIdTextView = findViewById(R.id.userIdTextView)
        nameLastname = findViewById(R.id.nameLastname)

        RetrofitClient.reqResApi.getUser(id.toLong()).enqueue(object : Callback<ReqResData<User>> {
            override fun onResponse(
                call: Call<ReqResData<User>>,
                response: Response<ReqResData<User>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    userIdTextView.text = "User id: " + response.body()?.data?.id
                    nameLastname.text = response.body()?.data?.firsName + " " + response.body()?.data?.lastName
                }
            }

            override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}