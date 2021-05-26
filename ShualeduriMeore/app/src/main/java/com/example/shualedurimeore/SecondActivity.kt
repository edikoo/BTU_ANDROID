package com.example.shualedurimeore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rest.api.RetrofitClient
import com.example.rest.api.dto.CommentDto
import com.example.rest.api.dto.PostDto
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerViewCommentsAdapter: CommentsAdapater

    private lateinit var commentsRecyclerView: RecyclerView

    private lateinit var commentsCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        commentsCount = findViewById(R.id.commentsCount)
        commentsRecyclerView = findViewById(R.id.recyclerCommentView)



        val gson = Gson()
        val post = gson.fromJson<Post>(intent.getStringExtra("post"), Post::class.java)

        getSupportActionBar()?.setTitle(post.postTitle);

        var postId = post.postId?.toLong()

        if (postId != null) {
            RetrofitClient.JsonPlaceholderApi.getComments(postId).enqueue(object : Callback<List<CommentDto>> {
                override fun onResponse(
                        call: Call<List<CommentDto>>,
                        response: Response<List<CommentDto>>
                ) {
                    if(response.isSuccessful && response.body() != null) {

                        val comments = ArrayList<CommentDto>()

                        response.body()?.forEach { comment -> comments.add(comment) }

                        commentsCount.text = "Count: " + comments.size.toString()

                        recyclerViewCommentsAdapter = CommentsAdapater(comments)
                        commentsRecyclerView.layoutManager = LinearLayoutManager(this@SecondActivity)
                        commentsRecyclerView.adapter = recyclerViewCommentsAdapter

                    }
                }

                override fun onFailure(call: Call<List<CommentDto>>, t: Throwable) {
                    Log.d("FAIL", t.toString())
                }
            })
        }

    }
}