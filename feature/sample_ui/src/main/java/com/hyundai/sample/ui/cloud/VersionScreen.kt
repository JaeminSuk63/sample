package com.hyundai.sample.ui.cloud

import HSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hyundai.sample.ui.HTopBarDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VersionScreen(navController: NavController, viewModel: VersionViewModel = hiltViewModel()) {
    val apiVersion by viewModel.apiVersion.collectAsState()

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
                text = apiVersion ?: "",
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))

            TextButton(onClick = {
                navController.navigate("details")
            }) {
                Text(
                    text = "Go to details",
                    fontSize = 40.sp,
                )
            }
        }
    }
}