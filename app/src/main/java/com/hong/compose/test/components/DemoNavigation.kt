package com.hong.compose.test.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hong.compose.test.components.basic.*
import com.hong.compose.test.components.layout.*

@Composable
fun Material3DemoNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "material3_demo"
    ) {
        // 主演示页面
        composable("material3_demo") {
            Material3DemoScreen(navController)
        }

        // 基础显示组件
        composable("basic_display/text") {
            TextDemo()
        }

        composable("basic_display/button") {
            ButtonDemo()
        }

        composable("basic_display/textfield") {
            TextFieldDemo()
        }

        composable("basic_display/fab") {
            FloatingActionButtonDemo()
        }

        // 布局和容器组件
        composable("layout/card") {
            CardDemo()
        }

        composable("layout/surface") {
            SurfaceDemo()
        }

        composable("layout/scaffold") {
            ScaffoldDemo()
        }
    }
}