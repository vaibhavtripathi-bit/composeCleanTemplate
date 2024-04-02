package com.example.composecleanarchitecture.presentation.navigation

import android.os.Bundle
import androidx.navigation.NavController

class CANavigationImpl : CANavigation {
    private lateinit var navController: NavController
    override fun navigateTo(screen: Screen, data: Bundle?) {
        navController.navigate(screen.route)
    }

    override fun popBackStack() {
        navController.popBackStack()
    }

    override fun popToRoot() {
        navController.popBackStack(navController.graph.startDestinationId, false)
    }

    override fun navigateToWithClearStack(screen: Screen, data: Bundle?) {
        navController.popBackStack(navController.graph.startDestinationId, false)
        navController.navigate(screen.route)
    }

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }
}
