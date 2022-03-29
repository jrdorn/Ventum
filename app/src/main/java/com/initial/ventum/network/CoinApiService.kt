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

val bitcoinJsonResponse: String = ...
//  use a reified extension!
val adapter = moshi.adapter<List<Bitcoin>>()
val cards: List<Bitcoin> = adapter.fromJson(bitcoinJsonResponse)

 * */

// expose getData method, return List of CoinData
interface CoinApiService {

 // @GET: request specific crypto endpoints with HTTP GET

 @GET("markets?vs_currency=usd&ids=bitcoin")
 suspend fun getBtc(): List<CoinData>

 @GET("markets?vs_currency=usd&ids=ethereum")
 suspend fun getEth(): List<CoinData>

 @GET("markets?vs_currency=usd&ids=solana")
 suspend fun getSol(): List<CoinData>

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