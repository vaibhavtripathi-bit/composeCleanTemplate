package com.example.composecleanarchitecture.presentation.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecleanarchitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme
import com.example.composecleanarchitecture.presentation.navigation.Screen
import com.example.composecleanarchitecture.presentation.theme.LocalNavigationProvider

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    val navigator = LocalNavigationProvider.current

    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
             navigator.navigateTo(Screen.ScreenDetail, null)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    ComposeCleanAcrhitectureTheme {
        SettingScreen(name = "Android")
    }
}