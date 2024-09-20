package com.example.cryptocurrency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrency.Domain.Cryptocurrency
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class TrendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        val cryptoList = listOf(
            Cryptocurrency("Bitcoin", 60230.0, 5.0, 1.45),
            Cryptocurrency("Ethereum", 3000.0, -2.5, 14.5),
            Cryptocurrency("Litecoin", 200.0, 1.2, 57.0),
            Cryptocurrency("Binance Coin", 70330.0, 5.0, 1.45),
            Cryptocurrency("Tether", 3000.0, -4.5, 12.0),
            Cryptocurrency("USD Coin", 200.0, 1.7, 53.0),
            Cryptocurrency("Cardano", 5034.0, 6.0, 1.45),
            Cryptocurrency("Solana", 30340.0, -2.5, 10.0),
            Cryptocurrency("XRP", 2045.0, 1.2, 50.0)
        )

        val adapter = CryptocurrencyAdapter(cryptoList)
        recyclerView.adapter = adapter
    }
}
