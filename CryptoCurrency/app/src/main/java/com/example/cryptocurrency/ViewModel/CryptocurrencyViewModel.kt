package com.example.cryptocurrency.ViewModel
import com.example.cryptocurrency.Domain.Cryptocurrency
import com.example.cryptocurrency.Repositories.CryptocurrencyRepository
// ui/CryptocurrencyViewModel.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CryptocurrencyViewModel(private val repository: CryptocurrencyRepository) : ViewModel() {

    private val _cryptocurrencyData = MutableLiveData<Cryptocurrency>()
    val cryptocurrencyData: LiveData<Cryptocurrency> get() = _cryptocurrencyData

    private val _marketData = MutableLiveData<List<Cryptocurrency>>()
    val marketData: LiveData<List<Cryptocurrency>> get() = _marketData

    fun fetchCryptocurrencyData(symbol: String) {
        viewModelScope.launch {
            try {
                val data = repository.fetchCryptocurrencyData(symbol)
                _cryptocurrencyData.value = data
            } catch (e: Exception) {
                // Handle the exception (e.g., show error message)
            }
        }
    }

    fun fetchMarketData() {
        viewModelScope.launch {
            try {
                val data = repository.fetchMarketData()
                _marketData.value = data
            } catch (e: Exception) {
                // Handle the exception (e.g., show error message)
            }
        }
    }
}
