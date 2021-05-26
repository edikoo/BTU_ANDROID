package com.example.shualedurimeore

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PostDao {

    @Query("SELECT * FROM POSTS")
    fun getAllPosts(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg posts: Post)

    @Query("DELETE FROM POSTS")
    fun deleteAll()

}