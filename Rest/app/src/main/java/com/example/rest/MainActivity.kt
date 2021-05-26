package com.example.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rest.api.RetrofitClient
import com.example.rest.api.dto.ReqResData
import com.example.rest.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val users = ArrayList<User>()

        RetrofitClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>> {
            override fun onResponse(
                    call: Call<ReqResData<List<User>>>,
                    response: Response<ReqResData<List<User>>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    response.body()?.data?.forEach { user -> users.add(user) }
                    recyclerViewAdapter = RecyclerViewAdapter(users)
                    recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    recyclerView.adapter = recyclerViewAdapter
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        /*
        recyclerViewAdapter = RecyclerViewAdapter(getUsers())
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = recyclerViewAdapter

         */

    }


}