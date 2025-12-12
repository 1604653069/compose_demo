package com.hong.compose.test.components.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.rememberModalBottomSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogDemo() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showConfirmationDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var dialogResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "AlertDialog 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础对话框按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { showBasicDialog = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("基础对话框", style = MaterialTheme.typography.labelSmall)
            }

            Button(
                onClick = { showConfirmationDialog = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("确认对话框",style = MaterialTheme.typography.labelSmall)
            }

            Button(
                onClick = { showCustomDialog = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("自定义对话框",style = MaterialTheme.typography.labelSmall)
            }
        }

        // 显示结果
        if (dialogResult != null) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "对话框结果: $dialogResult",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        // 不同样式的对话框示例
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "对话框样式预览",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val dialogTypes = listOf(
                    "信息提示" to MaterialTheme.colorScheme.primary,
                    "警告提示" to MaterialTheme.colorScheme.secondary,
                    "错误提示" to MaterialTheme.colorScheme.error,
                    "成功提示" to MaterialTheme.colorScheme.tertiary
                )

                dialogTypes.forEach { (type, color) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            modifier = Modifier.size(40.dp),
                            shape = CircleShape,
                            color = color.copy(alpha = 0.1f)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = color,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "$type - 显示详细信息和操作选项",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }

    // 基础对话框
    if (showBasicDialog) {
        AlertDialog(
            onDismissRequest = {
                showBasicDialog = false
                dialogResult = "对话框已关闭"
            },
            title = {
                Text("基础对话框")
            },
            text = {
                Text("这是一个基础的Material 3对话框示例。对话框用于向用户显示重要信息或要求用户做出决定。")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showBasicDialog = false
                        dialogResult = "用户点击了确定"
                    }
                ) {
                    Text("确定")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showBasicDialog = false
                        dialogResult = "用户点击了取消"
                    }
                ) {
                    Text("取消")
                }
            }
        )
    }

    // 确认对话框
    if (showConfirmationDialog) {
        AlertDialog(
            onDismissRequest = {
                showConfirmationDialog = false
                dialogResult = "确认对话框已关闭"
            },
            icon = {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Start
               ) {
                   Icon(
                       imageVector = Icons.Default.Warning,
                       contentDescription = "警告",
                       tint = MaterialTheme.colorScheme.error
                   )
               }
            },
            title = {
                Text("删除确认")
            },
            text = {
                Text("您确定要删除这个项目吗？此操作无法撤销。删除后，所有相关数据将被永久丢失。")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showConfirmationDialog = false
                        dialogResult = "用户确认删除操作"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("删除")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showConfirmationDialog = false
                        dialogResult = "用户取消删除操作"
                    }
                ) {
                    Text("取消")
                }
            }
        )
    }

    // 自定义对话框
    if (showCustomDialog) {
        var selectedOption by remember { mutableStateOf(0) }
        val options = listOf("选项 1", "选项 2", "选项 3")

        AlertDialog(
            onDismissRequest = {
                showCustomDialog = false
                dialogResult = "自定义对话框已关闭"
            },
            title = {
                Text("自定义对话框")
            },
            text = {
                Column {
                    Text("请选择一个选项：")
                    Spacer(modifier = Modifier.height(16.dp))
                    options.forEachIndexed { index, option ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedOption = index }
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedOption == index,
                                onClick = { selectedOption = index }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(option)
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showCustomDialog = false
                        dialogResult = "用户选择了: ${options[selectedOption]}"
                    }
                ) {
                    Text("确认选择")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showCustomDialog = false
                        dialogResult = "用户取消了选择"
                    }
                ) {
                    Text("取消")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDemo() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var dialogResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dialog 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础对话框按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { showBasicDialog = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("基础Dialog")
            }

            Button(
                onClick = { showCustomDialog = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("自定义Dialog")
            }
        }

        // 显示结果
        if (dialogResult != null) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "Dialog结果: $dialogResult",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        // Dialog特性说明
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Dialog组件特性",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val features = listOf(
                    "• 更灵活的布局控制",
                    "• 可自定义内容区域",
                    "• 支持任意Composable内容",
                    "• 可设置对话框属性"
                )

                features.forEach { feature ->
                    Text(
                        text = feature,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

    // 基础Dialog
    if (showBasicDialog) {
        Dialog(
            onDismissRequest = {
                showBasicDialog = false
                dialogResult = "基础Dialog已关闭"
            }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "成功",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "操作成功",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "您的操作已成功完成",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {
                            showBasicDialog = false
                            dialogResult = "用户确认成功"
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("确定")
                    }
                }
            }
        }
    }

    // 自定义Dialog
    if (showCustomDialog) {
        var inputText by remember { mutableStateOf("") }

        Dialog(
            onDismissRequest = {
                showCustomDialog = false
                dialogResult = "自定义Dialog已关闭"
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "自定义Dialog",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { inputText = it },
                            label = { Text("请输入内容") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Text(
                            text = "这是一个完全自定义的对话框，\n可以包含任意内容和布局。",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                showCustomDialog = false
                                dialogResult = "用户取消了输入"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("取消")
                        }

                        Button(
                            onClick = {
                                showCustomDialog = false
                                dialogResult = "用户输入了: $inputText"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("确定")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetDemo() {
    var showStandardBottomSheet by remember { mutableStateOf(false) }
    var showModalBottomSheet by remember { mutableStateOf(false) }
    var bottomSheetResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "BottomSheet 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // BottomSheet按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { showStandardBottomSheet = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("标准BottomSheet")
            }

            Button(
                onClick = { showModalBottomSheet = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("模态BottomSheet")
            }
        }

        // 显示结果
        if (bottomSheetResult != null) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(
                    text = "BottomSheet结果: $bottomSheetResult",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }

        // BottomSheet特性说明
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "BottomSheet特性",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val features = listOf(
                    "• 从屏幕底部滑出的面板",
                    "• 标准版本可以继续与背景交互",
                    "• 模态版本会阻止背景交互",
                    "• 常用于选择器、菜单和详情展示"
                )

                features.forEach { feature ->
                    Text(
                        text = feature,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

    // 标准BottomSheet
    if (showStandardBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showStandardBottomSheet = false
                bottomSheetResult = "标准BottomSheet已关闭"
            },
            sheetState = rememberModalBottomSheetState()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "标准BottomSheet",
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(
                        onClick = {
                            showStandardBottomSheet = false
                            bottomSheetResult = "用户关闭了标准BottomSheet"
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "关闭"
                        )
                    }
                }

                val options = listOf(
                    "分享" to Icons.Default.Share,
                    "编辑" to Icons.Default.Edit,
                    "删除" to Icons.Default.Delete,
                    "收藏" to Icons.Default.Favorite,
                    "下载" to Icons.Default.Download,
                    "复制链接" to Icons.Default.Link
                )

                options.chunked(3).forEach { chunk ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        chunk.forEach { (text, icon) ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        showStandardBottomSheet = false
                                        bottomSheetResult = "用户选择了$text"
                                    }
                            ) {
                                Surface(
                                    modifier = Modifier.size(48.dp),
                                    shape = CircleShape,
                                    color = MaterialTheme.colorScheme.primaryContainer
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = text,
                                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    }
                                }
                                Text(
                                    text = text,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    // 模态BottomSheet
    if (showModalBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showModalBottomSheet = false
                bottomSheetResult = "模态BottomSheet已关闭"
            },
            sheetState = rememberModalBottomSheetState(),
            dragHandle = {
                Surface(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .width(32.dp)
                        .height(4.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                ) {}
            }
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "选择操作",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Divider()

                val actions = listOf(
                    "拍照" to Icons.Default.Camera,
                    "从相册选择" to Icons.Default.PhotoLibrary,
                    "从文件选择" to Icons.Default.Folder
                )

                actions.forEach { (text, icon) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showModalBottomSheet = false
                                bottomSheetResult = "用户选择$text"
                            }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = text,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = text,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        showModalBottomSheet = false
                        bottomSheetResult = "用户取消了选择"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("取消")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetDemo() {
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "ModalBottomSheet 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { showBottomSheet = true }
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "当前选择",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = selectedValue ?: "点击选择",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        // 选择器示例
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "选择器类型",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val pickerTypes = listOf(
                    "颜色选择器" to MaterialTheme.colorScheme.primary,
                    "字体大小选择器" to MaterialTheme.colorScheme.secondary,
                    "主题选择器" to MaterialTheme.colorScheme.tertiary
                )

                pickerTypes.forEach { (type, color) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            modifier = Modifier.size(12.dp),
                            shape = CircleShape,
                            color = color
                        ) {}
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = type,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }

    // 模态BottomSheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = rememberModalBottomSheetState()
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "选择颜色",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                val colors = listOf(
                    "红色" to androidx.compose.ui.graphics.Color.Red,
                    "绿色" to androidx.compose.ui.graphics.Color.Green,
                    "蓝色" to androidx.compose.ui.graphics.Color.Blue,
                    "黄色" to androidx.compose.ui.graphics.Color.Yellow,
                    "紫色" to androidx.compose.ui.graphics.Color.Magenta,
                    "青色" to androidx.compose.ui.graphics.Color.Cyan
                )

                LazyVerticalGrid(
                    columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(colors) { (name, color) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                selectedValue = name
                                showBottomSheet = false
                            }
                        ) {
                            Surface(
                                modifier = Modifier.size(48.dp),
                                shape = CircleShape,
                                color = color
                            ) {}
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = name,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}