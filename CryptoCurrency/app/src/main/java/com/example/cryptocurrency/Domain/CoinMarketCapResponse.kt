package com.example.cryptocurrency.Domain
import com.example.cryptocurrency.Domain.Cryptocurrency

data class CoinMarketCapResponse(
    val data: List<Cryptocurrency>
)
