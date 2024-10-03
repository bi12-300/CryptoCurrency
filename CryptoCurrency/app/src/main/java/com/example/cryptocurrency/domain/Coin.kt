package com.example.cryptocurrency.domain

data class Coin(
    val name: String,
    val price: Double,
    val marketCap: Double,
    val percentChange: Double,
    val symbol: String,
    val quote: Quote

)


