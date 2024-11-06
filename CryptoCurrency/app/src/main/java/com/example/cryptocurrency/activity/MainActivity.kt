package com.example.cryptocurrency.activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.cryptocurrency.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fragment)

        // Khởi tạo NavController
        navController = findNavController(R.id.nav_host_fragment)

        // Thiết lập sự kiện cho BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.mainFragment)
                    true
                }
                R.id.thenew -> {
                    navController.navigate(R.id.newFragment)
                    true
                }
                R.id.invest -> {
                    navController.navigate(R.id.investFragment)
                    true
                }
                R.id.deposit -> {
                    navController.navigate(R.id.depositFragment)
                    true
                }
                R.id.setting -> {
                    navController.navigate(R.id.setting_fragment)
                    true
                }
                else -> false
            }
        }

        // Thiết lập tab mặc định
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.home
        }
    }
}

