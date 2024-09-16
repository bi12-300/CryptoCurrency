package com.example.cryptocurrency.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptocurrency.R
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrency.Domain.Cryptocurrency
class DashboardFragment : Fragment() {

    private lateinit var viewModel: CryptocurrencyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Khởi tạo ViewModel
        viewModel = ViewModelProvider(this).get(CryptocurrencyViewModel::class.java)

        // Quan sát dữ liệu cryptocurrency cụ thể
        viewModel.cryptocurrencyData.observe(viewLifecycleOwner) { cryptocurrency ->
            if (cryptocurrency != null) {
                updateCryptocurrencyUI(cryptocurrency)
            } else {
                // Xử lý trường hợp lỗi hoặc dữ liệu null
            }
        }

        // Quan sát dữ liệu thị trường
        viewModel.marketData.observe(viewLifecycleOwner) { marketData ->
            updateMarketDataUI(marketData)
        }

        // Fetch dữ liệu từ API
        viewModel.fetchCryptocurrencyData("BTC") // Ví dụ lấy dữ liệu cho Bitcoin
        viewModel.fetchMarketData()
    }

    private fun updateCryptocurrencyUI(cryptocurrency: Cryptocurrency) {
        // Cập nhật giao diện (TextView, ImageView, etc.) với dữ liệu của cryptocurrency
    }

    private fun updateMarketDataUI(marketData: List<Cryptocurrency>) {
        // Cập nhật RecyclerView hoặc danh sách thị trường với dữ liệu của marketData
    }
}

