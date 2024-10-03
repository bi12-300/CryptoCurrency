package com.example.cryptocurrency.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Domain.Coin
import com.example.cryptocurrency.R
import com.example.cryptocurrency.Fragment.CoinDetailFragment

class CoinAdapter(private val context: Context, private val coinList: List<Coin>) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cryptocurrency, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]
        holder.bind(coin)

        // Set OnClickListener for the item
        holder.itemView.setOnClickListener {
            // Create an intent to navigate to CoinDetailActivity
            val intent = Intent(context, CoinDetailFragment::class.java).apply {
                putExtra("coin_name", coin.name)  // Truy cập trực tiếp vào thuộc tính
                putExtra("coin_price", coin.price)  // Truy cập trực tiếp vào thuộc tính
                putExtra("market_cap", coin.marketCap)  // Truy cập trực tiếp vào thuộc tính
            }

            // Start CoinDetailActivity
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = coinList.size

    // ViewHolder Class
    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coinName: TextView = itemView.findViewById(R.id.coin_name)
        private val coinPrice: TextView = itemView.findViewById(R.id.coin_price)

        fun bind(coin: Coin) {
            coinName.text = coin.name  // Truy cập trực tiếp vào thuộc tính
            coinPrice.text = coin.price  // Truy cập trực tiếp vào thuộc tính
        }
    }
}
