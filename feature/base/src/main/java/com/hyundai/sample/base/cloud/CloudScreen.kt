package com.hyundai.sample.base.cloud

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
import com.hyundai.sample.base.DefaultTopBar
import com.hyundai.sample.base.HSize
import com.hyundai.sample.entity.NavConstants.CLOUD_DETAIL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CloudScreen(navController: NavController, viewModel: CloudViewModel = hiltViewModel()) {
    val apiVersion by viewModel.apiVersion.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = HSize.ScreenStartPadding),
        topBar = { DefaultTopBar("Sample") }
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
                navController.navigate(CLOUD_DETAIL)
            }) {
                Text(
                    text = "Go to details",
                    fontSize = 40.sp,
                )
            }
        }
    }
}