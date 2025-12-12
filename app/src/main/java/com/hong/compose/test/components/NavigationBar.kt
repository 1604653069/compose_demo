package com.hong.compose.test.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun NavigationBar(
    navController: NavController, modifier: Modifier = Modifier
) {

    val currentState by navController.currentBackStackEntryAsState()
    val currentRoute = currentState?.destination?.route

    NavigationBar(
        modifier = modifier, containerColor = Color.White, contentColor = Color.Gray
    ) {

        screens.forEach { screen ->
            NavigationBarItem(
                icon = {
                    itemIcon(screen.icon, currentRoute == screen.route)
                },
                label = {
                    Text(screen.route)
                },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                        }
                    }
                },
                modifier = modifier,
                colors = NavigationBarItemColors(
                    selectedTextColor = Color.Blue,
                    selectedIconColor = Color.Blue,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray,
                    selectedIndicatorColor = Color.Transparent,
                    disabledIconColor = Color.Gray,
                    disabledTextColor = Color.Gray,
                )
            )
        }
    }
}

@Composable
fun itemIcon(
    icon: ImageVector, selected: Boolean
) {
    Icon(icon, tint = if (selected) Color.Blue else Color.Gray, contentDescription = null)
}