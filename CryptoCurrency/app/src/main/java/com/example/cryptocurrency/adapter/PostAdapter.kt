package com.example.cryptocurrency.adapter
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Post
import com.example.cryptocurrency.viewModel.NewItemViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<NewItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.new_item, parent, false)
        return NewItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewItemViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
