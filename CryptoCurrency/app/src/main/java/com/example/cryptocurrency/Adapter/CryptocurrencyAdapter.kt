package com.example.cryptocurrency.Adapter
import com.example.cryptocurrency.Domain.Cryptocurrency
// ui/CryptocurrencyAdapter.kt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.databinding.ItemCryptocurrencyBinding

class CryptocurrencyAdapter : RecyclerView.Adapter<CryptocurrencyAdapter.ViewHolder>() {

    private var cryptocurrencyList: List<Cryptocurrency> = listOf()

    inner class ViewHolder(val binding: ItemCryptocurrencyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCryptocurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cryptocurrency = cryptocurrencyList[position]
        holder.binding.textViewName.text = cryptocurrency.name
        holder.binding.textViewPrice.text = cryptocurrency.price.toString()
        // Bind other views
    }

    override fun getItemCount(): Int = cryptocurrencyList.size

    fun submitList(list: List<Cryptocurrency>) {
        cryptocurrencyList = list
        notifyDataSetChanged()
    }
}
