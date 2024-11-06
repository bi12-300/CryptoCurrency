package com.example.cryptocurrency.fragment.deposit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class CoinDetailFragment : Fragment() {
    private lateinit var coinName: String
    private lateinit var coinPrice: String
    private lateinit var marketCap: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Nhận dữ liệu từ arguments sử dụng NavArgs
        arguments?.let {
            val args = CoinDetailFragmentArgs.fromBundle(it)
            coinName = args.coinName
            coinPrice = args.coinPrice
            marketCap = args.marketCap
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.coin_detail, container, false)

        // Khởi tạo giao diện với dữ liệu đã nhận
        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        val coinNameTextView = view.findViewById<TextView>(R.id.coin_name)
        val coinPriceTextView = view.findViewById<TextView>(R.id.coin_price) // Nếu bạn có trường này trong layout

        coinNameTextView.text = coinName
        coinPriceTextView.text = coinPrice
    }

    fun onBackClicked(view: View?) {
        activity?.supportFragmentManager?.popBackStack() // Quay lại fragment trước đó
    }
}

