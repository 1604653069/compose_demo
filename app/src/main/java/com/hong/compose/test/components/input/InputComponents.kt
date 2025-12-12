package com.hong.compose.test.components.input

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.size

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxDemo() {
    val checkedStates = remember { mutableStateListOf(false, false, false) }
    var masterChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Checkbox 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础复选框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础复选框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                    )
                    Text("未选中")

                    Checkbox(
                        checked = true,
                        onCheckedChange = { }
                    )
                    Text("已选中")
                }
            }
        }

        // 带标签的复选框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "带标签的复选框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = checkedStates[0],
                            onClick = { checkedStates[0] = !checkedStates[0] },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedStates[0],
                        onCheckedChange = { checkedStates[0] = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("启用通知")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = checkedStates[1],
                            onClick = { checkedStates[1] = !checkedStates[1] },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedStates[1],
                        onCheckedChange = { checkedStates[1] = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("自动更新")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = checkedStates[2],
                            onClick = { checkedStates[2] = !checkedStates[2] },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedStates[2],
                        onCheckedChange = { checkedStates[2] = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("记住密码")
                }
            }
        }

        // 全选功能
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "全选功能",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = masterChecked,
                            onClick = {
                                masterChecked = !masterChecked
                                checkedStates.indices.forEach { i ->
                                    checkedStates[i] = masterChecked
                                }
                            },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = masterChecked,
                        onCheckedChange = { checked ->
                            masterChecked = checked
                            checkedStates.indices.forEach { i ->
                                checkedStates[i] = checked
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "全选 (${checkedStates.count { it }}/${checkedStates.size})",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                )

                val options = listOf("选项A", "选项B", "选项C")
                options.forEachIndexed { index, option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = checkedStates[index],
                                onClick = {
                                    checkedStates[index] = !checkedStates[index]
                                    masterChecked = checkedStates.all { it }
                                },
                                role = Role.Checkbox
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedStates[index],
                            onCheckedChange = {
                                checkedStates[index] = it
                                masterChecked = checkedStates.all { checked -> checked }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(option)
                    }
                }
            }
        }

        // 不同状态的复选框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同状态的复选框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = { },
                            enabled = true
                        )
                        Text("启用")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = { },
                            enabled = false
                        )
                        Text("禁用-选中")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Checkbox(
                            checked = false,
                            onCheckedChange = { },
                            enabled = false
                        )
                        Text("禁用-未选中")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = { },
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colorScheme.error,
                                uncheckedColor = MaterialTheme.colorScheme.error
                            )
                        )
                        Text("自定义颜色")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonDemo() {
    val radioOptions = listOf("选项1", "选项2", "选项3")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "RadioButton 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础单选按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础单选按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = false,
                        onClick = { }
                    )
                    Text("未选中")

                    RadioButton(
                        selected = true,
                        onClick = { }
                    )
                    Text("已选中")
                }
            }
        }

        // 单选按钮组
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "单选按钮组",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                radioOptions.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (option == selectedOption),
                                onClick = { selectedOption = option },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = { selectedOption = option }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                Text(
                    text = "当前选择: $selectedOption",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // 不同样式的单选按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同样式的单选按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // 默认颜色
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = true,
                        onClick = { }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("默认颜色")
                }

                // 主要颜色
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = true,
                        onClick = { },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("主要颜色")
                }

                // 错误颜色
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = true,
                        onClick = { },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colorScheme.error
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("错误颜色")
                }

                // 禁用状态
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = true,
                        onClick = { },
                        enabled = false
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("禁用状态")
                }
            }
        }

        // 带图标和描述的单选按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "带图标和描述的单选按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val iconOptions = listOf(
                    Triple(Icons.Default.Email, "邮件通知", "接收邮件提醒"),
                    Triple(Icons.Default.Notifications, "推送通知", "接收推送提醒"),
                    Triple(Icons.Default.Message, "短信通知", "接收短信提醒")
                )

                iconOptions.forEachIndexed { index, (icon, title, description) ->
                    val isSelected = index == 0
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = isSelected,
                                onClick = { /* 选择此项 */ },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = { /* 选择此项 */ }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchDemo() {
    var switchStates = remember { mutableStateListOf(true, false, true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Switch 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础开关
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础开关",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = false,
                            onCheckedChange = { }
                        )
                        Text("关闭")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { }
                        )
                        Text("开启")
                    }
                }
            }
        }

        // 带标签的开关
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "带标签的开关",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val switchOptions = listOf(
                    "Wi-Fi" to 0,
                    "蓝牙" to 1,
                    "移动数据" to 2
                )

                switchOptions.forEach { (label, index) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Switch(
                            checked = switchStates[index],
                            onCheckedChange = { switchStates[index] = it }
                        )
                    }
                }
            }
        }

        // 不同颜色的开关
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同颜色的开关",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.primary,
                                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                                checkedIconColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                        Text("主要")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.secondary,
                                checkedTrackColor = MaterialTheme.colorScheme.secondaryContainer
                            )
                        )
                        Text("次要")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.error,
                                checkedTrackColor = MaterialTheme.colorScheme.errorContainer
                            )
                        )
                        Text("错误")
                    }
                }
            }
        }

        // 不同状态的开关
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同状态的开关",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                            enabled = true
                        )
                        Text("启用")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                            enabled = false
                        )
                        Text("禁用-开启")
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Switch(
                            checked = false,
                            onCheckedChange = { },
                            enabled = false
                        )
                        Text("禁用-关闭")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderDemo() {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    var rangeStart by remember { mutableFloatStateOf(25f) }
    var rangeEnd by remember { mutableFloatStateOf(75f) }
    var stepValue by remember { mutableIntStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Slider 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础滑块
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础滑块",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "当前值: ${(sliderValue * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyMedium
                )

                Slider(
                    value = sliderValue,
                    onValueChange = { sliderValue = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 带标签的滑块
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "带标签的滑块",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "音量: ${(sliderValue * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeDown,
                        contentDescription = "音量小"
                    )
                    Slider(
                        value = sliderValue,
                        onValueChange = { sliderValue = it },
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "音量大"
                    )
                }
            }
        }

        // 步进滑块
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "步进滑块",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "选择: $stepValue",
                    style = MaterialTheme.typography.bodyLarge
                )

                Slider(
                    value = stepValue.toFloat(),
                    onValueChange = { stepValue = it.toInt() },
                    valueRange = 1f..5f,
                    steps = 3,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf(1, 2, 3, 4, 5).forEach { value ->
                        Text(
                            text = value.toString(),
                            style = MaterialTheme.typography.bodySmall,
                            color = if (value == stepValue) MaterialTheme.colorScheme.primary
                                   else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // 范围滑块
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "范围滑块",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "价格范围: ¥${rangeStart.toInt()} - ¥${rangeEnd.toInt()}",
                    style = MaterialTheme.typography.bodyLarge
                )

                RangeSlider(
                    value = rangeStart..rangeEnd,
                    onValueChange = { range ->
                        rangeStart = range.start
                        rangeEnd = range.endInclusive
                    },
                    valueRange = 0f..100f,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 自定义颜色滑块
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "自定义颜色滑块",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                var customValue by remember { mutableFloatStateOf(0.7f) }

                Text(
                    text = "进度: ${(customValue * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyLarge
                )

                Slider(
                    value = customValue,
                    onValueChange = { customValue = it },
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressBarDemo() {
    var progress by remember { mutableFloatStateOf(0.6f) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(isLoading) {
        while (isLoading) {
            kotlinx.coroutines.delay(50)
            progress = (progress + 0.01f) % 1f
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "ProgressBar 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 线性进度条
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "线性进度条",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "确定进度: ${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyMedium
                )

                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { progress = 0f },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("重置")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { isLoading = !isLoading },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(if (isLoading) "暂停" else "开始")
                    }
                }
            }
        }

        // 不确定进度条
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不确定进度条",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "加载中...",
                    style = MaterialTheme.typography.bodyMedium
                )

                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 圆形进度条
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "圆形进度条",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            progress = progress,
                            modifier = Modifier.size(64.dp)
                        )
                        Text(
                            text = "${(progress * 100).toInt()}%",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(64.dp)
                        )
                        Text(
                            text = "加载中",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        // 不同尺寸的进度条
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同尺寸的进度条",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            progress = progress,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp
                        )
                        Text("小", style = MaterialTheme.typography.bodySmall)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            progress = progress,
                            modifier = Modifier.size(48.dp),
                            strokeWidth = 4.dp
                        )
                        Text("中", style = MaterialTheme.typography.bodySmall)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            progress = progress,
                            modifier = Modifier.size(72.dp),
                            strokeWidth = 6.dp
                        )
                        Text("大", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        // 不同颜色的进度条
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同颜色的进度条",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                ProgressColors()
            }
        }
    }
}

@Composable
private fun ProgressColors() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ProgressColorItem("主要颜色", MaterialTheme.colorScheme.primary)
        ProgressColorItem("次要颜色", MaterialTheme.colorScheme.secondary)
        ProgressColorItem("第三颜色", MaterialTheme.colorScheme.tertiary)
        ProgressColorItem("错误颜色", MaterialTheme.colorScheme.error)
    }
}

@Composable
private fun ProgressColorItem(name: String, color: androidx.compose.ui.graphics.Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier.width(100.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        LinearProgressIndicator(
            progress = 0.7f,
            color = color,
            modifier = Modifier.weight(1f)
        )
    }
}