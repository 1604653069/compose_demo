package com.hong.compose.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hong.compose.test.app.MainApp
import com.hong.compose.test.ui.theme.*
import com.hong.compose.test.viewmodel.ThemeViewModel
import com.hong.compose.test.viewmodel.ThemeViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 创建ThemeViewModel实例
            val themeViewModel: ThemeViewModel = viewModel(
                factory = ThemeViewModelFactory(application)
            )

            // 监听主题状态变化
            val themeState by themeViewModel.themeState.collectAsState()

            Compose_testTheme(
                darkTheme = themeState.darkMode,
                dynamicColor = themeState.dynamicColor,
                themeType = themeState.themeType
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp(themeViewModel = themeViewModel)
                }
            }
        }
    }
}
