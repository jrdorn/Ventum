package com.initial.ventum.market

import  com.initial.ventum.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.initial.ventum.network.CoinData

// Navigate current price of Bitcoin, Eth, and Solana
//@Composable
//fun ButtonRow() {
//    CryptoNav {
//        BtcScreen()
//        EthScreen()
//        SolScreen()
//    }
//}




// Print a card containing coin data
@Composable
fun MarketCard(crypto: CoinData) {
    // horizontal image with padding

    Row(modifier = Modifier.padding(all = 8.dp)) {

        // initialize drawable crypto logo and set to specific name
        var cryptoLogo = painterResource(R.drawable.bitcoin_logo)
        if (crypto.name == "Ethereum") cryptoLogo = painterResource(R.drawable.ethereum_logo)
        if (crypto.name == "Solana") cryptoLogo = painterResource(R.drawable.solana_logo)

        Image(
            painter = cryptoLogo,
            contentDescription = crypto.name + " logo",
            modifier = Modifier
                .size(40.dp) // set image size to 40 dp
                .clip(CircleShape) //clip image to circle
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape) // add themed border
        )

        // add horizontal gap between image and text
        Spacer(modifier = Modifier.width(8.dp))

        // vertical name and price body
        Column {
            Text(
                text = crypto.name,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp)) // add vertical space between author and body

            //
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(
                    text = "$" + crypto.currentPrice.toString(),
                    modifier = Modifier.padding(all = 4.dp), // add message padding
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

/***/
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
                NamePickerItem(coin, onCoinClicked)
            }
        }
    }
}
/***/