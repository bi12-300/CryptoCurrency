package com.example.cryptocurrency.domain

data class Post(
    val username: String,
    val time: String,
    val content: String,  // Dữ liệu nội dung của bài viết
    val imageResId: Int   // ID của hình ảnh
)
