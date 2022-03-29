package com.initial.ventum.market

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.initial.ventum.network.CoinApiService
import com.initial.ventum.network.CoinData
import kotlinx.coroutines.launch


//
class MarketViewModel : ViewModel() {
    private val _coinDataList = mutableStateListOf<CoinData>()
    var errorMessage: String by mutableStateOf("")
    val coinDataList: List<CoinData>
        get() = _coinDataList

    fun getCoinDataList() {
        viewModelScope.launch {
            val apiService = CoinApiService.getInstance()
            try {
                _coinDataList.clear()
                _coinDataList.addAll(apiService.getData())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}