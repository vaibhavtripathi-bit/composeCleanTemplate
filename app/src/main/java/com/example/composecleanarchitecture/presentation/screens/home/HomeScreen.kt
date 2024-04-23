package com.example.composecleanarchitecture.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecleanarchitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme
import com.example.composecleanarchitecture.presentation.navigation.Screen
import com.example.composecleanarchitecture.presentation.theme.LocalNavigationProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    name: String = "NO_NAME"
) {
    val items = buildList {
        repeat(100) { index ->
            add("Item $name $index")
        }
    }
    val navigator = LocalNavigationProvider.current

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .selectableGroup()
        .clickable {
            navigator.navigateTo(Screen.ScreenDetail, null)
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
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