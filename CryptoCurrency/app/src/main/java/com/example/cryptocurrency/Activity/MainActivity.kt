package com.example.cryptocurrency.Activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import com.example.cryptocurrency.Fragment.DashboardFragment // Nhập fragment bạn muốn sử dụng
import com.example.cryptocurrency.Fragment.Invest.InvestFragment // Nhập fragment cho đầu tư
import com.example.cryptocurrency.Fragment.Deposit.DepositFragment // Nhập fragment cho gửi tiền
import com.example.cryptocurrency.Fragment.New.NewFragment // Nhập fragment cho màn hình mới
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment) // Sử dụng layout cho MainActivity

        // Setup BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    // Navigate to DashboardFragment
                    openFragment(DashboardFragment())
                    true
                }
                R.id.thenew -> {
                    // Navigate to NewFragment
                    openFragment(NewFragment())
                    true
                }
                R.id.invest -> {
                    // Navigate to InvestFragment
                    openFragment(InvestFragment())
                    true
                }
                R.id.deposit -> {
                    // Navigate to DepositFragment
                    openFragment(DepositFragment())
                    true
                }
                else -> false
            }
        }

        // Mở fragment mặc định khi khởi động
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.home // Chọn tab mặc định
        }
    }

    // Hàm để mở fragment
    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_navigation, fragment) // Thay thế ID này với ID của ViewGroup trong layout
            .commit()
    }
}
