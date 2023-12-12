package com.hyundai.sample.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun LeftNavigation(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry?
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(130.dp)
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        NavItem(
            label = "Home",
            icon = R.drawable.ic_home,
            selected = navBackStackEntry?.destination?.route == "main",
            onClick = { navController.navigate("main") }
        )

        NavItem(
            label = "Vehicle",
            icon = R.drawable.ic_car,
            selected = navBackStackEntry?.destination?.route == "vehicle",
            onClick = { navController.navigate("vehicle") }
        )

        NavItem(
            label = "Version",
            icon = R.drawable.ic_cloud,
            selected = navBackStackEntry?.destination?.route == "version"
                    || navBackStackEntry?.destination?.route == "details",
            onClick = { navController.navigate("version") }
        )
    }
}