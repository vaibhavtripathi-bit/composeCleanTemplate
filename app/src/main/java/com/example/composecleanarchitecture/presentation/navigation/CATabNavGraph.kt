package com.example.composecleanarchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecleanarchitecture.presentation.screens.detail.DetailScreen
import com.example.composecleanarchitecture.presentation.screens.detail.SettingScreen
import com.example.composecleanarchitecture.presentation.screens.home.HomeScreen
import com.example.composecleanarchitecture.presentation.theme.LocalNavigationProvider
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent

@Composable
fun CATabNavGraph() {
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
            composable(Screen.ScreenHome.route) {
                HomeScreen()
            }
        }
    }
}

@Composable
fun CAHomeTabNavGraph() {
    // Create NavController
    val navController = rememberNavController()
    val navigationHelper: CANavigation by lazy { KoinJavaComponent.getKoin().get(named("HomeTab")) }
    navigationHelper.setNavController(navController)
    CompositionLocalProvider(LocalNavigationProvider provides navigationHelper) {
        // Create NavHost
        NavHost(navController, startDestination = Screen.ScreenHome.route) {
            // Create composable for each screen
            ScreenComposable()
        }
    }
}

@Composable
fun CADetailTabNavGraph() {
    // Create NavController
    val navController = rememberNavController()
    val navigationHelper: CANavigation by lazy { KoinJavaComponent.getKoin().get(named("DetailTab")) }
    navigationHelper.setNavController(navController)
    CompositionLocalProvider(LocalNavigationProvider provides navigationHelper) {
        // Create NavHost
        NavHost(navController, startDestination = Screen.ScreenHome.route) {
            ScreenComposable()
        }
    }
}

@Composable
fun CASettingTabNavGraph() {
    // Create NavController
    val navController = rememberNavController()
    val navigationHelper: CANavigation by lazy { KoinJavaComponent.getKoin().get(named("SettingTab")) }
    navigationHelper.setNavController(navController)
    CompositionLocalProvider(LocalNavigationProvider provides navigationHelper) {
        // Create NavHost
        NavHost(navController, startDestination = Screen.ScreenHome.route) {
            ScreenComposable()
        }
    }
}

private fun NavGraphBuilder.ScreenComposable() {
    composable(Screen.ScreenHome.route) {
        HomeScreen(name = "HomeTab")
    }
    composable(Screen.ScreenDetail.route) {
        DetailScreen()
    }
    composable(Screen.ScreenSetting.route) {
        SettingScreen()
    }
}
