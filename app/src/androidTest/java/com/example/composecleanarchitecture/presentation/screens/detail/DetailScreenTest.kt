package com.example.composecleanarchitecture.presentation.screens.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun detailScreen_displaysGreeting_whenNameIsProvided() {
        val name = "Android"

        composeTestRule.setContent {
            DetailScreen(name = name)
        }

        composeTestRule.onNodeWithText("Hello $name!").assertExists()
    }

    @Test
    fun detailScreen_displaysGreeting_whenNameIsEmpty() {
        val name = ""

        composeTestRule.setContent {
            DetailScreen(name = name)
        }

        composeTestRule.onNodeWithText("Hello !").assertExists()
    }
}