package com.hyundai.sample.ui.vehicle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
fun VehicleScreen(viewModel: VehicleViewModel = hiltViewModel()) {
    val ignitionState by viewModel.ignitionState.collectAsState()
    val parkingBrakeState by viewModel.parkingBrakeState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 450.dp, top = 100.dp),
    ) {
        Text(
            text = ignitionState ?: "",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = parkingBrakeState ?: "",
            fontSize = 40.sp
        )
    }
}