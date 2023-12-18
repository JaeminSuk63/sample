import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hyundai.sample.entity.NavConstants.CLOUD
import com.hyundai.sample.entity.NavConstants.CLOUD_DETAIL
import com.hyundai.sample.entity.NavConstants.MAIN
import com.hyundai.sample.entity.NavConstants.VEHICLE
import com.hyundai.sample.launch.LeftSideNavigation
import com.hyundai.sample.ui.cloud.CloudDetailsScreen
import com.hyundai.sample.ui.cloud.CloudScreen
import com.hyundai.sample.ui.main.MainScreen
import com.hyundai.sample.ui.vehicle.VehicleScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(navController = navController, startDestination = MAIN) {
        composable(MAIN) { MainScreen() }
        composable(VEHICLE) { VehicleScreen() }
        composable(CLOUD) { CloudScreen(navController) }
        composable(CLOUD_DETAIL) { CloudDetailsScreen(navController) }
    }

    LeftSideNavigation(navController = navController, navBackStackEntry = navBackStackEntry)
}



