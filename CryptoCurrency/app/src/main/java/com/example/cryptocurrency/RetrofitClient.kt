package com.example.cryptocurrency

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.cryptocurrency.Repositories.CryptocurrencyApi

object RetrofitClient {
    private const val BASE_URL = "https://api.yourservice.com/" // Thay đổi thành URL của bạn
    private const val API_KEY = "ea9fabf5-439a-4026-8aba-f924c52f6a77" // Thay đổi thành API key của bạn

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor(API_KEY))
        .build()

    val apiService: CryptocurrencyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptocurrencyApi::class.java)
    }
}
