package com.hong.compose.test.components.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.hong.compose.test.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeToggleButton(
    viewModel: ThemeViewModel,
    modifier: Modifier = Modifier
) {
    var showThemeSelector by remember { mutableStateOf(false) }

    FloatingActionButton(
        onClick = { showThemeSelector = true },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Palette,
            contentDescription = "切换主题"
        )
    }

    if (showThemeSelector) {
        ThemeSelector(
            viewModel = viewModel,
            onDismiss = { showThemeSelector = false }
        )
    }
}

@Composable
fun ThemeIconButton(
    viewModel: ThemeViewModel,
    modifier: Modifier = Modifier
) {
    var showThemeSelector by remember { mutableStateOf(false) }

    IconButton(
        onClick = { showThemeSelector = true },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Palette,
            contentDescription = "切换主题"
        )
    }

    if (showThemeSelector) {
        ThemeSelector(
            viewModel = viewModel,
            onDismiss = { showThemeSelector = false }
        )
    }
}