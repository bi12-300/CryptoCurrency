package com.example.cryptocurrency.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.cryptocurrency.R

import androidx.recyclerview.widget.RecyclerView

data class Post(val username: String, val time: String, val title: String, val content: String, val logo: Int)

class NewAdapter(private val postList: List<Post>) : RecyclerView.Adapter<NewAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postLogo: ImageView = itemView.findViewById(R.id.post_logo)
        val postUsername: TextView = itemView.findViewById(R.id.post_username)
        val postTime: TextView = itemView.findViewById(R.id.post_time)
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postContent: TextView = itemView.findViewById(R.id.post_content)
        val buttonLike: Button = itemView.findViewById(R.id.button_like)
        val buttonShare: Button = itemView.findViewById(R.id.button_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.postLogo.setImageResource(post.logo)
        holder.postUsername.text = post.username
        holder.postTime.text = post.time
        holder.postTitle.text = post.title
        holder.postContent.text = post.content

        // Sự kiện nút Like
        holder.buttonLike.setOnClickListener {
            // Xử lý khi người dùng nhấn Like
        }

        // Sự kiện nút Share
        holder.buttonShare.setOnClickListener {
            // Xử lý khi người dùng nhấn Share
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
