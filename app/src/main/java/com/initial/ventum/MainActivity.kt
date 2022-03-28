package com.initial.ventum

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.initial.ventum.ui.theme.VentumTheme
import drewcarlson.coingecko.CoinGeckoClient

// App entry point
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}




// Navigate current price of Bitcoin, Eth, and Solana
//@Composable
//fun ButtonRow() {
//    CryptoNav {
//        BtcScreen()
//        EthScreen()
//        SolScreen()
//    }
//}



// Message object that takes an author and body text as params
data class Message(val author: String, val body: String)

// Print a message card
@Composable
fun MessageCard(msg: Message) {
    // horizontal image with padding
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.bitcoin_logo),
            contentDescription = "Bitcoin logo",
            modifier = Modifier
                .size(40.dp) // set image size to 40 dp
                .clip(CircleShape) //clip image to circle
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape) // add themed border
        )

        // add horizontal gap between image and text
        Spacer(modifier = Modifier.width(8.dp))

        // vertical author and message body
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp)) // add vertical space between author and body

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp), // add message padding
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

//// Preview composable functions
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun DefaultPreview() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}