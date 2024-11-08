package com.example.cryptocurrency.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R
import com.example.cryptocurrency.fragment.main.MainFragment
import com.example.cryptocurrency.fragment.New.NewFragment
import com.example.cryptocurrency.fragment.deposit.DepositFragment
import com.example.cryptocurrency.fragment.invest.InvestFragment
import com.example.cryptocurrency.fragment.Setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Đảm bảo sử dụng layout đúng tên

        // Initial fragment setup
        if (savedInstanceState == null) {
            replaceFragment(MainFragment()) // Replace with the initial fragment
        }

        // Set up BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(MainFragment())
                    true
                }
                R.id.thenew -> {
                    replaceFragment(NewFragment())
                    true
                }
                R.id.invest -> {
                    replaceFragment(InvestFragment())
                    true
                }
                R.id.deposit -> {
                    replaceFragment(DepositFragment())
                    true
                }
                R.id.setting -> {
                    replaceFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }

        // Default tab selection
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.home
        }

        // Setup Drawer Layout
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.openDrawer, R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    // Helper function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()
    }
}

