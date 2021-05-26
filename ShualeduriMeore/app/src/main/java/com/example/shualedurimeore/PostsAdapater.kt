package com.example.shualedurimeore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import com.google.gson.Gson


class PostsAdapater(private val posts: List<Post>) : RecyclerView.Adapter<PostsAdapater.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.postTitle)
        private val body: TextView = itemView.findViewById(R.id.postBody)

        fun bindPost(post: Post) {
            title.text = post.postTitle
            body.text = post.postBody
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindPost(posts[position])

        holder.itemView.setOnClickListener {
            v: View -> Unit

            val intent = Intent(v.context, SecondActivity::class.java)

            val gson = Gson()

            intent.putExtra("post", gson.toJson(posts[holder.position]))
            v.context.startActivity(intent)

        }

    }

    override fun getItemCount() = posts.size


}