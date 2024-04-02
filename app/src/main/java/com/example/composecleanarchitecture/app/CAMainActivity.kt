package com.example.composecleanarchitecture.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composecleanarchitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme
import com.example.composecleanarchitecture.presentation.screens.AppScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class CAMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCleanAcrhitectureTheme {
                AppScreen()
            }
        }
    }
}

