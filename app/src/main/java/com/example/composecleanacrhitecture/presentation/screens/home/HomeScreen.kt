package com.example.composecleanacrhitecture.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecleanacrhitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCleanAcrhitectureTheme {
        HomeScreen(name = "Android")
    }
}