package com.example.composecleanarchitecture.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import com.example.composecleanarchitecture.presentation.navigation.CANavigation

val LocalNavigationProvider = staticCompositionLocalOf<CANavigation> {
    error("Nav controller not available.")
}
val LocalAppNavControllerProvider = staticCompositionLocalOf<NavController> {
    error("Nav controller not available.")
}
