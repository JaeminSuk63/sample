import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LeftSideTabBarNavigation() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(200.dp) // Adjust the width as needed
            .background(MaterialTheme.colorScheme.primary)
    ) {
        // Create a composable for each tab
        TabItem(
            label = "Home",
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") }
        )

        TabItem(
            label = "Profile",
            selected = navController.currentDestination?.route == "profile",
            onClick = { navController.navigate("profile") }
        )

        TabItem(
            label = "Settings",
            selected = navController.currentDestination?.route == "settings",
            onClick = { navController.navigate("settings") }
        )
    }

    // Content for each tab using NavHost
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}

@Composable
fun TabItem(label: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label)
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(200.dp)) {

        Text(text = "WWWW")
    }
}

@Composable
fun ProfileScreen() {
    Text(text = "333333")
}

@Composable
fun SettingsScreen() {
    Text(text = "44444")
}

@Preview
@Composable
fun LeftSideTabBarNavigationPreview() {
    LeftSideTabBarNavigation()
}
