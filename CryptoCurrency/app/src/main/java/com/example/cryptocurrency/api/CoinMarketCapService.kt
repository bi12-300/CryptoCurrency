package com.example.cryptocurrency.api

import com.example.cryptocurrency.domain.CoinMarketCapResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoinMarketCapService {

    @Headers("X-CMC_PRO_API_KEY: ea9fabf5-439a-4026-8aba-f924c52f6a77")
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptocurrencyList(
        @Query("start") start: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("convert") convert: String = "USD"
    ): CoinMarketCapResponse
}
