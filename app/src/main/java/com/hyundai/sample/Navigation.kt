import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(400.dp)
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        NavItem(
            label = "Main",
            selected = navBackStackEntry?.destination?.route == "main",
            onClick = { navController.navigate("main") }
        )

        NavItem(
            label = "Vehicle",
            selected = navBackStackEntry?.destination?.route == "vehicle",
            onClick = { navController.navigate("vehicle") }
        )

        NavItem(
            label = "Version",
            selected = navBackStackEntry?.destination?.route == "version"
                    || navBackStackEntry?.destination?.route == "details",
            onClick = { navController.navigate("version") }
        )
    }
}

@Composable
fun NavItem(label: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable(onClick = onClick)
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 40.sp,
            color = if (selected) Color.White else Color.Black,
        )
    }
}


