package com.example.rest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rest.api.dto.User
import android.content.Intent


class RecyclerViewAdapter(private val list: List<User>) : RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        private val email: TextView = itemView.findViewById(R.id.textView)
        private val firstNameTextView: TextView = itemView.findViewById(R.id.textView2)
        private val lastNameTextView: TextView = itemView.findViewById(R.id.textView3)

        fun bindUser(user: User) {
            Glide.with(itemView)
                .load(user.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView)

            email.text = user.email
            firstNameTextView.text = user.firsName
            lastNameTextView.text = user.lastName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bindUser(list[position])

        holder.itemView.setOnClickListener {
            v: View -> Unit
            Log.d("kaxa", "onItemClick for ID: " + list[holder.position].id)


            val intent = Intent(v.context, SecondActivity::class.java)
            intent.putExtra("id", list[holder.position].id)
            v.context.startActivity(intent)

        }

    }

    override fun getItemCount() = list.size


}