package com.hong.compose.test.components.basic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // 自定义输入框的状态
    var bgText by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }
    var cardText by remember { mutableStateOf("") }
    var gradientText by remember { mutableStateOf("") }
    var numberText by remember { mutableStateOf("1") }
    var strengthPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "TextField 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础文本输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础文本输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("基础输入框") },
                    placeholder = { Text("请输入文本") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("填充式输入框") },
                    placeholder = { Text("请输入文本") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 密码输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "密码输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("密码") },
                    placeholder = { Text("请输入密码") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = if (passwordVisible) "隐藏密码" else "显示密码"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 带图标的输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "带图标的输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("邮箱") },
                    placeholder = { Text("请输入邮箱地址") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "邮箱图标"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("手机号") },
                    placeholder = { Text("请输入手机号") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "手机图标"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 搜索框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "搜索框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    label = { Text("搜索") },
                    placeholder = { Text("输入关键词搜索") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "搜索图标"
                        )
                    },
                    trailingIcon = {
                        if (search.isNotEmpty()) {
                            IconButton(onClick = { search = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "清除"
                                )
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = { /* 执行搜索 */ }
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = { Text("填充式搜索框") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "搜索图标"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 多行文本输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "多行文本输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("描述") },
                    placeholder = { Text("请输入详细描述...") },
                    minLines = 3,
                    maxLines = 5,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "当前字符数: ${description.length}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // 不同状态的输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同状态的输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = "禁用的输入框",
                    onValueChange = { },
                    label = { Text("禁用状态") },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "这是只读文本，无法修改",
                    onValueChange = { },
                    label = { Text("只读状态") },
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )

                var errorText by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = errorText,
                    onValueChange = {
                        errorText = it
                    },
                    label = { Text("错误状态") },
                    placeholder = { Text("输入内容会显示错误") },
                    isError = errorText.isNotEmpty(),
                    supportingText = {
                        if (errorText.isNotEmpty()) {
                            Text(
                                text = "这是一个错误信息",
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 数字输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "数字输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                var number by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = number,
                    onValueChange = {
                        if (it.isEmpty() || it.all { char -> char.isDigit() }) {
                            number = it
                        }
                    },
                    label = { Text("数字") },
                    placeholder = { Text("只能输入数字") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                var decimal by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = decimal,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*$"))) {
                            decimal = it
                        }
                    },
                    label = { Text("小数") },
                    placeholder = { Text("可输入小数") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 字符限制输入框
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "字符限制输入框",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                var limitedText by remember { mutableStateOf("") }
                val maxLength = 20

                OutlinedTextField(
                    value = limitedText,
                    onValueChange = {
                        if (it.length <= maxLength) {
                            limitedText = it
                        }
                    },
                    label = { Text("用户名") },
                    placeholder = { Text("最多20个字符") },
                    supportingText = {
                        Text(
                            text = "${limitedText.length}/$maxLength",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // 自定义输入框展示
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "自定义输入框组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // 1. 无边框背景输入框
                Text(
                    text = "无边框背景输入框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                BackgroundTextField(
                    value = bgText,
                    onValueChange = { bgText = it },
                    placeholder = "请输入内容...",
                    cornerRadius = 16
                )

                // 2. 搜索框
                Text(
                    text = "搜索框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                SearchTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    onSearch = { /* 处理搜索 */ },
                    placeholder = "搜索商品、用户..."
                )

                // 3. 卡片样式输入框
                Text(
                    text = "卡片样式输入框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                CardTextField(
                    value = cardText,
                    onValueChange = { cardText = it },
                    placeholder = "请输入用户名",
                    icon = Icons.Default.Person,
                    elevation = 4
                ) {
                    cardText = ""
                }

                // 4. 渐变边框输入框
                Text(
                    text = "渐变边框输入框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                GradientBorderTextField(
                    value = gradientText,
                    onValueChange = { gradientText = it },
                    label = "邮箱",
                    placeholder = "请输入邮箱地址"
                )

                // 5. 数字输入框
                Text(
                    text = "数字输入框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                NumberInputField(
                    value = numberText,
                    onValueChange = { numberText = it },
                    label = "数量",
                    min = 1,
                    max = 100,
                    step = 1
                )

                // 6. 密码强度输入框
                Text(
                    text = "密码强度输入框",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                PasswordStrengthField(
                    value = strengthPassword,
                    onValueChange = { strengthPassword = it },
                    showStrengthIndicator = true
                )
            }
        }
    }
}

// ==================== 自定义输入框组件 ====================

// 1. 无边框背景输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackgroundTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    placeholderColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    cornerRadius: Int = 12,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius.dp)
            ),
        placeholder = {
            Text(
                text = placeholder,
                color = placeholderColor,
                style = textStyle
            )
        },
        shape = RoundedCornerShape(cornerRadius.dp),
        enabled = enabled,
        singleLine = singleLine,
        maxLines = maxLines,
        textStyle = textStyle
    )
}

// 2. 搜索框样式输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "搜索...",
    onSearch: (String) -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    cornerRadius: Int = 50,
    showClearButton: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius.dp)
            ).padding(start = 12.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = iconColor,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "搜索图标",
                tint = iconColor
            )
        },
        trailingIcon = {
            if (showClearButton && value.isNotEmpty()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "清除",
                        tint = iconColor
                    )
                }
            }
        },
        shape = RoundedCornerShape(cornerRadius.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = if (isFocused) MaterialTheme.colorScheme.primary else Color.Transparent,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch(value) }
        ),
        singleLine = true
    )
}

// 3. 卡片样式输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    elevation: Int = 2,
    cornerRadius: Int = 16,
    backgroundColor: Color = Color.White,
    borderColor: Color = Color.Transparent,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onClear: () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(elevation.dp),
        shape = RoundedCornerShape(cornerRadius.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                if (placeholder.isNotEmpty()) {
                    Text(
                        text = placeholder,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            leadingIcon = icon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(
                        onClick = onClear
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = borderColor,
                focusedBorderColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface
            ),
            enabled = enabled,
            singleLine = true
        )
    }
}

// 4. 渐变边框输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradientBorderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    cornerRadius: Int = 12,
    borderWidth: Int = 2,
    gradientColors: List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary
    ),
    backgroundColor: Color = MaterialTheme.colorScheme.surface
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape=RoundedCornerShape(cornerRadius.dp)
            )
            .border(
                width = borderWidth.dp,
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(gradientColors),
                shape = RoundedCornerShape(cornerRadius.dp)
            )
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                if (placeholder.isNotEmpty()) {
                    Text(text = placeholder)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(cornerRadius.dp - 2.dp),
            singleLine = true
        )
    }
}

// 5. 数字输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String = "",
    min: Int? = null,
    max: Int? = null,
    step: Int = 1,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    cornerRadius: Int = 12
) {
    var numericValue by remember { mutableStateOf(value) }

    LaunchedEffect(value) {
        numericValue = value
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = numericValue,
            onValueChange = { input ->
                if (input.isEmpty() || input.matches(Regex("^\\d+$"))) {
                    val num = input.toIntOrNull()
                    if (num == null || (min != null && num < min) || (max != null && num > max)) {
                        return@OutlinedTextField
                    }
                    numericValue = input
                    onValueChange(input)
                }
            },
            modifier = Modifier.weight(1f),
            placeholder = {
                if (placeholder.isNotEmpty()) {
                    Text(text = placeholder)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(cornerRadius.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedContainerColor = backgroundColor,
                focusedContainerColor = backgroundColor,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface
            )
        )

        // 增加/减少按钮
        Column(
            modifier = Modifier.padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    val current = numericValue.toIntOrNull() ?: 0
                    val newValue = current + step
                    if (max == null || newValue <= max) {
                        val newStr = newValue.toString()
                        numericValue = newStr
                        onValueChange(newStr)
                    }
                },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "增加",
                    modifier = Modifier.size(16.dp)
                )
            }

            IconButton(
                onClick = {
                    val current = numericValue.toIntOrNull() ?: 0
                    val newValue = current - step
                    if (min == null || newValue >= min) {
                        val newStr = newValue.toString()
                        numericValue = newStr
                        onValueChange(newStr)
                    }
                },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "减少",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

// 6. 密码强度输入框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordStrengthField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "密码",
    placeholder: String = "请输入密码",
    showStrengthIndicator: Boolean = true
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "隐藏密码" else "显示密码"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface
            )
        )

        if (showStrengthIndicator && value.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            PasswordStrengthIndicator(password = value)
        }
    }
}

@Composable
private fun PasswordStrengthIndicator(password: String) {
    val strength = calculatePasswordStrength(password)
    val strengthColor = when (strength) {
        in 0..2 -> Color.Red
        in 3..4 -> Color(0xFFFF9800) // 橙色
        else -> Color.Green
    }

    val strengthText = when (strength) {
        in 0..2 -> "弱"
        in 3..4 -> "中等"
        else -> "强"
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 强度指示条
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.weight(1f)
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .weight(1f)
                        .background(
                            if (index < strength) strengthColor else Color.Gray.copy(alpha = 0.3f),
                            RoundedCornerShape(2.dp)
                        )
                )
            }
        }

        // 强度文字
        Text(
            text = strengthText,
            color = strengthColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

private fun calculatePasswordStrength(password: String): Int {
    var strength = 0

    // 长度检查
    if (password.length >= 8) strength++
    if (password.length >= 12) strength++

    // 字符类型检查
    if (password.any { it.isUpperCase() }) strength++
    if (password.any { it.isLowerCase() }) strength++
    if (password.any { it.isDigit() }) strength++
    if (password.any { !it.isLetterOrDigit() }) strength++

    return strength.coerceAtMost(5)
}