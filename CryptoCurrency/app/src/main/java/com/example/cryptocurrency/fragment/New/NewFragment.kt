package com.example.cryptocurrency.fragment.New

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptocurrency.R
import com.example.cryptocurrency.adapter.PostAdapter
import com.example.cryptocurrency.domain.Post

class NewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter  // Adapter của bạn

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.new_menu, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Dữ liệu mẫu cho danh sách bài viết
        val posts = listOf(
            Post("User 1", "1 giờ trước", "Nội dung bài viết 1", R.drawable.spgt6kng_mid),
            Post("User 2", "2 giờ trước", "Nội dung bài viết 2", R.drawable.spgt6kng_mid)
        )

        // Khởi tạo adapter và gán cho RecyclerView
        postAdapter = PostAdapter(posts)
        recyclerView.adapter = postAdapter

        return view
    }
}

