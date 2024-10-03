package com.example.cryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Cryptocurrency

class DepositAdapter(private var dataList: List<Cryptocurrency> = emptyList()) :
    RecyclerView.Adapter<DepositAdapter.DepositViewHolder>() {

    class DepositViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coinNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val coinAmountTextView: TextView = itemView.findViewById(R.id.amountTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deposit_item, parent, false)
        return DepositViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepositViewHolder, position: Int) {
        val coin = dataList[position]
        holder.coinNameTextView.text = coin.name
        holder.coinAmountTextView.text = String.format("%.2f %s", coin.amount, coin.symbol)
        // Thiết lập các TextView khác nếu cần
    }

    override fun getItemCount(): Int = dataList.size

    fun updateData(newDataList: List<Cryptocurrency>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}
