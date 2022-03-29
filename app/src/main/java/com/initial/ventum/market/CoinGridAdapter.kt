package com.initial.ventum.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.initial.ventum.databinding.GridViewItemBinding
import com.initial.ventum.network.CoinData


// Use data binding to display list data
class CoinGridAdapter :
    ListAdapter<CoinData, CoinGridAdapter.CoinDataViewHolder>(DiffCallback) {

    // CoinDataViewHolder takes binding variable from a GridViewItem to access CoinData
    class MarsPhotosViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coinData: CoinData) {
            binding.data = coinData
            // force data binding to immediately execute so RecyclerView can make correct view size measurements
            binding.executePendingBindings()
        }
    }

    // determined what items change when CoinData is updates
    companion object DiffCallback : DiffUtil.ItemCallback<CoinData>() {
        override fun areItemsTheSame(oldItem: CoinData, newItem: CoinData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CoinData, newItem: CoinData): Boolean {
            return oldItem.currentPrice == newItem.currentPrice
        }
    }

    // create new views
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinDataViewHolder {
        return CoinDataViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    // replace view content
    override fun onBindViewHolder(holder: CoinDataViewHolder, position: Int) {
        val coinData = getItem(position)
        holder.bind(coinData)
    }
}
