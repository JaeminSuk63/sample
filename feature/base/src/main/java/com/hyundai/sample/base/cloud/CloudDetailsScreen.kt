package com.hyundai.sample.base.cloud

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hyundai.sample.base.BackTopBar
import com.hyundai.sample.base.HSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CloudDetailsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = HSize.ScreenStartPadding),
        topBar = { BackTopBar("Sample", navController) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = HSize.D40)
        ) {
            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Details Screen",
                fontSize = 40.sp
            )
        }
    }
}
