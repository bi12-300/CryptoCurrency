package com.example.cryptocurrency.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.adapter.CryptocurrencyAdapter
import com.example.cryptocurrency.R
import com.example.cryptocurrency.viewModel.CryptocurrencyViewModel

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false) // Sửa lại layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView and Adapter
        recyclerView = view.findViewById(R.id.recyclerView) // Đảm bảo ID này đúng
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        cryptocurrencyAdapter = CryptocurrencyAdapter(emptyList())
        recyclerView.adapter = cryptocurrencyAdapter

        // Quan sát dữ liệu từ ViewModel
        cryptocurrencyViewModel.cryptocurrencyList.observe(viewLifecycleOwner) { coinList ->
            coinList?.let {
                cryptocurrencyAdapter.updateData(it)
            }
        }

        // Gọi phương thức fetch ban đầu để load dữ liệu khi fragment khởi tạo
        fetchData()
    }

    private fun fetchData() {
        cryptocurrencyViewModel.fetchCryptocurrencies()
    }
}


