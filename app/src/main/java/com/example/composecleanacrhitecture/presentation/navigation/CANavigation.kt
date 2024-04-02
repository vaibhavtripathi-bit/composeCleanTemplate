package com.example.composecleanacrhitecture.presentation.navigation

import android.os.Bundle
import androidx.navigation.NavController

interface CANavigation {
    fun navigateTo(screen: Screen, data: Bundle? = null)
    fun popBackStack()
    fun popToRoot()
    fun navigateToWithClearStack(screen: Screen, data: Bundle? = null)
}