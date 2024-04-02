package com.example.composecleanarchitecture.presentation.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecleanarchitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCleanAcrhitectureTheme {
        DetailScreen(name = "Android")
    }
}