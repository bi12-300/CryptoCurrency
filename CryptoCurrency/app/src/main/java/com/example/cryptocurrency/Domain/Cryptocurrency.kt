package com.example.cryptocurrency.Domain;




data class Cryptocurrency(
    val name: String,
    val price: Double,
    val symbol: String,
    val quote: Quote,
    val percentChange: Double,
)

