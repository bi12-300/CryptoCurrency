package com.example.cryptocurrency.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptocurrencyApi {
    @GET("v1/cryptocurrency/quotes/latest")
    fun fetchCryptocurrencyData(
        @Query("symbol") symbol: String, // Add other required parameters here
        @Query("convert") currency: String = "USD" // Default value if applicable
    ): Call<CryptocurrencyResponse>

    @GET("coins/markets")
    fun fetchMarketData(
        @Query("vs_currency") currency: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1
    ): Call<List<CryptocurrencyResponse>>
}