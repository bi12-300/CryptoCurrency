package com.example.cryptocurrency.Repositories

data class CryptocurrencyResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double,   // API field
    val market_cap: Double,      // API field
    val total_volume: Double,    // API field
    val circulating_supply: Double // API field
)
