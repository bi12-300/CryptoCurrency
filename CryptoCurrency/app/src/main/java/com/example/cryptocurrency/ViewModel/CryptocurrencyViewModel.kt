package com.example.cryptocurrency.ViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptocurrency.Domain.Cryptocurrency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.cryptocurrency.Domain.CoinMarketCapResponse
import com.example.cryptocurrency.Api.CoinMarketCapService
import com.example.cryptocurrency.Domain.USD
import com.example.cryptocurrency.Domain.Quote


class CryptocurrencyViewModel : ViewModel() {

    val cryptocurrencyList: MutableLiveData<List<Cryptocurrency>> by lazy {
        MutableLiveData<List<Cryptocurrency>>()
    }

    fun fetchCryptocurrencies() {
        val service = RetrofitClient.instance.create(CoinMarketCapService::class.java)
        val call = service.getLatestListings()

        call.enqueue(object : Callback<CoinMarketCapResponse> {
            override fun onResponse(
                call: Call<CoinMarketCapResponse>,
                response: Response<CoinMarketCapResponse>
            ) {
                if (response.isSuccessful) {
                    val cryptos = response.body()?.data?.map { apiCrypto ->
                        Cryptocurrency(
                            name = apiCrypto.name,
                            price = apiCrypto.quote.USD.price,
                            percentChange = apiCrypto.quote.USD.percent_change_24h,
                            symbol = apiCrypto.symbol,
                            quote = Quote(USD(apiCrypto.quote.USD.price, apiCrypto.quote.USD.percent_change_24h)),
                        )
                    }
                    cryptocurrencyList.postValue(cryptos)
                } else {
                    Log.e("API Error", "Response Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<CoinMarketCapResponse>, t: Throwable) {
                Log.e("API Error", t.message.toString())
            }
        })
    }
}
