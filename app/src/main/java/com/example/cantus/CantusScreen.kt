package com.example.cantus

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cantus.ui.AppCapabilitiesScreen
import com.example.cantus.ui.LandingScreen
import java.util.function.IntConsumer

enum class CantusScreen(val title: Int) {
    Landing(R.string.landing_screen),
    AppCapabilities(R.string.app_capabilities),
    SongDetails(R.string.song_details)
}

@Composable
fun CantusTopAppBar(
    currentScreen: CantusScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    /* TopAppBar(
        title = { Text(stringResource(currentScreen.title))},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.,
                        contentDescription = stringResource() { }
                }
            }
        }
    ) */
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