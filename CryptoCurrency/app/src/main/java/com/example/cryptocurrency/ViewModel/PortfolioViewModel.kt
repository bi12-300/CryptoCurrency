package com.example.cryptocurrency.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptocurrency.Repositories.CryptocurrencyResponse
import androidx.lifecycle.map
import com.example.cryptocurrency.Domain.PortfolioItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.cryptocurrency.RetrofitClient

class PortfolioViewModel : ViewModel() {
    private val _portfolioItem = MutableLiveData<PortfolioItem>()
    val portfolioItem: LiveData<PortfolioItem> get() = _portfolioItem

    fun n m,updatePortfolioItem(item: PortfolioItem) {
        _portfolioItem.value = item
    }

    fun fetchCryptocurrencyPrice(symbol: String) {
        RetrofitClient.apiService.fetchCryptocurrencyData(symbol).enqueue(object : Callback<CryptocurrencyResponse> {
            override fun onResponse(call: Call<CryptocurrencyResponse>, response: Response<CryptocurrencyResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        updateCryptocurrencyPrice(it.current_price) // Adjust based on actual response structure
                    }
                }
            }

            override fun onFailure(call: Call<CryptocurrencyResponse>, t: Throwable) {
                // Handle error
            }
        })
    }

    private fun updateCryptocurrencyPrice(newPrice: Double) {
        val currentItem = _portfolioItem.value
        currentItem?.cryptocurrency?.price = newPrice
        _portfolioItem.value = currentItem // Trigger LiveData update
    }
}
