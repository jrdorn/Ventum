package com.initial.ventum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.initial.ventum.market.MarketView
import com.initial.ventum.market.MarketViewModel
import com.initial.ventum.ui.theme.VentumTheme

// App entry point: sets initial view to activity_main, which contains a fragment to display the results of an API call
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //
        val vm = MarketViewModel()
        //
        super.onCreate(savedInstanceState)
        setContent {
            VentumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //
                    MarketView(vm)
                    //
                }
            }
        }
    }
}