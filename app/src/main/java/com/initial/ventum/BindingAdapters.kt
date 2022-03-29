
package com.initial.ventum


import android.view.View
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.initial.ventum.network.CoinData
import com.initial.ventum.market.CoinApiStatus
import com.initial.ventum.market.CoinGridAdapter

// Update data in Recycler View
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CoinData>?) {
    val adapter = recyclerView.adapter as CoinGridAdapter
    adapter.submitList(data)
}


// Display CoinAPIStatus loading, error
@BindingAdapter("coinApiStatus")
fun bindStatus(statusDataView: DataView, status: CoinApiStatus?) {
    when (status) {
        CoinApiStatus.LOADING -> {
            statusDataView.visibility = View.VISIBLE
            statusDataView.setImageResource(R.drawable.loading_animation)
        }
        CoinApiStatus.ERROR -> {
            statusDataView.visibility = View.VISIBLE
            statusDataView.setImageResource(R.drawable.ic_connection_error)
        }
        CoinApiStatus.DONE -> {
            statusDataView.visibility = View.GONE
        }
    }
}
