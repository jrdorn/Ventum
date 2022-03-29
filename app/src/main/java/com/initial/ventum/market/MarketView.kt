package com.initial.ventum.market

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier


// display coin market view
@Composable
fun MarketView(vm: MarketViewModel) {

    //
    LaunchedEffect(Unit, block = {
        vm.getCoinDataList()
    })

    //
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("Crypto Market")
                    }
                })
        },
        //
        content = {
            if (vm.errorMessage.isEmpty()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        //
                        items(vm.coinDataList) { coin ->
                            MarketCard( coin )

                        }
                    }
                }
            } else {
                //
                Text(vm.errorMessage)
            }
        }
    )
}

