package com.example.composecleanacrhitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecleanacrhitecture.presentation.screens.detail.DetailScreen
import com.example.composecleanacrhitecture.presentation.screens.AppScreen

@Composable
fun CANavGraph() {
    // Create NavController
    val navController = rememberNavController()

    // Create NavHost
    NavHost(navController, startDestination = Screen.ScreenHome.route) {
        // Create composable for each screen
        composable(Screen.ScreenHome.route) {
            AppScreen()
        }
        composable(Screen.ScreenDetail.route) {
            DetailScreen()
        }
    }
}
