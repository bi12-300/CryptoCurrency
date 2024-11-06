package com.example.cryptocurrency.domain

data class InvestItem(
    val name: String,
    val amount: Double, // Hoặc kiểu dữ liệu khác mà bạn muốn
    val price: Double,  // Giá trị tương ứng
    val status: String, // Trạng thái như "Buy", "Sell", v.v.
    val imageUrl: String // URL hình ảnh nếu cần
)
