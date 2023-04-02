package de.dannyb.composetodos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import de.dannyb.composetodos.navigation.destinations.listComposable
import de.dannyb.composetodos.navigation.destinations.taskComposable
import de.dannyb.composetodos.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable {
            screen.task
        }

        taskComposable {
            screen.list
        }
    }
}