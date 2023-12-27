package com.hyundai.sample.launch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hyundai.sample.base.car.CarScreen
import com.hyundai.sample.base.cloud.CloudDetailsScreen
import com.hyundai.sample.base.cloud.CloudScreen
import com.hyundai.sample.base.main.MainScreen
import com.hyundai.sample.entity.NavConstants.CAR
import com.hyundai.sample.entity.NavConstants.CLOUD
import com.hyundai.sample.entity.NavConstants.CLOUD_DETAIL
import com.hyundai.sample.entity.NavConstants.MAIN

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(navController = navController, startDestination = MAIN) {
        composable(MAIN) { MainScreen() }
        composable(CAR) { CarScreen() }
        composable(CLOUD) { CloudScreen(navController) }
        composable(CLOUD_DETAIL) { CloudDetailsScreen(navController) }
    }

    LeftSideNavigation(navController = navController, navBackStackEntry = navBackStackEntry)
}



