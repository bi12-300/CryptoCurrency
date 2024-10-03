package com.example.cryptocurrency.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R

class DepositAdapter : RecyclerView.Adapter<DepositAdapter.ViewHolder>() {

    // Danh sách dữ liệu (có thể thay thế bằng danh sách dữ liệu thực tế)
    private val dataList = listOf("BTC", "ETH", "LTC") // Ví dụ về tên ngắn

    // Tạo view holder
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shortNameTextView: TextView = view.findViewById(R.id.coin_short_name) // ID cho tên ngắn
        val fullNameTextView: TextView = view.findViewById(R.id.coin_full_name) // ID cho tên đầy đủ
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deposit_item, parent, false) // Sử dụng layout item
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shortNameTextView.text = dataList[position] // Gán tên ngắn cho TextView
        holder.fullNameTextView.text = "Full name for ${dataList[position]}" // Gán tên đầy đủ cho TextView
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
