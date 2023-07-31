package com.example.navigationcomponent_jetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


/**
 * Handles all navigation's like navGraph
 *
 * */
@Composable
fun SampleNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) { // in this scope we define all our destinations
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                navigateToDetail = { id, name ->
                    navController.navigateSingleTopTo(Screen.Detail.args(id, name))
                }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = detailArguments
        ) {
            val argsBundle = it.arguments
            val id = argsBundle?.getInt(ArgumentId.DetailId) ?: 0
            val name = argsBundle?.getString(ArgumentId.Name) ?: ""
            DetailScreen(id, name,
                backToHome = {
                    navController.popBackStack()
                }
            )
        }
    }
}


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
