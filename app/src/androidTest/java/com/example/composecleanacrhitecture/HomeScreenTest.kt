package com.example.composecleanacrhitecture

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.composecleanacrhitecture.presentation.screens.home.HomeScreen
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysGreeting_whenNameIsProvided() {
        val name = "Android"

        composeTestRule.setContent {
            HomeScreen(name)
        }

        composeTestRule.onNodeWithText("Hello $name!").assertExists()
    }

    @Test
    fun homeScreen_displaysGreeting_whenNameIsEmpty() {
        val name = ""

        composeTestRule.setContent {
            HomeScreen(name)
        }

        composeTestRule.onNodeWithText("Hello !").assertExists()
    }
}