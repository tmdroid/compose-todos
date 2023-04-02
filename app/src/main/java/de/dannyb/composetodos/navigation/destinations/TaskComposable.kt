package de.dannyb.composetodos.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import de.dannyb.composetodos.util.Action
import de.dannyb.composetodos.util.Constants.TASK_SCREEN
import de.dannyb.composetodos.util.Constants.TASK_SCREEN_ARGUMENT_KEY

fun NavGraphBuilder.taskComposable(
    navigateToTaskScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_SCREEN_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) {}
}