package com.initial.ventum.network
import com.squareup.moshi.Json

// Data class used by Moshi to extract matching JSON properties
data class CoinData(
    // name of the cryptocurrency
    val id: String,
    //  map the "current_price" value from returned JSON to "currentPrice" in the class
    @Json(name = "current_price") val currentPrice: Int
)