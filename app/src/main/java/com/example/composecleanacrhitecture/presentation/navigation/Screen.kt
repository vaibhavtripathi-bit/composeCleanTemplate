package com.example.composecleanacrhitecture.presentation.navigation

sealed class Screen(val route: String) {
    data object ScreenHome : Screen(ScreenName.SCREEN_HOME)
    data object ScreenDetail : Screen(ScreenName.SCREEN_DETAIL)

    companion object {
        const val DATA_KEY = "data-key"
    }
}

object ScreenName {
    const val SCREEN_HOME = "home-screen"
    const val SCREEN_DETAIL = "home-screen"
}