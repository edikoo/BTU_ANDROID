package com.example.shualedurimeore

import android.app.Application
import androidx.room.Room
import com.example.rest.api.RetrofitClient

class App : Application() {

    lateinit var db: AppDatabase

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        RetrofitClient.initClient()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "APP_DATABASE"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()


    }

}