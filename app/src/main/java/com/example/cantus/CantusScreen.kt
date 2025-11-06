package com.example.cantus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cantus.ui.AppCapabilitiesScreen
import com.example.cantus.ui.LandingScreen

enum class CantusScreen() {
    Landing,
    AppCapabilities
}

@Composable
fun CantusApp (
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = CantusScreen.Landing.name,
        modifier = modifier
    ) {
        composable(route = CantusScreen.Landing.name) {
            LandingScreen(
                onGetStartedButtonClicked = {
                    navController.navigate(CantusScreen.AppCapabilities.name)
                },
                modifier = Modifier
            )
        }
        composable(route = CantusScreen.AppCapabilities.name) {
            AppCapabilitiesScreen(
                onGetStartedButtonClicked = {
                    navController.popBackStack()
                },
                modifier = Modifier
            )
        }
    }
}