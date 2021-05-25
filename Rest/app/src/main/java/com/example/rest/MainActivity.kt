package com.example.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rest.api.RetrofitClient
import com.example.rest.api.dto.ReqResData
import com.example.rest.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers()
    }

    private fun getUsers() {

        RetrofitClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>> {
            override fun onResponse(
                call: Call<ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    response.body()?.data?.forEach { user -> Log.d("MyData", user.toString()) }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}