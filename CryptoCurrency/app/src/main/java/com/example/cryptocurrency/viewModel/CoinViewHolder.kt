package com.example.cryptocurrency.viewModel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.domain.Coin
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Cryptocurrency


class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val pic: ImageView = itemView.findViewById(R.id.pic)
    private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    private val amountTxt: TextView = itemView.findViewById(R.id.amountTxt)
    private val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
    private val percentTxt: TextView = itemView.findViewById(R.id.percentTxt)
    private val textViewMarketCap: TextView = itemView.findViewById(R.id.textViewMarketCap) // Thêm ID MarketCap

    fun bind(coin: Cryptocurrency) {
        textViewName.text = coin.name  // Hiển thị tên coin
        amountTxt.text = "1.45 ${coin.symbol}"  // Giả sử giá trị này là cố định
        textViewPrice.text = "$${coin.price}"  // Hiển thị giá coin
        percentTxt.text = "${coin.percentChange}%"  // Hiển thị phần trăm thay đổi
        textViewMarketCap.text = "$${coin.marketCap}"  // Hiển thị market cap
        // Cập nhật ảnh cho coin nếu cần
        // pic.setImageResource(R.drawable.your_image) // Bạn có thể thêm logic để tải ảnh ở đây
    }
}


