package com.example.cryptocurrency.ViewModel

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Domain.Coin
import com.example.cryptocurrency.R

// ViewHolder đại diện cho từng item của đồng coin
class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Các view của item coin
    // Ánh xạ các view từ layout item_coin.xml
    var coinNameTextView: TextView = itemView.findViewById(R.id.coin_name)
    var coinPriceTextView: TextView = itemView.findViewById(R.id.coin_price)

    // Phương thức để gán dữ liệu của một đối tượng coin vào ViewHolder
    fun bind(coin: Coin) {
        // Truy cập trực tiếp vào các thuộc tính của Coin
        coinNameTextView.text = coin.name  // Sử dụng thuộc tính công khai
        coinPriceTextView.text = coin.price  // Sử dụng thuộc tính công khai
    }
}
