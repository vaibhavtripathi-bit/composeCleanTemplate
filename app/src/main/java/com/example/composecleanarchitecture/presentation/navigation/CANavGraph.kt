package com.example.composecleanarchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecleanarchitecture.presentation.screens.detail.DetailScreen
import com.example.composecleanarchitecture.presentation.screens.AppScreen
import com.example.composecleanarchitecture.presentation.screens.home.HomeScreen
import com.example.composecleanarchitecture.presentation.theme.LocalNavigationProvider
import org.koin.java.KoinJavaComponent

@Composable
fun CANavGraph() {
    val navController = rememberNavController()
    val navigationHelper: CANavigation by lazy { KoinJavaComponent.getKoin().get() }
    navigationHelper.setNavController(navController)
    CompositionLocalProvider(LocalNavigationProvider provides navigationHelper) {
        // Create NavHost
        NavHost(navController, startDestination = Screen.ScreenRoot.route) {
            // Create composable for each screen
            composable(Screen.ScreenRoot.route) {
                AppScreen()
            }
        }
    }
}

@Composable
fun CANavGraph2() {
    // Create NavController
    val navController = rememberNavController()
    val navigationHelper: CANavigation by lazy { KoinJavaComponent.getKoin().get() }
    navigationHelper.setNavController(navController)
    CompositionLocalProvider(LocalNavigationProvider provides navigationHelper) {
        // Create NavHost
        NavHost(navController, startDestination = Screen.ScreenHome.route) {
            // Create composable for each screen
            composable(Screen.ScreenHome.route) {
                HomeScreen()
            }
            composable(Screen.ScreenDetail.route) {
                DetailScreen()
            }
        }
    }
}
