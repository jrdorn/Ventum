package com.initial.ventum.network
import com.squareup.moshi.Json

// Data class used by Moshi to extract matching JSON properties
data class CoinData(
    // map the "name" value from returned JSON to "name" in the class
    @Json(name = "id") val id: String,
    //  map the "current_price" value from returned JSON to "currentPrice" in the class
    @Json(name = "current_price") val currentPrice: Int
)