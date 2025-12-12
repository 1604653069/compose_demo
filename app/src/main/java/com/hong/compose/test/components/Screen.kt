package com.hong.compose.test.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val icon: ImageVector
) {

    object HomeScreen : Screen("home", Icons.Default.Home)
    object SearchScreen : Screen("search", Icons.Default.Search)
    object MessageScreen : Screen("message", Icons.Default.Message)
    object MineScreen : Screen("mine", Icons.Default.Person)
}

val screens = listOf(
    Screen.HomeScreen,
    Screen.SearchScreen,
    Screen.MessageScreen,
    Screen.MineScreen,
)