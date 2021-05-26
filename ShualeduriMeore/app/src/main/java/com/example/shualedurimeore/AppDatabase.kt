package com.example.shualedurimeore

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostsDao() : PostDao
}