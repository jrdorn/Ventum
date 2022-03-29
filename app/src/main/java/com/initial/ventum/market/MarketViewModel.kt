package com.initial.ventum.market

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.initial.ventum.network.CoinApi
import com.initial.ventum.network.CoinData
import kotlinx.coroutines.launch

// status of the CoinGecko API call
enum class CoinApiStatus { LOADING, ERROR, DONE }

// VieModel attached to MarketFragment
class OverviewViewModel : ViewModel() {

    // Store last request status
    private val _status = MutableLiveData<CoinApiStatus>()

    // External immutable data for request status
    val status: LiveData<CoinApiStatus> = _status

    // Internal mutable data for updating CoinData class with new values
    private val _data = MutableLiveData<List<CoinData>>()

    // External immutable data for coin value
    val data: LiveData<List<CoinData>> = _data

    // Display results of API call on app load
    init {
        getCoinData()
    }


    // Get Coin data from Retrofit and update CoinData, List, and LiveData
    private fun getCoinData() {

        viewModelScope.launch {
            _status.value = CoinApiStatus.LOADING
            try {
                _data.value = CoinApi.retrofitService.getData()
                _status.value = CoinApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CoinApiStatus.ERROR
                _data.value = listOf()
            }
        }
    }
}
