package com.example.cryptocurrency.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class CoinDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.coin_detail, container, false)

        // Nhận dữ liệu từ arguments
        val coinName = arguments?.getString("coin_name")
        val coinPrice = arguments?.getString("coin_price")
        val marketCap = arguments?.getString("market_cap")

        // Khởi tạo giao diện với dữ liệu đã nhận
        initViews(view, coinName, coinPrice, marketCap)

        return view
    }

    private fun initViews(view: View, coinName: String?, coinPrice: String?, marketCap: String?) {
        val coinNameTextView = view.findViewById<TextView>(R.id.coin_name)
        val coinPriceTextView = view.findViewById<TextView>(R.id.coin_price)

        coinNameTextView.text = coinName
        coinPriceTextView.text = coinPrice

    }

    fun onBackClicked(view: View?) {
        activity?.supportFragmentManager?.popBackStack() // Quay lại fragment trước đó
    }
}
