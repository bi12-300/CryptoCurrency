package com.example.cryptocurrency.Repositories

import com.example.cryptocurrency.Domain.Cryptocurrency

interface CryptocurrencyRepository {
    suspend fun fetchCryptocurrencyData(symbol: String): Cryptocurrency
    suspend fun fetchMarketData(): List<Cryptocurrency>
}

