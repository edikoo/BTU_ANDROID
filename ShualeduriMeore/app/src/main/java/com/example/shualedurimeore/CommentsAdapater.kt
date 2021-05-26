package com.example.shualedurimeore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import com.example.rest.api.dto.CommentDto


class CommentsAdapater(private val comments: List<CommentDto>) : RecyclerView.Adapter<CommentsAdapater.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val comName: TextView = itemView.findViewById(R.id.commentName)
        private val comEmail: TextView = itemView.findViewById(R.id.commentEmail)
        private val comBody: TextView = itemView.findViewById(R.id.commentBody)

        fun bindComment(comment: CommentDto) {
            comName.text = comment.name
            comEmail.text = comment.email
            comBody.text = comment.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_comments_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindComment(comments[position])
    }

    override fun getItemCount() = comments.size

}