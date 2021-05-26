package com.example.shualedurimeore

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "POSTS")
data class Post(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "POST_ID")
    var postId: Long?,

    @ColumnInfo(name = "USER_ID")
    var userId: Long?,

    @ColumnInfo(name = "POST_TITLE")
    var postTitle: String?,

    @ColumnInfo(name = "POST_BODY")
    var postBody: String?

)
