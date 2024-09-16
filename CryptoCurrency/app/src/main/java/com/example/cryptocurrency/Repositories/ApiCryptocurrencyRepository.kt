import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import java.io.IOException
import com.example.cryptocurrency.Repositories.CryptocurrencyRepository
import com.example.cryptocurrency.Repositories.CryptocurrencyApi
import com.example.cryptocurrency.Domain.Cryptocurrency
import com.example.cryptocurrency.Repositories.CryptocurrencyResponse

class ApiCryptocurrencyRepository : CryptocurrencyRepository {

    private val api: CryptocurrencyApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest\n")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CryptocurrencyApi::class.java)
    }

    override suspend fun fetchCryptocurrencyData(symbol: String): Cryptocurrency {
        return try {
            val response = api.fetchCryptocurrencyData(symbol).await()
            val cryptoResponse = response.body() ?: throw NullPointerException("Response body is null")
            Cryptocurrency(
                symbol = cryptoResponse.symbol,
                name = cryptoResponse.name,
                price = cryptoResponse.current_price,
                marketCap = cryptoResponse.market_cap,
                volume24h = cryptoResponse.total_volume,
                circulatingSupply = cryptoResponse.circulating_supply
            )
        } catch (e: Exception) {
            throw Exception("Failed to fetch cryptocurrency data for $symbol", e)
        }
    }

    override suspend fun fetchMarketData(): List<Cryptocurrency> {
        return try {
            val response = api.fetchMarketData("usd").await()
            val cryptoResponses = response.body() ?: throw NullPointerException("Response body is null")
            cryptoResponses.map { cryptoResponse ->
                Cryptocurrency(
                    symbol = cryptoResponse.symbol,
                    name = cryptoResponse.name,
                    price = cryptoResponse.current_price,
                    marketCap = cryptoResponse.market_cap,
                    volume24h = cryptoResponse.total_volume,
                    circulatingSupply = cryptoResponse.circulating_supply
                )
            }
        } catch (e: Exception) {
            throw Exception("Failed to fetch market data", e)
        }
    }
}

