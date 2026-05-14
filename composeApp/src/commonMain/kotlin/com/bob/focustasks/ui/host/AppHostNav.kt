package com.bob.focustasks.ui.host

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bob.focustasks.ui.screens.AddTaskScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main
    ) {
        composable<Screen.Main> {
            MainTasksScreen(
                onNavigateToAdd = { navController.navigate(Screen.AddTask) }
            )
        }
        composable<Screen.AddTask> {
            AddTaskScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}