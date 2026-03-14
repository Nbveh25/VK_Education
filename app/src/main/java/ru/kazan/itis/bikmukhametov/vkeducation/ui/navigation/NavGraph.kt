package ru.kazan.itis.bikmukhametov.vkeducation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.appdetails.AppDetailsScreen
import ru.kazan.itis.bikmukhametov.vkeducation.ui.screen.applist.RuStoreScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.APP_LIST,
    ) {
        composable(Destinations.APP_LIST) {
            RuStoreScreen(
                onAppClick = {
                    navController.navigate(Destinations.APP_DETAILS)
                },
            )
        }
        composable(Destinations.APP_DETAILS) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() },
                onShareClick = {},
                onInstallClick = {},
                onReadMoreClick = {},
                onDeveloperClick = {},
            )
        }
    }
}
