package com.example.cryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Cryptocurrency

class DepositAdapter(
    private var dataList: List<Cryptocurrency> = emptyList(),
    private val listener: OnCoinClickListener // Thêm listener
) : RecyclerView.Adapter<DepositAdapter.DepositViewHolder>() {

    interface OnCoinClickListener {
        fun onCoinClick(coin: Cryptocurrency)
    }

    class DepositViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinShortNameTextView: TextView = itemView.findViewById(R.id.coin_short_name)
        val coinFullNameTextView: TextView = itemView.findViewById(R.id.coin_full_name)
        val coinPriceTextView: TextView = itemView.findViewById(R.id.coin_price)
        val coinPercentageChangeTextView: TextView = itemView.findViewById(R.id.coin_percentage_change)

        fun bind(coin: Cryptocurrency, listener: OnCoinClickListener) {
            itemView.setOnClickListener {
                listener.onCoinClick(coin) // Gọi listener khi nhấn vào item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deposit_item, parent, false)
        return DepositViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepositViewHolder, position: Int) {
        val coin = dataList[position]
        holder.bind(coin, listener) // Gọi bind và truyền listener
        holder.coinShortNameTextView.text = coin.symbol // Hoặc coin.name nếu đó là tên ngắn
        holder.coinFullNameTextView.text = coin.name
        holder.coinPriceTextView.text = String.format("$%.2f", coin.amount) // Giả sử amount là giá
        holder.coinPercentageChangeTextView.text = "+5.25%" // Ví dụ dữ liệu
    }

    override fun getItemCount(): Int = dataList.size

    fun updateData(newDataList: List<Cryptocurrency>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}



