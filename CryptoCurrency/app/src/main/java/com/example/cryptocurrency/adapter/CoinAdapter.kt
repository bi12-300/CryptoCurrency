package com.example.cryptocurrency.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Cryptocurrency

class CoinAdapter(private val context: Context, private var coinList: List<Cryptocurrency>) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    // ViewHolder đại diện cho mỗi item
    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val coinAmountTextView: TextView = itemView.findViewById(R.id.amountTxt)
        val coinBalanceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val coinChangeTextView: TextView = itemView.findViewById(R.id.percentTxt)
        val coinMarketCapTextView: TextView = itemView.findViewById(R.id.textViewMarketCap)
        val coinImageView: ImageView = itemView.findViewById(R.id.pic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cryptocurrency, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]

        // Thiết lập dữ liệu cho các thành phần trong item layout
        holder.coinNameTextView.text = coin.name
        holder.coinAmountTextView.text = String.format("%.2f %s", coin.amount, coin.symbol)
        holder.coinBalanceTextView.text = String.format("$%,.2f", coin.price)
        holder.coinChangeTextView.text = String.format("%.2f%%", coin.percentChange)
        holder.coinMarketCapTextView.text = String.format("$%,.2f", coin.marketCap)
        holder.coinImageView.setImageResource(coin.imageResource)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    fun updateData(newCoinList: List<Cryptocurrency>) {
        coinList = newCoinList
        notifyDataSetChanged()
    }
}
