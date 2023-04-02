package de.dannyb.composetodos.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import de.dannyb.composetodos.util.Constants.LIST_SCREEN
import de.dannyb.composetodos.util.Constants.LIST_SCREEN_ARGUMENT_KEY

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(LIST_SCREEN_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )
    ) {}
}