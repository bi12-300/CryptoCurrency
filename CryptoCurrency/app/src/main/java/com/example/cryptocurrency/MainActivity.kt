package com.example.cryptocurrency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.databinding.LayoutBinding
import com.example.cryptocurrency.Domain.PortfolioItem
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import com.example.cryptocurrency.fragment.DashboardFragment
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    // Khai báo biến binding cho View Binding
    private lateinit var binding: LayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(DashboardFragment())


    }

    // Hàm để tải Fragment mới
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}





