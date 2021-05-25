package com.example.rest

import android.app.Application
import com.example.rest.api.RetrofitClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitClient.initClient()
    }

}