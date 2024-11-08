package com.example.cryptocurrency.fragment.deposit

import com.example.cryptocurrency.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.adapter.DepositAdapter
import com.example.cryptocurrency.domain.Quote
import com.example.cryptocurrency.domain.USD

import com.example.cryptocurrency.domain.Cryptocurrency

class DepositFragment : Fragment(), DepositAdapter.OnCoinClickListener {

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
            // Thêm các đồng tiền khác vào đây
        )

        // Tạo và thiết lập adapter cho RecyclerView
        val adapter = DepositAdapter(coinList, this) // Truyền listener
        recyclerView.adapter = adapter

        return view
    }

    override fun onCoinClick(coin: Cryptocurrency) {
        val action = DepositFragmentDirections.actionDepositFragmentToCoinDetailFragment(
            coin.name,
            coin.price.toString(),
            coin.marketCap.toString()
        )
        findNavController().navigate(action)
    }

}

