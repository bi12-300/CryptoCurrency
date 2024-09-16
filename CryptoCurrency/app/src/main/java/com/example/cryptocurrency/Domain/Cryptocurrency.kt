package com.example.cryptocurrency.Domain;




data class Cryptocurrency(
    val symbol: String,
    val name: String,
    var price: Double,            // More readable domain field
    var marketCap: Double,        // More readable domain field
    var volume24h: Double,        // More readable domain field
    var circulatingSupply: Double // More readable domain field
)

