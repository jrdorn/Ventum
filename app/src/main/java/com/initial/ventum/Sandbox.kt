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
                CoinPickerItem(coin, onCoinClicked)
            }
        }
    }
}

//
data class Account (var balance: Int = 0)

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Author", "body text")
    )
}


