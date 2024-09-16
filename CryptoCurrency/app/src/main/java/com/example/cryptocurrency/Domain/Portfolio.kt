package com.example.cryptocurrency.Domain

data class PortfolioItem(
    val cryptocurrency: Cryptocurrency,
    var amount: Double,
    var purchasePrice: Double
) {
    fun currentValue(): Double {
        return amount * cryptocurrency.price
    }

    fun profitLoss(): Double {
        return currentValue() - (amount * purchasePrice)
    }
}