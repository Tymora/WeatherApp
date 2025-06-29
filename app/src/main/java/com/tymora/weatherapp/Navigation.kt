package com.tymora.weatherapp



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tymora.weatherapp.ui.theme.PurpleGrey40
import kotlinx.coroutines.launch

@Composable
fun WeatherAppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onNavigate = { route ->
                    scope.launch {
                        drawerState.close()
                        navController.navigate(route)
                    }
                }
            )
        }
    ) {
        NavHost(navController = navController, startDestination = "weather") {
            composable("weather") { WeatherScreen(navController) }
            composable("settings") { SettingsScreen()  }
        }
    }
}

@Composable
fun DrawerContent(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(PurpleGrey40),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Меню", style = TextStyle(fontSize = 20.sp))
        NavigationDrawerItem(
            label = { Text("Погода", fontSize = 20.sp) },
            selected = false,
            onClick = { onNavigate("weather") }
        )
        NavigationDrawerItem(
            label = { Text("Настройки", fontSize = 20.sp) },
            selected = false,
            onClick = { onNavigate("settings") }
        )
    }
}