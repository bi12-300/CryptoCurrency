package com.example.cryptocurrency.fragment.deposit

import com.example.cryptocurrency.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.adapter.DepositAdapter
import com.example.cryptocurrency.domain.Quote
import com.example.cryptocurrency.domain.USD

import com.example.cryptocurrency.domain.Cryptocurrency

class DepositFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.deposit, container, false)
        recyclerView = view.findViewById(R.id.recyclerView_coins)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val coinList = listOf<Cryptocurrency>(
            Cryptocurrency("Bitcoin", 60000.0, 2.0, "BTC", 1000000000.0, Quote(USD(60000.0, 2.0, 1000000000.0)), 0.0),
            Cryptocurrency("Ethereum", 4000.0, 3.0, "ETH", 500000000.0, Quote(USD(4000.0, 3.0, 500000000.0)), 0.0),
            Cryptocurrency("Binance Coin", 500.0, 1.5, "BNB", 700000000.0, Quote(USD(500.0, 1.5, 700000000.0)), 0.0),
            Cryptocurrency("Cardano", 2.0, 4.0, "ADA", 50000000.0, Quote(USD(2.0, 4.0, 50000000.0)), 0.0),
            Cryptocurrency("Solana", 200.0, 5.0, "SOL", 300000000.0, Quote(USD(200.0, 5.0, 300000000.0)), 0.0),
            Cryptocurrency("Ripple", 1.0, -1.0, "XRP", 40000000.0, Quote(USD(1.0, -1.0, 40000000.0)), 0.0),
            Cryptocurrency("Dogecoin", 0.25, 6.0, "DOGE", 15000000.0, Quote(USD(0.25, 6.0, 15000000.0)), 0.0),
            Cryptocurrency("Polkadot", 25.0, 2.5, "DOT", 25000000.0, Quote(USD(25.0, 2.5, 25000000.0)), 0.0),
            Cryptocurrency("Chainlink", 30.0, 3.5, "LINK", 10000000.0, Quote(USD(30.0, 3.5, 10000000.0)), 0.0),
            Cryptocurrency("Litecoin", 150.0, 2.0, "LTC", 12000000.0, Quote(USD(150.0, 2.0, 12000000.0)), 0.0)
        )

        // Tạo và thiết lập adapter cho RecyclerView
        val adapter = DepositAdapter(coinList)
        recyclerView.adapter = adapter

        return view
    }
}
