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
import com.hyundai.sample.entity.NavConstants.CAR
import com.hyundai.sample.entity.NavConstants.CLOUD
import com.hyundai.sample.entity.NavConstants.CLOUD_DETAIL
import com.hyundai.sample.entity.NavConstants.MAIN

@Composable
fun LeftSideNavigation(
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
        TabItem(
            label = "Home",
            icon = R.drawable.ic_home,
            selected = navBackStackEntry?.destination?.route == MAIN,
            onClick = { navController.navigate(MAIN) }
        )

        TabItem(
            label = "Car",
            icon = R.drawable.ic_car,
            selected = navBackStackEntry?.destination?.route == CAR,
            onClick = { navController.navigate(CAR) }
        )

        TabItem(
            label = "Cloud",
            icon = R.drawable.ic_cloud,
            selected = navBackStackEntry?.destination?.route == CLOUD
                    || navBackStackEntry?.destination?.route == CLOUD_DETAIL,
            onClick = { navController.navigate(CLOUD) }
        )
    }
}