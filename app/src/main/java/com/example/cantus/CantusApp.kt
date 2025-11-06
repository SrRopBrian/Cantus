package com.example.cantus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cantus.ui.AppCapabilitiesScreen
import com.example.cantus.ui.LandingScreen

enum class CantusScreens() {
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
        startDestination = CantusScreens.Landing.name,
        modifier = modifier
    ) {
        composable(route = CantusScreens.Landing.name) {
            LandingScreen(
                onGetStartedButtonClicked = {
                    navController.navigate(CantusScreens.AppCapabilities.name)
                },
                modifier = Modifier
            )
        }
        composable(route = CantusScreens.AppCapabilities.name) {
            AppCapabilitiesScreen(
                onGetStartedButtonClicked = {
                    navController.popBackStack()
                },
                modifier = Modifier
            )
        }
    }
}