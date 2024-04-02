package com.example.composecleanacrhitecture.presentation.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecleanacrhitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme

@Composable
fun Detail(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCleanAcrhitectureTheme {
        Detail("Android")
    }
}