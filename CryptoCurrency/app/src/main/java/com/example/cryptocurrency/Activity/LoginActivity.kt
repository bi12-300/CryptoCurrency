package com.example.cryptocurrency.Activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrency.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Thay thế với layout của bạn

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            // Khi nhấn nút Login, mở MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Kết thúc LoginActivity nếu không cần quay lại
        }
    }
}