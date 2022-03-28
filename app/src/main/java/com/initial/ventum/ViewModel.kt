package com.initial.ventum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.initial.ventum.network.CoinApi
import kotlinx.coroutines.launch

/**
[ViewModel] attached to  [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getPrices() on init so we can display status immediately
     */
    init {
        getPrices()
    }

    /**
     * Gets Crypto prices information from the CoinGecko API Retrofit service and updates the
     * [CryptoPrices] [List] [LiveData].
     */
    private fun getPrices() {
        viewModelScope.launch{
            try {
                val listResult = CoinApi.retrofitService.getPrices()
                _status.value = listResult
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}
