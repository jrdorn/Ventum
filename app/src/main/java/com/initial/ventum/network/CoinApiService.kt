package com.initial.ventum.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// CoinGecko API base URL
private const val BASE_URL =
    "https://api.coingecko.com/api/v3/coins/"

// Build Moshi object with Kotlin adapter to handle JSON returned by Retrofit
private val moshi = Moshi.Builder()
 .add(KotlinJsonAdapterFactory())
 .build()

/**
MOSHI parse JSON array

val cardsJsonResponse: String = ...
// We can just use a reified extension!
val adapter = moshi.adapter<List<Card>>()
val cards: List<Card> = adapter.fromJson(cardsJsonResponse)

 * */

// expose getData method, return List of CoinData
interface CoinApiService {

 @GET("markets?vs_currency=usd&ids=bitcoin")  // @GET: "bitcoin" endpoint will be requested with HTTP GET
 suspend fun getData(): List<CoinData>

 //
 companion object {
  var apiService: CoinApiService? = null
  fun getInstance(): CoinApiService {
   if (apiService == null) {
    // Build Retrofit object using Moshi converter to perform REST API calls
    apiService = Retrofit.Builder()
     .addConverterFactory(MoshiConverterFactory.create(moshi))
     .baseUrl(BASE_URL)
     .build().create(CoinApiService::class.java) //  build public API Object exposing Retrofit service
   }
   return apiService!!
  }
 }
}