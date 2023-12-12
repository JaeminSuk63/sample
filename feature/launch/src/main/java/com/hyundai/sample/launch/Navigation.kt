import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hyundai.sample.launch.LeftNavigation
import com.hyundai.sample.ui.DetailsScreen
import com.hyundai.sample.ui.MainScreen
import com.hyundai.sample.ui.VehicleScreen
import com.hyundai.sample.ui.VersionScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen() }
        composable("vehicle") { VehicleScreen() }
        composable("version") { VersionScreen(navController) }
        composable("details") { DetailsScreen(navController) }
    }

    LeftNavigation(navController = navController, navBackStackEntry = navBackStackEntry)
}



