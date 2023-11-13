package com.hyundai.sample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val ignitionState by viewModel.ignitionState.collectAsState()
    val parkingBrakeState by viewModel.parkingBrakeState.collectAsState()
    val apiVersion by viewModel.apiVersion.collectAsState()
    val searchHistoryList by viewModel.searchHistoryList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = ignitionState ?: "",
            fontSize = 50.sp
        )
        Text(
            text = parkingBrakeState ?: "",
            fontSize = 50.sp
        )
        Text(
            text = apiVersion ?: "",
            fontSize = 50.sp
        )
    }

}
