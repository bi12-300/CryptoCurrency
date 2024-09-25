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
import com.example.cryptocurrency.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private val cryptocurrencyViewModel: CryptocurrencyViewModel by viewModels()

    // Initialize the BottomNavigationView
    private lateinit var bottomNavigationView: BottomNavigationView

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

        // Find BottomNavigationView by ID
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Handle BottomNavigationView item clicks
        bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.market -> {
                    val intent = Intent(this, TrendActivity::class.java)
                    startActivity(intent)
                    true
                }//phan toi them vao, ben tren co the khac voi file cu
                R.id.news -> {
                    val newsFragment = NewsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, newsFragment)
                        .commit()
                    true
                }
                R.id.home -> {
                    // Handle Home tab click, you can add logic here
                    true
                }
                else -> false
            }
        }

        // Button to navigate to SecondActivity
        val secondActButton = findViewById<Button>(R.id.second_act_btn)
        secondActButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
