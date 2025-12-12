package com.hong.compose.test.components.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.hong.compose.test.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeShowcase() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "🎨 主题颜色展示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // iOS主题展示
        ThemeCard("iOS 风格主题", "优雅简洁，苹果设计语言") {
            IOSThemePreview()
        }

        // 现代主题展示
        ThemeCard("现代渐变主题", "紫色系，现代科技感") {
            ModernThemePreview()
        }

        // 自然主题展示
        ThemeCard("清新自然主题", "绿色系，自然清新") {
            NatureThemePreview()
        }

        // 日落主题展示
        ThemeCard("温暖日落主题", "暖色系，温馨舒适") {
            SunsetThemePreview()
        }
    }
}

@Composable
private fun ThemeCard(
    title: String,
    description: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Divider()

            content()
        }
    }
}

@Composable
private fun IOSThemePreview() {
    IOSTheme {
        ThemePreviewComponents()
    }
}

@Composable
private fun ModernThemePreview() {
    ModernTheme {
        ThemePreviewComponents()
    }
}

@Composable
private fun NatureThemePreview() {
    NatureTheme {
        ThemePreviewComponents()
    }
}

@Composable
private fun SunsetThemePreview() {
    SunsetTheme {
        ThemePreviewComponents()
    }
}

@Composable
private fun ThemePreviewComponents() {
    var isToggled by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 颜色展示
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ColorBox(
                color = MaterialTheme.colorScheme.primary,
                label = "Primary"
            )
            ColorBox(
                color = MaterialTheme.colorScheme.secondary,
                label = "Secondary"
            )
            ColorBox(
                color = MaterialTheme.colorScheme.tertiary,
                label = "Tertiary"
            )
        }

        // 容器颜色展示
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ColorBox(
                color = MaterialTheme.colorScheme.primaryContainer,
                label = "Primary容器"
            )
            ColorBox(
                color = MaterialTheme.colorScheme.secondaryContainer,
                label = "Secondary容器"
            )
        }

        // 组件展示
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) {
                Text("主要按钮")
            }

            OutlinedButton(onClick = { }) {
                Text("轮廓按钮")
            }

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "喜欢",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }

        // 状态组件
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = isToggled,
                onCheckedChange = { isToggled = it }
            )

            FilterChip(
                onClick = { },
                label = { Text("标签") },
                selected = true
            )

            Card {
                Text(
                    text = "卡片",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
private fun ColorBox(color: Color, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = color,
                shape = MaterialTheme.shapes.small
            ) {}
        }

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// 预览函数
@Preview(showBackground = true, name = "主题展示")
@Composable
fun ThemeShowcasePreview() {
    Compose_testTheme {
        ThemeShowcase()
    }
}

@Preview(showBackground = true, name = "iOS主题")
@Composable
fun IOSThemePreviewFunc() {
    IOSThemePreview()
}

@Preview(showBackground = true, name = "现代主题")
@Composable
fun ModernThemePreviewFunc() {
    ModernThemePreview()
}

@Preview(showBackground = true, name = "自然主题")
@Composable
fun NatureThemePreviewFunc() {
    NatureThemePreview()
}

@Preview(showBackground = true, name = "日落主题")
@Composable
fun SunsetThemePreviewFunc() {
    SunsetThemePreview()
}