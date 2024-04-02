package com.example.composecleanacrhitecture.presentation.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecleanacrhitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme

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