package de.dannyb.composetodos.navigation

import androidx.navigation.NavHostController
import de.dannyb.composetodos.util.Action
import de.dannyb.composetodos.util.Constants.LIST_SCREEN

class Screens(
    private val navController: NavHostController
) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}