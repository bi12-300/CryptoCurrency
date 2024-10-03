package com.example.cryptocurrency.Fragment.Deposit

import com.example.cryptocurrency.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Adapter.DepositAdapter

class DepositFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.deposit, container, false)

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_coins)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Tạo và thiết lập adapter cho RecyclerView
        val adapter = DepositAdapter() // Thay thế MyAdapter bằng adapter của bạn
        recyclerView.adapter = adapter

        // Có thể thêm dữ liệu vào adapter tại đây nếu cần

        return view
    }
}
