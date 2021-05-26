package com.example.shualedurimeore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rest.api.RetrofitClient
import com.example.rest.api.dto.PostDto
import com.example.rest.api.dto.ReqResDataPost
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewPostsAdapter: PostsAdapater

    private lateinit var postsRecyclerView: RecyclerView

    private lateinit var refreshLayout: SwipeRefreshLayout

    private lateinit var postsCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsCount = findViewById(R.id.postsCount)

        postsRecyclerView = findViewById(R.id.recyclerView)

        refreshLayout = findViewById(R.id.refreshLayout)

        refreshLayout.setOnRefreshListener {
            getDataFromApi()
        }

        var postList = App.instance.db.getPostsDao().getAllPosts()

        if(postList.size <= 0) {
            getDataFromApi()
        }

        postsCount.text = "Count: " + postList.size.toString()

        recyclerViewPostsAdapter = PostsAdapater(postList)
        //postsRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = recyclerViewPostsAdapter

    }

    fun getDataFromApi() {
        refreshLayout.isRefreshing = true;
        RetrofitClient.JsonPlaceholderApi.getPosts().enqueue(object : Callback<List<PostDto>> {
            override fun onResponse(
                    call: Call<List<PostDto>>,
                    response: Response<List<PostDto>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    response.body()?.forEach { post ->
                        var insertPost = Post(post.id, post.userId, post.title, post.body)
                        App.instance.db.getPostsDao().insert(insertPost)
                        refreshLayout.isRefreshing = false
                    }
                }
            }

            override fun onFailure(call: Call<List<PostDto>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Log.d("FAIL", t.toString())
            }
        })

    }
}