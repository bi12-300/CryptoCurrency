package com.example.cryptocurrency.Fragment.Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import com.example.cryptocurrency.R
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard_fragment, container, false) // Thay thế với layout của MainFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView and Adapter
        recyclerView = view.findViewById(R.id.recyclerView) // Đảm bảo ID này là chính xác
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        cryptocurrencyAdapter = CryptocurrencyAdapter(emptyList())
        recyclerView.adapter = cryptocurrencyAdapter

        cryptocurrencyViewModel.cryptocurrencyList.observe(viewLifecycleOwner) { coinList ->
            cryptocurrencyAdapter.updateData(coinList)
        }

        cryptocurrencyViewModel.fetchCryptocurrencies()
    }
}
