package com.example.cryptocurrency

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Adapter.CryptocurrencyAdapter
import com.example.cryptocurrency.ViewModel.CryptocurrencyViewModel
import android.view.MenuItem
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment)

        // Setup RecyclerView and Adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        cryptocurrencyAdapter = CryptocurrencyAdapter(emptyList())
        recyclerView.adapter = cryptocurrencyAdapter

        cryptocurrencyViewModel.cryptocurrencyList.observe(this, Observer { coinList ->
            cryptocurrencyAdapter.updateData(coinList)
        })

        cryptocurrencyViewModel.fetchCryptocurrencies()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {  item: MenuItem ->
            when (item.itemId) {
                R.id.market-> {
                    val intent = Intent(this, TrendActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val secondActButton = findViewById<Button>(R.id.second_act_btn)
        secondActButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}






