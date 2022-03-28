package com.initial.ventum
import drewcarlson.coingecko.CoinGeckoClient
import drewcarlson.coingecko.models.coins.CoinFullData


//CoinGecko API call
//val coinGecko = CoinGeckoClient.create()
//val geckoString = coinGecko.ping().geckoSays
//val bitcoin = coinGecko.getCoinById("bitcoin")





//CoinGecko API call

// store current price in USD of three major cryptocurrencies: BTC, ETH, SOL
//val geckoString = coinGecko.ping().geckoSays
//val bitcoin = coinGecko.getCoinById("bitcoin")


// initialize CoinGecko API client
val coinGecko = CoinGeckoClient.create()





//
interface CryptoRepository {
    fun getBtc():
    fun getEth(): Int
    fun getSol(): Int
}


