package com.initial.ventum.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// CoinGecko API base URL
private const val BASE_URL =
    "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin"

// Build Moshi object with Kotlin adapter to handle JSON returned by Retrofit
private val moshi = Moshi.Builder()
 .add(KotlinJsonAdapterFactory())
 .build()

// Build Retrofit object using Moshi converter to perform REST API calls
private val retrofit = Retrofit.Builder()
 .addConverterFactory(MoshiConverterFactory.create(moshi))
 .baseUrl(BASE_URL)
 .build()

// expose getData method
// return List of CoinData
interface CoinApiService {

 // @GET: "data" endpoint will be requested with HTTP GEt
 @GET("data")
 suspend fun getData(): List<CoinData>
}

// Public API Object exposing Retrofit service
object CoinApi {
 val retrofitService: CoinApiService by lazy { retrofit.create(CoinApiService::class.java) }
}


/**
 MOSHI


val json: String = ...

val moshi: Moshi = Moshi.Builder().build()
val jsonAdapter: JsonAdapter<BlackjackHand> = moshi.adapter<BlackjackHand>()

val blackjackHand = jsonAdapter.fromJson(json)
println(blackjackHand)


 class BlackjackHand(
 val hidden_card: Card,
 val visible_cards: List<Card>,
 ...
 )

 class Card(
 val rank: Char,
 val suit: Suit
 ...
 )

 enum class Suit {
 CLUBS, DIAMONDS, HEARTS, SPADES;
 }

 class CardAdapter {
 @ToJson fun toJson(card: Card): String {
 return card.rank + card.suit.name.substring(0, 1)
 }

 @FromJson fun fromJson(card: String): Card {
 if (card.length != 2) throw JsonDataException("Unknown card: $card")

 val rank = card[0]
 return when (card[1]) {
 'C' -> Card(rank, Suit.CLUBS)
 'D' -> Card(rank, Suit.DIAMONDS)
 'H' -> Card(rank, Suit.HEARTS)
 'S' -> Card(rank, Suit.SPADES)
 else -> throw JsonDataException("unknown suit: $card")
 }
 }
 }


 val moshi = Moshi.Builder()
 .add(CardAdapter())
 .build()


  Parse JSON arrays
 val cardsJsonResponse: String = ...
 // We can just use a reified extension!
 val adapter = moshi.adapter<List<Card>>()
 val cards: List<Card> = adapter.fromJson(cardsJsonResponse)

 * */