package com.example.composecleanarchitecture.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecleanarchitecture.presentation.base.theme.ComposeCleanAcrhitectureTheme
import com.example.composecleanarchitecture.presentation.screens.bottombar.items
import com.example.composecleanarchitecture.presentation.screens.home.HomeScreen
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.ui.platform.LocalConfiguration
import com.example.composecleanarchitecture.presentation.navigation.CADetailTabNavGraph
import com.example.composecleanarchitecture.presentation.navigation.CAHomeTabNavGraph
import com.example.composecleanarchitecture.presentation.navigation.CASettingTabNavGraph
import com.example.composecleanarchitecture.presentation.navigation.CATabNavGraph

val LocalSelectedItemIndex = staticCompositionLocalOf<Int> {
    error("Analytics manager not available.")
}

@Composable
fun AppScreen() {
    var selectedItemIndex: Int by rememberSaveable { mutableIntStateOf(0) }
    CompositionLocalProvider(LocalSelectedItemIndex provides selectedItemIndex) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    // navController.navigate(item.title)
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                alwaysShowLabel = false,
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (item.badgeCount != null) {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            } else if (item.hasNews) {
                                                Badge()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            ) {
                val listState = rememberLazyListState()
                val configuration = LocalConfiguration.current
                val screenWidth = configuration.screenWidthDp

                val items = listOf("Home Screen", "Second Screen", "Third Screen")
                LazyRow(state = listState) {
                    item {
                        Box(
                            modifier = Modifier
                                .width(screenWidth.dp)
                                .border(1.dp, MaterialTheme.colorScheme.primary)
                                .padding(it),
                            contentAlignment = Alignment.Center
                        ) {
                            CAHomeTabNavGraph()
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .width(screenWidth.dp)
                                .border(1.dp, MaterialTheme.colorScheme.primary)
                                .padding(it),
                            contentAlignment = Alignment.Center
                        ) {
                            CADetailTabNavGraph()
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .width(screenWidth.dp)
                                .border(1.dp, MaterialTheme.colorScheme.primary)
                                .padding(it),
                            contentAlignment = Alignment.Center
                        ) {
                            CASettingTabNavGraph()
                        }
                    }
                }
                // Use this to scroll to a specific index
                LaunchedEffect(selectedItemIndex) {
                    listState.animateScrollToItem(index = selectedItemIndex)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    ComposeCleanAcrhitectureTheme {
        AppScreen()
    }
}