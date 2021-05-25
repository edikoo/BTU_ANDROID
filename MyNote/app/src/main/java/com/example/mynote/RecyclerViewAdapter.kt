package com.example.mynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val list: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val firstNameTextView: TextView = itemView.findViewById(R.id.textView)

        fun bindSet(sets: String) {
            if (sets != null) {
                for (set in sets) {
                    firstNameTextView.text = set.toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindSet(list[position])
    }

    override fun getItemCount() = list.size


}

