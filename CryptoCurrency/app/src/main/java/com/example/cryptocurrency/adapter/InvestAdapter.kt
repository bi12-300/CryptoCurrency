package com.example.cryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.InvestItem

class InvestAdapter(private val investList: List<InvestItem>) : RecyclerView.Adapter<InvestAdapter.InvestViewHolder>() {

    class InvestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.pic)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewAmount: TextView = itemView.findViewById(R.id.amountTxt)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val percentTxt: TextView = itemView.findViewById(R.id.percentTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_invest, parent, false)
        return InvestViewHolder(view)
    }

    override fun onBindViewHolder(holder: InvestViewHolder, position: Int) {
        val investItem = investList[position]
        holder.textViewName.text = investItem.name
        holder.textViewAmount.text = investItem.amount.toString() // Chắc chắn rằng `amount` là thuộc tính của `InvestItem`
        holder.textViewPrice.text = "$${investItem.price}" // Đảm bảo rằng `price` là thuộc tính của `InvestItem`
        holder.percentTxt.text = investItem.status // Nếu bạn có thuộc tính này trong `InvestItem`

        // Nếu bạn muốn tải hình ảnh, bạn có thể cần thêm thư viện như Glide hoặc Picasso
        // Glide.with(holder.imageView.context).load(investItem.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return investList.size
    }
}
