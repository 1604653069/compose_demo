package com.hong.compose.test.components.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hong.compose.test.ui.theme.AppTheme
import com.hong.compose.test.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeSelector(
    viewModel: ThemeViewModel,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showThemeGrid by remember { mutableStateOf(false) }

    if (showThemeGrid) {
        ThemeGridSelector(
            viewModel = viewModel,
            onDismiss = { showThemeGrid = false }
        )
    } else {
        ThemeBottomSheet(
            viewModel = viewModel,
            onThemeGridClick = { showThemeGrid = true },
            onDismiss = onDismiss,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ThemeBottomSheet(
    viewModel: ThemeViewModel,
    onThemeGridClick: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 标题
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "主题设置",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "关闭")
                }
            }

            // 当前主题信息
            CurrentThemeInfo(viewModel = viewModel)

            // 深色模式切换
            DarkModeToggle(viewModel = viewModel)

            // 动态颜色切换（仅Android 12+）
            if (viewModel.supportsDynamicColor()) {
                DynamicColorToggle(viewModel = viewModel)
            }

            // 主题选择按钮
            ThemeSelectionButton(onClick = onThemeGridClick)
        }
    }
}

@Composable
private fun CurrentThemeInfo(viewModel: ThemeViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = getThemeIcon(viewModel.currentThemeType),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = getThemeName(viewModel.currentThemeType),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = getThemeDescription(viewModel.currentThemeType),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }
            Text(
                text = if (viewModel.isDarkMode) "🌙" else "☀️",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
private fun DarkModeToggle(viewModel: ThemeViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (viewModel.isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                contentDescription = null
            )
            Column {
                Text(
                    text = "深色模式",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = if (viewModel.isDarkMode) "当前为深色主题" else "当前为浅色主题",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Switch(
            checked = viewModel.isDarkMode,
            onCheckedChange = { viewModel.toggleDarkMode() }
        )
    }
}

@Composable
private fun DynamicColorToggle(viewModel: ThemeViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Palette,
                contentDescription = null
            )
            Column {
                Text(
                    text = "动态颜色",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "使用系统壁纸颜色",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Switch(
            checked = viewModel.isDynamicColor,
            onCheckedChange = { viewModel.toggleDynamicColor() }
        )
    }
}

@Composable
private fun ThemeSelectionButton(onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Style, contentDescription = null)
                Text(
                    text = "选择主题",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
            Icon(Icons.Default.ArrowForward, contentDescription = "前往选择")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ThemeGridSelector(
    viewModel: ThemeViewModel,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // 标题
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "选择主题",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "关闭")
                }
            }

            // 主题网格
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(viewModel.getAvailableThemes()) { theme ->
                    ThemeOptionCard(
                        theme = theme,
                        isSelected = theme == viewModel.currentThemeType,
                        onSelected = {
                            viewModel.changeThemeType(theme)
                            onDismiss()
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ThemeOptionCard(
    theme: AppTheme,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Card(
        onClick = onSelected,
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSelected,
                onClick = onSelected,
                role = Role.RadioButton
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 4.dp else 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 主题图标
            Icon(
                imageVector = getThemeIcon(theme),
                contentDescription = null,
                tint = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                modifier = Modifier.size(32.dp)
            )

            // 主题名称
            Text(
                text = getThemeName(theme),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.onPrimaryContainer
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )

            // 主题描述
            Text(
                text = getThemeDescription(theme),
                style = MaterialTheme.typography.bodySmall,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                maxLines = 2
            )

            // 选中指示器
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "已选中",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

// 辅助函数：获取主题图标
@Composable
private fun getThemeIcon(theme: AppTheme): ImageVector {
    return when (theme) {
        AppTheme.IOS -> Icons.Default.Settings // 使用Settings代替Apple
        AppTheme.MODERN -> Icons.Default.AutoAwesome
        AppTheme.NATURE -> Icons.Default.Favorite // 使用Favorite代替Eco
        AppTheme.SUNSET -> Icons.Default.WbSunny
        AppTheme.MATERIAL -> Icons.Default.Palette // 使用Palette代替Style
    }
}

// 辅助函数：获取主题名称
@Composable
private fun getThemeName(theme: AppTheme): String {
    return when (theme) {
        AppTheme.IOS -> "iOS 风格"
        AppTheme.MODERN -> "现代渐变"
        AppTheme.NATURE -> "清新自然"
        AppTheme.SUNSET -> "温暖日落"
        AppTheme.MATERIAL -> "Material 默认"
    }
}

// 辅助函数：获取主题描述
@Composable
private fun getThemeDescription(theme: AppTheme): String {
    return when (theme) {
        AppTheme.IOS -> "优雅简洁，苹果设计语言"
        AppTheme.MODERN -> "紫色系，现代科技感"
        AppTheme.NATURE -> "绿色系，自然清新"
        AppTheme.SUNSET -> "暖色系，温馨舒适"
        AppTheme.MATERIAL -> "紫色系，Material Design"
    }
}