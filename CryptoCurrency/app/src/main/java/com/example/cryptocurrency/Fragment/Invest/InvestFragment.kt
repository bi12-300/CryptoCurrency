package com.example.cryptocurrency.Fragment.Invest

import com.example.cryptocurrency.Fragment.Deposit.DepositFragment
import com.example.cryptocurrency.R
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class InvestFragment : Fragment() {

    private lateinit var buttonInvest: Button
    private lateinit var buttonBuy: Button
    private lateinit var buttonSettings: ImageButton
    private lateinit var totalValue: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.invest, container, false)

        // Ánh xạ các thành phần giao diện
        buttonInvest = view.findViewById(R.id.button_invest)
        buttonBuy = view.findViewById(R.id.button_withdraw)
        buttonSettings = view.findViewById(R.id.button_settings)
        totalValue = view.findViewById(R.id.totalValue)
        recyclerView = view.findViewById(R.id.recyclerView)

        // Xử lý sự kiện nút "Nạp tiền"
        buttonInvest.setOnClickListener {
            // Chuyển sang một Fragment khác thay vì sử dụng Intent
            parentFragmentManager.beginTransaction()
                .replace(R.id.button_invest, DepositFragment()) // Giả sử có DepositFragment
                .addToBackStack(null)
                .commit()
        }

        // Xử lý sự kiện nút "Buy"
        buttonBuy.setOnClickListener {
            // Sử dụng NavController để điều hướng
            val navController = parentFragmentManager.findFragmentById(R.id.button_withdraw)?.let { fragment ->
                fragment.view?.let { view ->
                    androidx.navigation.Navigation.findNavController(view)
                }
            }

            navController?.navigate(R.id.action_InvestFragment_to_InvestBuyFragment)
        }


        return view
    }
}
