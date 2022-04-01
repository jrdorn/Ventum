package com.initial.ventum

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


//
@Composable
fun CoinPicker(
    header: String,
    names: List<String>,
    onNameClicked: (String) -> Unit
) {
    Column {
        Text(header, style = MaterialTheme.typography.h5)
        Divider()

        LazyColumn {
            items(coins) { coin ->
                CoinePickerItem(coin, onCoinClicked)
            }
        }
    }
}

//


