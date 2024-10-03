package com.example.cryptocurrency.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import com.example.cryptocurrency.Domain.CoinMarketCapResponse

interface CoinMarketCapService {
    @Headers("X-CMC_PRO_API_KEY: ea9fabf5-439a-4026-8aba-f924c52f6a77") // Thay thế bằng API key của bạn
    @GET("v1/cryptocurrency/listings/latest")
    fun getLatestListings(): Call<CoinMarketCapResponse>
}
