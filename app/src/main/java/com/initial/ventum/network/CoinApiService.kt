package com.initial.ventum.network

import com.google.gson.JsonArray
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// CoinGecko API base URL
private const val BASE_URL =
    "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin"

// Use Retrofit to handle REST API calls and parse JSON
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface CoinApiService {
    @GET("prices")
    suspend fun getPrices(): String
}

// singleton object for Retrofit API
object CoinApi{
    val retrofitService: CoinApiService by lazy {
        retrofit.create(CoinApiService::class.java)
    }
}