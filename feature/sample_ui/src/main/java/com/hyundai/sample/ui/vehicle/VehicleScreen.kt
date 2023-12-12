package com.hyundai.sample.ui.vehicle

import HSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hyundai.sample.ui.HTopBarDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleScreen(viewModel: VehicleViewModel = hiltViewModel()) {
    val ignitionState by viewModel.ignitionState.collectAsState()
    val parkingBrakeState by viewModel.parkingBrakeState.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = HSize.ScreenStartPadding),
        topBar = { HTopBarDefault() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = HSize.D40)
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
}