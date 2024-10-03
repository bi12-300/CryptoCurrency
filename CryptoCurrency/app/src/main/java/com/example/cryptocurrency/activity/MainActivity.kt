package com.example.cryptocurrency.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R
import com.example.cryptocurrency.fragment.Main.MainFragment
import com.example.cryptocurrency.fragment.invest.InvestFragment
import com.example.cryptocurrency.fragment.deposit.DepositFragment
import com.example.cryptocurrency.fragment.New.NewFragment
import com.example.cryptocurrency.fragment.Setting.SettingFragment
import com.example.cryptocurrency.viewModel.CryptocurrencyViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment) // Sử dụng layout cho MainActivity

        // Setup BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    // Navigate to MainFragment
                    openFragment(MainFragment())
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

                R.id.setting -> {
                    // Navigate to SettingFragment
                    openFragment(SettingFragment())
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
            .replace(R.id.content_frame, fragment) // Replace with the correct ViewGroup ID
            .commit()
    }
}
