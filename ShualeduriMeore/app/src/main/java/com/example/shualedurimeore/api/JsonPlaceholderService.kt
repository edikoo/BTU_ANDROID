package com.example.rest.api

import com.example.rest.api.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {

    @GET("posts")
    fun getPosts() : Call<List<PostDto>>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId") postId: Long): Call<List<CommentDto>>


}