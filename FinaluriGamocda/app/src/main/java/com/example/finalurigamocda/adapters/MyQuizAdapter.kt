package com.example.finalurigamocda.adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalurigamocda.R
import com.example.finalurigamocda.models.Quiz

class MyQuizAdapter(private val list: List<Quiz>) : RecyclerView.Adapter<MyQuizAdapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         val quizTitle: TextView = itemView.findViewById(R.id.quizTitle)

        fun bindQuiz(quiz: Quiz) {
            quizTitle.text = quiz.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindQuiz(list[position])
    }

    override fun getItemCount() = list.size


}

