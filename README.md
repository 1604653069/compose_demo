# Material 3 组件演示应用

这是一个完整的Jetpack Compose Material 3组件演示应用，包含了36+个常用组件的详细实现和交互式演示。

## 📱 项目概述

本项目旨在提供一个全面的Material 3组件学习平台，每个组件都包含：
- 完整的功能演示
- 详细的API说明表格
- 实际交互示例
- 中文本地化支持

## 🎨 技术栈

- **Jetpack Compose** - 现代UI工具包
- **Material 3** - 最新设计系统
- **Navigation Compose** - 应用导航
- **Coil** - 图片加载库
- **Kotlin** - 编程语言

---

## 📋 组件分类与API详解

## 1. 基础显示组件 (Basic Display Components)

### 📝 Text 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `text` | `String` | 要显示的文本内容 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符，用于控制布局、外观等 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `color` | `Color` | 文本颜色 | `Color.Unspecified` | ⭐⭐⭐⭐ |
| `fontSize` | `TextUnit` | 字体大小 | `TextUnit.Unspecified` | ⭐⭐⭐⭐ |
| `fontWeight` | `FontWeight` | 字体粗细 | `FontWeight.Normal` | ⭐⭐⭐ |
| `fontStyle` | `FontStyle` | 字体样式(正常/斜体) | `FontStyle.Normal` | ⭐⭐ |
| `fontFamily` | `FontFamily` | 字体族 | `FontFamily.Default` | ⭐⭐ |
| `letterSpacing` | `TextUnit` | 字符间距 | `TextUnit.Unspecified` | ⭐⭐ |
| `textDecoration` | `TextDecoration` | 文本装饰(下划线/删除线) | `TextDecoration.None` | ⭐⭐ |
| `textAlign` | `TextAlign` | 文本对齐方式 | `TextAlign.Start` | ⭐⭐⭐ |
| `lineHeight` | `TextUnit` | 行高 | `TextUnit.Unspecified` | ⭐⭐ |
| `overflow` | `TextOverflow` | 文本溢出处理方式 | `TextOverflow.Clip` | ⭐⭐⭐ |
| `softWrap` | `Boolean` | 是否自动换行 | `true` | ⭐⭐ |
| `maxLines` | `Int` | 最大行数 | `Int.MAX_VALUE` | ⭐⭐⭐ |
| `minLines` | `Int` | 最小行数 | `1` | ⭐ |
| `style` | `TextStyle` | 文本样式(包含多个属性) | `MaterialTheme.typography.bodyMedium` | ⭐⭐⭐⭐⭐ |

#### Material 3 预定义样式

| 样式名称 | 大小 | 权重 | 使用场景 |
|----------|------|------|----------|
| `displayLarge` | 57sp | Regular | 最大标题 |
| `displayMedium` | 45sp | Regular | 大标题 |
| `displaySmall` | 36sp | Regular | 中等大标题 |
| `headlineLarge` | 32sp | Regular | 大标题 |
| `headlineMedium` | 28sp | Regular | 标题 |
| `headlineSmall` | 24sp | Regular | 小标题 |
| `titleLarge` | 22sp | Medium | 大段标题 |
| `titleMedium` | 16sp | Medium | 段落标题 |
| `titleSmall` | 14sp | Medium | 小标题 |
| `bodyLarge` | 16sp | Regular | 正文 |
| `bodyMedium` | 14sp | Regular | 小正文 |
| `bodySmall` | 12sp | Regular | 说明文字 |
| `labelLarge` | 14sp | Medium | 大标签 |
| `labelMedium` | 12sp | Medium | 中标签 |
| `labelSmall` | 11sp | Medium | 小标签 |

#### 代码示例

```kotlin
// 基础用法
Text(
    text = "Hello World",
    modifier = Modifier.padding(16.dp),
    color = MaterialTheme.colorScheme.primary,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold
)

// 带溢出处理的文本
Text(
    text = "这是一段很长的文本内容，超出范围时会被截断",
    maxLines = 2,
    overflow = TextOverflow.Ellipsis,
    modifier = Modifier.width(200.dp)
)

// 样式化文本
Text(
    text = "样式化文本",
    style = MaterialTheme.typography.titleLarge,
    color = MaterialTheme.colorScheme.primary
)
```

### 🔘 Button 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `onClick` | `() -> Unit` | 点击事件回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `shape` | `Shape` | 按钮形状 | `ButtonDefaults.shape` | ⭐⭐⭐ |
| `colors` | `ButtonColors` | 按钮颜色配置 | `ButtonDefaults.buttonColors()` | ⭐⭐⭐⭐ |
| `elevation` | `ButtonElevation` | 阴影配置 | `ButtonDefaults.buttonElevation()` | ⭐⭐⭐ |
| `border` | `BorderStroke?` | 边框 | `null` | ⭐⭐ |
| `contentPadding` | `PaddingValues` | 内容内边距 | `ButtonDefaults.ContentPadding` | ⭐⭐ |
| `interactionSource` | `MutableInteractionSource?` | 交互源 | `null` | ⭐ |

#### 按钮变体对比

| 类型 | 使用场景 | 特点 | 视觉层次 |
|------|----------|------|----------|
| `Button` | 主要操作 | 填充背景，视觉突出 | 最高 |
| `OutlinedButton` | 次要操作 | 轮廓边框，视觉适中 | 中等 |
| `TextButton` | 最小操作 | 无背景，文字按钮 | 最低 |
| `ElevatedButton` | 强调操作 | 带阴影，立体效果 | 高 |

#### 代码示例

```kotlin
// 基础按钮
Button(
    onClick = { /* 处理点击 */ },
    enabled = true,
    modifier = Modifier.fillMaxWidth()
) {
    Text("主要按钮")
}

// 带图标的按钮
Button(
    onClick = { /* 处理点击 */ },
    colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary
    )
) {
    Icon(
        Icons.Default.Add,
        contentDescription = "添加",
        modifier = Modifier.size(18.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text("添加")
}

// 轮廓按钮
OutlinedButton(
    onClick = { /* 处理点击 */ },
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
) {
    Text("次要按钮")
}

// FAB (FloatingActionButton)
FloatingActionButton(
    onClick = { /* 处理点击 */ },
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary
) {
    Icon(Icons.Default.Add, "添加")
}
```

### 📝 TextField 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `value` | `String` | 输入框当前值 | - | ⭐⭐⭐⭐⭐ |
| `onValueChange` | `(String) -> Unit` | 值变化回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `readOnly` | `Boolean` | 是否只读 | `false` | ⭐⭐⭐ |
| `textStyle` | `TextStyle` | 文本样式 | `MaterialTheme.typography.bodyMedium` | ⭐⭐⭐ |
| `label` | `@Composable () -> Unit?` | 标签 | `null` | ⭐⭐⭐⭐ |
| `placeholder` | `@Composable () -> Unit?` | 占位符 | `null` | ⭐⭐⭐⭐ |
| `leadingIcon` | `@Composable () -> Unit?` | 前置图标 | `null` | ⭐⭐⭐ |
| `trailingIcon` | `@Composable () -> Unit?` | 后置图标 | `null` | ⭐⭐⭐ |
| `prefix` | `@Composable () -> Unit?` | 前缀文本 | `null` | ⭐⭐ |
| `suffix` | `@Composable () -> Unit?` | 后缀文本 | `null` | ⭐⭐ |
| `supportingText` | `@Composable () -> Unit?` | 辅助文本 | `null` | ⭐⭐⭐ |
| `isError` | `Boolean` | 是否显示错误状态 | `false` | ⭐⭐⭐⭐ |
| `visualTransformation` | `VisualTransformation` | 视觉转换 | `VisualTransformation.None` | ⭐⭐⭐ |
| `keyboardOptions` | `KeyboardOptions` | 键盘选项 | `KeyboardOptions.Default` | ⭐⭐⭐ |
| `keyboardActions` | `KeyboardActions` | 键盘动作 | `KeyboardActions.Default` | ⭐⭐ |
| `singleLine` | `Boolean` | 是否单行 | `false` | ⭐⭐⭐ |
| `maxLines` | `Int` | 最大行数 | `Int.MAX_VALUE` | ⭐⭐⭐ |
| `minLines` | `Int` | 最小行数 | `1` | ⭐ |

#### 键盘类型配置

| KeyboardType | 说明 | 使用场景 |
|---------------|------|----------|
| `Text` | 普通文本 | 默认输入 |
| `Number` | 数字 | 数量输入 |
| `Phone` | 电话号码 | 电话输入 |
| `Uri` | URI地址 | 网址输入 |
| `Email` | 邮箱地址 | 邮箱输入 |
| `Password` | 密码 | 密码输入 |
| `NumberPassword` | 数字密码 | PIN码输入 |

#### 键盘动作配置

| ImeAction | 说明 | 使用场景 |
|------------|------|----------|
| `Default` | 默认 | 无特殊要求 |
| `Done` | 完成 | 表单完成 |
| `Go` | 前往 | 搜索/导航 |
| `Next` | 下一个 | 表单下一步 |
| `Previous` | 上一个 | 表单上一步 |
| `Search` | 搜索 | 搜索操作 |
| `Send` | 发送 | 消息发送 |

#### 代码示例

```kotlin
// 基础输入框
var text by remember { mutableStateOf("") }

OutlinedTextField(
    value = text,
    onValueChange = { text = it },
    label = { Text("用户名") },
    placeholder = { Text("请输入用户名") },
    modifier = Modifier.fillMaxWidth()
)

// 密码输入框
var password by remember { mutableStateOf("") }
var passwordVisible by remember { mutableStateOf(false) }

OutlinedTextField(
    value = password,
    onValueChange = { password = it },
    label = { Text("密码") },
    visualTransformation = if (passwordVisible)
        VisualTransformation.None else PasswordVisualTransformation(),
    keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done
    ),
    trailingIcon = {
        IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(
                if (passwordVisible) Icons.Default.Visibility
                else Icons.Default.VisibilityOff,
                contentDescription = "显示密码"
            )
        }
    }
)

// 搜索框
var searchQuery by remember { mutableStateOf("") }

OutlinedTextField(
    value = searchQuery,
    onValueChange = { searchQuery = it },
    placeholder = { Text("搜索...") },
    leadingIcon = {
        Icon(Icons.Default.Search, "搜索")
    },
    trailingIcon = {
        if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Clear, "清除")
            }
        }
    },
    keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Search
    ),
    keyboardActions = KeyboardActions(
        onSearch = { /* 执行搜索 */ }
    )
)

// 带字符限制的输入框
var description by remember { mutableStateOf("") }
val maxLength = 200

OutlinedTextField(
    value = description,
    onValueChange = {
        if (it.length <= maxLength) description = it
    },
    label = { Text("描述") },
    supportingText = {
        Text(
            text = "${description.length}/$maxLength",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
    },
    isError = description.length > maxLength
)
```

## 2. 布局组件 (Layout Components)

### 🃏 Card 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `shape` | `Shape` | 卡片形状 | `CardDefaults.shape` | ⭐⭐⭐ |
| `colors` | `CardColors` | 卡片颜色配置 | `CardDefaults.cardColors()` | ⭐⭐⭐⭐ |
| `elevation` | `CardElevation` | 阴影配置 | `CardDefaults.cardElevation()` | ⭐⭐⭐ |
| `border` | `BorderStroke?` | 边框 | `null` | ⭐⭐ |

#### 颜色配置选项

| 参数 | 功能 | 默认值 |
|------|------|--------|
| `containerColor` | 容器背景色 | `MaterialTheme.colorScheme.surface` |
| `contentColor` | 内容颜色 | `MaterialTheme.colorScheme.onSurface` |
| `disabledContainerColor` | 禁用容器色 | `MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)` |
| `disabledContentColor` | 禁用内容色 | `MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)` |

#### 代码示例

```kotlin
// 基础卡片
Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp
    )
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "卡片标题",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "这是卡片的详细内容描述",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// 带图标的卡片
Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    )
) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.Info,
            contentDescription = "信息",
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "重要信息卡片",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

// 可点击卡片
var isClicked by remember { mutableStateOf(false) }

Card(
    modifier = Modifier
        .fillMaxWidth()
        .clickable { isClicked = !isClicked },
    colors = CardDefaults.cardColors(
        containerColor = if (isClicked)
            MaterialTheme.colorScheme.primaryContainer
        else
            MaterialTheme.colorScheme.surface
    )
) {
    Text(
        text = if (isClicked) "已点击" else "点击我",
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}
```

### 🏗️ Scaffold 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `topBar` | `@Composable () -> Unit` | 顶部应用栏 | `null` | ⭐⭐⭐⭐ |
| `bottomBar` | `@Composable () -> Unit` | 底部应用栏 | `null` | ⭐⭐⭐⭐ |
| `snackbarHost` | `@Composable () -> Unit` | Snackbar宿主 | `null` | ⭐⭐ |
| `floatingActionButton` | `@Composable () -> Unit` | 悬浮按钮 | `null` | ⭐⭐⭐ |
| `floatingActionButtonPosition` | `FabPosition` | FAB位置 | `FabPosition.End` | ⭐⭐ |
| `containerColor` | `Color` | 容器颜色 | `MaterialTheme.colorScheme.background` | ⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `contentColorFor(containerColor)` | ⭐⭐ |

#### FAB位置选项

| 选项 | 说明 | 使用场景 |
|------|------|----------|
| `FabPosition.End` | 右下角 | 标准位置(默认) |
| `FabPosition.Start` | 左下角 | RTL语言环境 |
| `FabPosition.Center` | 底部中央 | 特殊设计需求 |

#### 代码示例

```kotlin
// 基础Scaffold结构
Scaffold(
    topBar = {
        TopAppBar(
            title = { Text("应用标题") },
            navigationIcon = {
                IconButton(onClick = { /* 导航 */ }) {
                    Icon(Icons.Default.Menu, "菜单")
                }
            }
        )
    },
    bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, item.title) },
                    label = { Text(item.title) },
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index }
                )
            }
        }
    },
    floatingActionButton = {
        FloatingActionButton(
            onClick = { /* 添加操作 */ }
        ) {
            Icon(Icons.Default.Add, "添加")
        }
    },
    floatingActionButtonPosition = FabPosition.End
) { paddingValues ->
    // 主要内容区域
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                // 内容项
            }
        }
    }
}

// 带Snackbar的Scaffold
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

Scaffold(
    snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    },
    floatingActionButton = {
        FloatingActionButton(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("操作成功")
                }
            }
        ) {
            Icon(Icons.Default.Check, "确认")
        }
    }
) { paddingValues ->
    // 内容
}
```

## 3. 输入组件 (Input Components)

### ☑️ Checkbox 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `checked` | `Boolean` | 是否选中 | - | ⭐⭐⭐⭐⭐ |
| `onCheckedChange` | `(Boolean) -> Unit` | 状态变化回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `colors` | `CheckboxColors` | 颜色配置 | `CheckboxDefaults.colors()` | ⭐⭐⭐ |
| `interactionSource` | `MutableInteractionSource?` | 交互源 | `null` | ⭐ |

#### 三态复选框状态

| 状态 | 说明 | 枚举值 |
|------|------|---------|
| 选中 | 完全选中 | `ToggleableState.On` |
| 未选中 | 完全未选中 | `ToggleableState.Off` |
| 半选 | 部分选中 | `ToggleableState.Indeterminate` |

#### 代码示例

```kotlin
// 基础复选框
var isChecked by remember { mutableStateOf(false) }

Row(
    verticalAlignment = Alignment.CenterVertically
) {
    Checkbox(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.primary,
            uncheckedColor = MaterialTheme.colorScheme.onSurface,
            checkmarkColor = MaterialTheme.colorScheme.onPrimary
        )
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text("记住密码")
}

// 三态复选框
var selectAll by remember { mutableStateOf(ToggleableState.Off) }

Row(
    verticalAlignment = Alignment.CenterVertically
) ) {
    TriStateCheckbox(
        state = selectAll,
        onClick = {
            selectAll = when (selectAll) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        }
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text("全选")
}

// 自定义样式的复选框
Checkbox(
    checked = isChecked,
    onCheckedChange = { isChecked = it },
    modifier = Modifier.size(24.dp),
    colors = CheckboxDefaults.colors(
        checkedColor = MaterialTheme.colorScheme.secondary,
        uncheckedColor = MaterialTheme.colorScheme.outline,
        checkmarkColor = Color.White
    )
)
```

### 🔘 RadioButton 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selected` | `Boolean` | 是否选中 | - | ⭐⭐⭐⭐⭐ |
| `onClick` | `() -> Unit` | 点击事件 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `colors` | `RadioButtonColors` | 颜色配置 | `RadioButtonDefaults.colors()` | ⭐⭐⭐ |
| `interactionSource` | `MutableInteractionSource?` | 交互源 | `null` | ⭐ |

#### 代码示例

```kotlin
// 单选组合
var selectedOption by remember { mutableStateOf("option1") }
val options = listOf("选项1", "选项2", "选项3")

Column(
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    options.forEach { option ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { selectedOption = option }
        ) {
            RadioButton(
                selected = selectedOption == option,
                onClick = { selectedOption = option },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(option)
        }
    }
}

// 带描述的单选项
Card(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected,
                onClick = { /* 处理选择 */ }
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
```

### 🔄 Switch 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `checked` | `Boolean` | 是否开启 | - | ⭐⭐⭐⭐⭐ |
| `onCheckedChange` | `(Boolean) -> Unit` | 状态变化回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `thumbContent` | `@Composable (() -> Unit)?` | 滑块内容 | `null` | ⭐⭐⭐ |
| `colors` | `SwitchColors` | 颜色配置 | `SwitchDefaults.colors()` | ⭐⭐⭐ |
| `interactionSource` | `MutableInteractionSource?` | 交互源 | `null` | ⭐ |

#### 代码示例

```kotlin
// 基础开关
var isSwitched by remember { mutableStateOf(false) }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Column {
        Text(
            text = "通知提醒",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "接收应用推送通知",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    Switch(
        checked = isSwitched,
        onCheckedChange = { isSwitched = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.outline,
            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

// 带图标的开关
Switch(
    checked = isSwitched,
    onCheckedChange = { isSwitched = it },
    thumbContent = {
        if (isSwitched) {
            Icon(
                Icons.Default.Check,
                null,
                Modifier.size(SwitchDefaults.IconSize),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
)
```

### 📏 Slider 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `value` | `Float` | 当前值 | - | ⭐⭐⭐⭐⭐ |
| `onValueChange` | `(Float) -> Unit` | 值变化回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐ |
| `valueRange` | `ClosedFloatingPointRange<Float>` | 值范围 | `0f..1f` | ⭐⭐⭐⭐ |
| `steps` | `Int` | 分段数量 | `0` (连续) | ⭐⭐⭐ |
| `onValueChangeFinished` | `(() -> Unit)?` | 拖拽结束回调 | `null` | ⭐⭐ |
| `colors` | `SliderColors` | 颜色配置 | `SliderDefaults.colors()` | ⭐⭐⭐ |
| `thumbContent` | `@Composable (() -> Unit)?` | 滑块内容 | `null` | ⭐⭐ |

#### 代码示例

```kotlin
// 基础滑块
var volume by remember { mutableStateOf(0.5f) }

Column {
    Text(
        text = "音量: ${(volume * 100).toInt()}%",
        style = MaterialTheme.typography.bodyMedium
    )

    Slider(
        value = volume,
        onValueChange = { volume = it },
        valueRange = 0f..1f,
        steps = 0, // 连续滑动
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.primary,
            activeTrackColor = MaterialTheme.colorScheme.primary,
            inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

// 离散滑块
var brightness by remember { mutableStateOf(3) }

Slider(
    value = brightness.toFloat(),
    onValueChange = { brightness = it.toInt() },
    valueRange = 1f..10f,
    steps = 8, // 10个离散值
    thumbContent = {
        Text(
            text = brightness.toString(),
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
    }
)

// 范围滑块
var priceRange by remember { mutableStateOf(100f..500f) }

RangeSlider(
    value = priceRange,
    onValueChange = { priceRange = it },
    valueRange = 0f..1000f,
    steps = 20
)

Text(
    text = "价格范围: $${priceRange.start.toInt()} - $${priceRange.endInclusive.toInt()}",
    style = MaterialTheme.typography.bodyMedium
)
```

## 4. 列表组件 (List Components)

### 📋 ListItem 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `headlineContent` | `@Composable () -> Unit` | 主标题内容 | `null` | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `supportingContent` | `@Composable () -> Unit?` | 副标题内容 | `null` | ⭐⭐⭐⭐ |
| `leadingContent` | `@Composable () -> Unit?` | 前置内容 | `null` | ⭐⭐⭐⭐ |
| `trailingContent` | `@Composable () -> Unit?` | 后置内容 | `null` | ⭐⭐⭐ |
| `overlineContent` | `@Composable () -> Unit?` | 上方内容 | `null` | ⭐⭐ |
| `colors` | `ListItemColors` | 颜色配置 | `ListItemDefaults.colors()` | ⭐⭐⭐ |
| `tonalElevation` | `Dp` | 色调高度 | `0.dp` | ⭐⭐ |
| `shadowElevation` | `Dp` | 阴影高度 | `0.dp` | ⭐⭐ |

#### 颜色配置选项

| 参数 | 功能 | 默认值 |
|------|------|--------|
| `containerColor` | 容器颜色 | `Color.Transparent` |
| `headlineColor` | 主标题颜色 | `MaterialTheme.colorScheme.onSurface` |
| `supportingColor` | 副标题颜色 | `MaterialTheme.colorScheme.onSurfaceVariant` |
| `leadingColor` | 前置内容颜色 | `MaterialTheme.colorScheme.onSurfaceVariant` |
| `trailingColor` | 后置内容颜色 | `MaterialTheme.colorScheme.onSurfaceVariant` |

#### 代码示例

```kotlin
// 基础ListItem
ListItem(
    headlineContent = { Text("项目标题") },
    supportingContent = { Text("这是项目的详细描述信息") },
    leadingContent = {
        Icon(
            Icons.Default.Star,
            contentDescription = "星标",
            tint = MaterialTheme.colorScheme.primary
        )
    },
    trailingContent = {
        Icon(
            Icons.Default.ArrowForward,
            contentDescription = "详情"
        )
    },
    colors = ListItemDefaults.colors(
        containerColor = Color.Transparent
    )
)

// 带点击的ListItem
var items = listOf("项目1", "项目2", "项目3")

LazyColumn {
    items(items) { item ->
        ListItem(
            headlineContent = { Text(item) },
            supportingContent = { Text("$item 的描述") },
            leadingContent = {
                Icon(Icons.Default.Folder, "文件夹")
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* 处理点击 */ },
            trailingContent = {
                Icon(Icons.Default.MoreVert, "更多选项")
            }
        )
        HorizontalDivider()
    }
}

// 三行式ListItem
ListItem(
    headlineContent = { Text("标题") },
    overlineContent = { Text("上标") },
    supportingContent = { Text("副标题信息") },
    leadingContent = {
        Box(
            modifier = Modifier.size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, "用户")
        }
    },
    trailingContent = {
        IconButton(onClick = { /* 更多操作 */ }) {
            Icon(Icons.Default.MoreVert, "更多")
        }
    }
)
```

### 📜 LazyColumn 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `contentPadding` | `PaddingValues` | 内容内边距 | `PaddingValues(0.dp)` | ⭐⭐⭐⭐ |
| `reverseLayout` | `Boolean` | 是否反向布局 | `false` | ⭐⭐ |
| `verticalArrangement` | `Arrangement.Vertical` | 垂直排列方式 | `Arrangement.Top` | ⭐⭐⭐ |
| `horizontalAlignment` | `Alignment.Horizontal` | 水平对齐方式 | `Alignment.Start` | ⭐⭐⭐ |
| `flingBehavior` | `FlingBehavior` | 滚动行为 | `ScrollableDefaults.flingBehavior()` | ⭐⭐ |
| `userScrollEnabled` | `Boolean` | 是否允许用户滚动 | `true` | ⭐⭐⭐ |

#### LazyListScope 方法

| 方法名 | 功能 | 使用频率 |
|--------|------|----------|
| `item()` | 添加单个项 | ⭐⭐⭐⭐⭐ |
| `items(count)` | 添加指定数量的项 | ⭐⭐⭐⭐⭐ |
| `items(list)` | 添加列表项 | ⭐⭐⭐⭐⭐ |
| `items(list, key)` | 添加带键的列表项 | ⭐⭐⭐⭐ |
| `itemsIndexed()` | 添加带索引的项 | ⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础LazyColumn
LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    // 头部项
    item {
        Text(
            text = "列表标题",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }

    // 简单项列表
    items(50) { index ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateItemPlacement()
        ) {
            Text(
                text = "项目 $index",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    // 列表项
    val dataList = listOf("A", "B", "C", "D", "E")
    items(dataList) { item ->
        ListItem(
            headlineContent = { Text("Item $item") },
            leadingContent = {
                Icon(Icons.Default.Circle, "圆点")
            }
        )
    }

    // 带键的列表项
    items(userList, key = { it.id }) { user ->
        UserListItem(user = user, onUserClick = { /* 处理点击 */ })
    }
}

// 拖拽重排
val state = rememberReorderableLazyListState(onMove = { from, to ->
    items.move(from.index, to.index)
    true
})

LazyColumn(
    state = state.listState,
    modifier = Modifier.reorderable(state)
) {
    itemsIndexed(items, key = { _, item -> item.id }) { index, item ->
        DraggableItem(state) { isDragging ->
            DraggableListItem(
                item = item,
                isDragging = isDragging,
                index = index
            )
        }
    }
}
```

### ↔️ LazyRow 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `contentPadding` | `PaddingValues` | 内容内边距 | `PaddingValues(0.dp)` | ⭐⭐⭐⭐ |
| `reverseLayout` | `Boolean` | 是否反向布局 | `false` | ⭐⭐ |
| `horizontalArrangement` | `Arrangement.Horizontal` | 水平排列方式 | `Arrangement.Start` | ⭐⭐⭐⭐ |
| `verticalAlignment` | `Alignment.Vertical` | 垂直对齐方式 | `Alignment.Top` | ⭐⭐⭐ |
| `flingBehavior` | `FlingBehavior` | 滚动行为 | `ScrollableDefaults.flingBehavior()` | ⭐⭐ |

#### 水平排列选项

| 选项 | 说明 | 使用场景 |
|------|------|----------|
| `Arrangement.Start` | 左对齐 | LTR语言默认 |
| `Arrangement.Center` | 居中对齐 | 特殊布局需求 |
| `Arrangement.End` | 右对齐 | RTL语言默认 |
| `Arrangement.spacedBy()` | 均匀间隔 | 推荐使用 |

#### 代码示例

```kotlin
// 基础LazyRow
LazyRow(
    modifier = Modifier.fillMaxWidth(),
    contentPadding = PaddingValues(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp)
) {
    items(20) { index ->
        Card(
            modifier = Modifier
                .size(120.dp)
                .animateItemPlacement()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Photo,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text("图片 $index", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

// 标签横向滚动
val tags = listOf("Android", "Kotlin", "Compose", "Material3", "Jetpack")

LazyRow(
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(tags) { tag ->
        FilterChip(
            selected = selectedTags.contains(tag),
            onClick = { /* 处理点击 */ },
            label = { Text(tag) },
            modifier = Modifier.animateItemPlacement()
        )
    }
}

// 图片轮播
val images = listOf(image1, image2, image3, image4)

LazyRow(
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    items(images) { image ->
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .animateItemPlacement(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            AsyncImage(
                model = image.url,
                contentDescription = image.description,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
```

### 📱 LazyVerticalGrid 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `columns` | `GridCells` | 列配置 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `contentPadding` | `PaddingValues` | 内容内边距 | `PaddingValues(0.dp)` | ⭐⭐⭐⭐ |
| `horizontalArrangement` | `Arrangement.Horizontal` | 水平排列 | `Arrangement.spacedBy(0.dp)` | ⭐⭐⭐⭐ |
| `verticalArrangement` | `Arrangement.Vertical` | 垂直排列 | `Arrangement.spacedBy(0.dp)` | ⭐⭐⭐⭐ |
| `userScrollEnabled` | `Boolean` | 是否允许用户滚动 | `true` | ⭐⭐⭐ |

#### GridCells 配置选项

| 配置类型 | 说明 | 使用示例 |
|----------|------|----------|
| `GridCells.Fixed(count)` | 固定列数 | `GridCells.Fixed(2)` |
| `GridCells.Adaptive(minSize)` | 自适应列数 | `GridCells.Adaptive(120.dp)` |
| `GridCells.FixedSize(size)` | 固定大小 | `GridCells.FixedSize(100.dp)` |

#### 代码示例

```kotlin
// 固定列数网格
LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(gridItems) { item ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .animateItemPlacement()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// 自适应网格
LazyVerticalGrid(
    columns = GridCells.Adaptive(150.dp),
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(16.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
) {
    items(photos) { photo ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .animateItemPlacement()
        ) {
            AsyncImage(
                model = photo.url,
                contentDescription = photo.description,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

// 带头部的网格
LazyVerticalGrid(
    columns = GridCells.Fixed(3),
    contentPadding = PaddingValues(16.dp)
) {
    // 网格头部
    item(span = { GridItemSpan(3) }) {
        Text(
            text = "图片网格",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }

    // 网格项
    items(15) { index ->
        Card(
            modifier = Modifier
                .aspectRatio(1f)
                .animateItemPlacement()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${index + 1}",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}
```

## 5. 图片组件 (Image Components)

### 🖼️ Image 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `painter` | `Painter` | 图片绘制器 | - | ⭐⭐⭐⭐⭐ |
| `contentDescription` | `String?` | 内容描述 | `null` | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `alignment` | `Alignment` | 对齐方式 | `Alignment.Center` | ⭐⭐⭐ |
| `contentScale` | `ContentScale` | 内容缩放方式 | `ContentScale.Fit` | ⭐⭐⭐⭐ |
| `alpha` | `Float` | 透明度 | `1.0f` | ⭐⭐⭐ |
| `colorFilter` | `ColorFilter?` | 颜色滤镜 | `null` | ⭐⭐ |

#### ContentScale 选项对比

| 选项 | 说明 | 使用场景 |
|------|------|----------|
| `ContentScale.Fit` | 保持比例，完整显示 | 默认情况 |
| `ContentScale.Crop` | 保持比例，填充空间 | 头像、背景图 |
| `ContentScale.FillBounds` | 拉伸填充，可能变形 | 特殊效果 |
| `ContentScale.Inside` | 保持比例，不超出边界 | 安全显示 |
| `ContentScale.None` | 原始大小，不缩放 | 像素级显示 |

#### 代码示例

```kotlin
// 基础Image
Image(
    painter = painterResource(R.drawable.example_image),
    contentDescription = "示例图片",
    modifier = Modifier
        .size(100.dp)
        .clip(RoundedCornerShape(8.dp)),
    contentScale = ContentScale.Crop
)

// 带圆角的头像
Image(
    painter = painterResource(R.drawable.avatar),
    contentDescription = "用户头像",
    modifier = Modifier
        .size(64.dp)
        .clip(CircleShape)
        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
    contentScale = ContentScale.Crop
)

// 带滤镜的图片
Image(
    painter = painterResource(R.drawable.photo),
    contentDescription = "滤镜图片",
    modifier = Modifier.size(200.dp),
    colorFilter = ColorFilter.tint(
        MaterialTheme.colorScheme.primary,
        blendMode = BlendMode.SrcAtop
    ),
    alpha = 0.8f,
    contentScale = ContentScale.Crop
)

// 响应式图片
Image(
    painter = painterResource(R.drawable.banner),
    contentDescription = "横幅图片",
    modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
    contentScale = ContentScale.FillWidth
)
```

### 🌐 AsyncImage 组件 (Coil)

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `model` | `Any?` | 图片数据源 | - | ⭐⭐⭐⭐⭐ |
| `contentDescription` | `String?` | 内容描述 | `null` | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `placeholder` | `Painter?` | 占位符图片 | `null` | ⭐⭐⭐⭐ |
| `error` | `Painter?` | 错误时显示的图片 | `null` | ⭐⭐⭐⭐ |
| `fallback` | `Painter?` | 降级图片 | `null` | ⭐⭐ |
| `onLoading` | `(LoadingState) -> Unit` | 加载中回调 | `null` | ⭐⭐⭐ |
| `onSuccess` | `(SuccessState) -> Unit` | 加载成功回调 | `null` | ⭐⭐ |
| `onError` | `(ErrorState) -> Unit` | 加载失败回调 | `null` | ⭐⭐⭐ |
| `alignment` | `Alignment` | 对齐方式 | `Alignment.Center` | ⭐⭐⭐ |
| `contentScale` | `ContentScale` | 内容缩放方式 | `ContentScale.Fit` | ⭐⭐⭐⭐ |
| `alpha` | `Float` | 透明度 | `DefaultAlpha` | ⭐⭐⭐ |
| `colorFilter` | `ColorFilter?` | 颜色滤镜 | `null` | ⭐⭐ |

#### ImageRequest 配置

| 配置项 | 说明 | 使用示例 |
|--------|------|----------|
| `data()` | 数据源 | `data("https://example.com/image.jpg")` |
| `crossfade()` | 淡入淡出动画 | `crossfade(300)` |
| `placeholder()` | 占位符 | `placeholder(R.drawable.placeholder)` |
| `error()` | 错误图片 | `error(R.drawable.error)` |
| `memoryCachePolicy()` | 内存缓存策略 | `memoryCachePolicy(CachePolicy.ENABLED)` |
| `diskCachePolicy()` | 磁盘缓存策略 | `diskCachePolicy(CachePolicy.ENABLED)` |

#### 代码示例

```kotlin
// 基础网络图片
AsyncImage(
    model = "https://picsum.photos/300/200",
    contentDescription = "网络图片",
    modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(8.dp)),
    contentScale = ContentScale.Crop
)

// 带加载状态的网络图片
AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .crossfade(true)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.error_image)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .build(),
    contentDescription = "网络图片",
    modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(8.dp)),
    contentScale = ContentScale.Crop,
    onLoading = { /* 显示加载状态 */ },
    onSuccess = { /* 加载成功处理 */ },
    onError = { /* 加载失败处理 */ }
)

// 圆形网络头像
AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data(user.avatarUrl)
        .crossfade(true)
        .transformations(CircleCrop())
        .build(),
    contentDescription = "用户头像",
    modifier = Modifier.size(80.dp),
    contentScale = ContentScale.Crop
)

// 带缓存的图片列表
LazyColumn {
    items(imageUrls) { url ->
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = "图片",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }
}
```

### 🎯 Icon 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `imageVector` | `ImageVector` | 矢量图标 | - | ⭐⭐⭐⭐⭐ |
| `contentDescription` | `String?` | 内容描述 | `null` | ⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `tint` | `Color` | 着色 | `Color.Unspecified` | ⭐⭐⭐⭐ |
| `alignment` | `Alignment` | 对齐方式 | `Alignment.Center` | ⭐⭐ |

#### 常用图标库

| 库 | 导入方式 | 说明 |
|-----|----------|------|
| `Icons.Default` | `import androidx.compose.material.icons.Icons` | 默认图标集 |
| `Icons.Filled` | `import androidx.compose.material.icons.filled.*` | 填充风格 |
| `Icons.Outlined` | `import androidx.compose.material.icons.outlined.*` | 轮廓风格 |
| `Icons.Rounded` | `import androidx.compose.material.icons.rounded.*` | 圆角风格 |
| `Icons.Sharp` | `import androidx.compose.material.icons.sharp.*` | 尖锐风格 |

#### 代码示例

```kotlin
// 基础图标
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = "首页",
    modifier = Modifier.size(24.dp),
    tint = MaterialTheme.colorScheme.primary
)

// 不同风格的图标
Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    // 填充风格
    Icon(
        Icons.Filled.Favorite,
        contentDescription = "填充爱心",
        tint = Color.Red
    )

    // 轮廓风格
    Icon(
        Icons.Outlined.Favorite,
        contentDescription = "轮廓爱心",
        tint = Color.Gray
    )

    // 圆角风格
    Icon(
        Icons.Rounded.Favorite,
        contentDescription = "圆角爱心",
        tint = Color.Purple
    )
}

// 自定义大小和颜色的图标
Icon(
    imageVector = Icons.Default.Settings,
    contentDescription = "设置",
    modifier = Modifier.size(32.dp),
    tint = MaterialTheme.colorScheme.onSurfaceVariant
)

// 资源图标
Icon(
    painter = painterResource(R.drawable.custom_icon),
    contentDescription = "自定义图标",
    modifier = Modifier.size(48.dp),
    tint = MaterialTheme.colorScheme.primary
)

// 无障碍图标
Icon(
    imageVector = Icons.Default.Visibility,
    contentDescription = "显示密码",
    modifier = Modifier
        .size(24.dp)
        .clickable { /* 切换显示状态 */ },
    tint = if (passwordVisible)
        MaterialTheme.colorScheme.primary
    else
        MaterialTheme.colorScheme.onSurfaceVariant
)
```

## 6. 对话框组件 (Dialog Components)

### ⚠️ AlertDialog 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `onDismissRequest` | `() -> Unit` | 关闭对话框回调 | - | ⭐⭐⭐⭐⭐ |
| `confirmButton` | `@Composable () -> Unit` | 确认按钮 | `null` | ⭐⭐⭐⭐⭐ |
| `dismissButton` | `@Composable () -> Unit?` | 取消按钮 | `null` | ⭐⭐⭐⭐ |
| `icon` | `@Composable () -> Unit?` | 图标 | `null` | ⭐⭐⭐ |
| `title` | `@Composable () -> Unit?` | 标题 | `null` | ⭐⭐⭐⭐⭐ |
| `text` | `@Composable () -> Unit?` | 内容文本 | `null` | ⭐⭐⭐⭐⭐ |
| `shape` | `Shape` | 对话框形状 | `AlertDialogDefaults.shape` | ⭐⭐⭐ |
| `containerColor` | `Color` | 容器颜色 | `AlertDialogDefaults.containerColor` | ⭐⭐⭐ |
| `iconContentColor` | `Color` | 图标颜色 | `AlertDialogDefaults.iconContentColor` | ⭐⭐ |
| `titleContentColor` | `Color` | 标题颜色 | `AlertDialogDefaults.titleContentColor` | ⭐⭐ |
| `textContentColor` | `Color` | 内容颜色 | `AlertDialogDefaults.textContentColor` | ⭐⭐ |
| `tonalElevation` | `Dp` | 色调高度 | `AlertDialogDefaults.TonalElevation` | ⭐⭐ |

#### 对话框使用场景

| 类型 | 使用场景 | 特点 |
|------|----------|------|
| 确认对话框 | 删除确认、重要操作 | 强制用户确认 |
| 信息对话框 | 提示信息、注意事项 | 单纯信息展示 |
| 选择对话框 | 多选项选择、设置 | 提供选择项 |
| 输入对话框 | 获取用户输入 | 简单表单输入 |

#### 代码示例

```kotlin
// 确认删除对话框
var showDeleteDialog by remember { mutableStateOf(false) }

if (showDeleteDialog) {
    AlertDialog(
        onDismissRequest = { showDeleteDialog = false },
        icon = {
            Icon(
                Icons.Default.Warning,
                contentDescription = "警告",
                tint = MaterialTheme.colorScheme.error
            )
        },
        title = {
            Text("确认删除")
        },
        text = {
            Text("此操作不可恢复，确定要删除这个项目吗？")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    // 执行删除操作
                    showDeleteDialog = false
                }
            ) {
                Text("删除", color = MaterialTheme.colorScheme.error)
            }
        },
        dismissButton = {
            TextButton(onClick = { showDeleteDialog = false }) {
                Text("取消")
            }
        },
        containerColor = MaterialTheme.colorScheme.surface
    )
}

// 信息提示对话框
var showInfoDialog by remember { mutableStateOf(false) }

if (showInfoDialog) {
    AlertDialog(
        onDismissRequest = { showInfoDialog = false },
        icon = {
            Icon(
                Icons.Default.Info,
                contentDescription = "信息",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = {
            Text("版本更新")
        },
        text = {
            Text("发现新版本 v2.1.0，包含性能优化和新功能。")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    showInfoDialog = false
                    // 跳转到更新页面
                }
            ) {
                Text("立即更新")
            }
        },
        dismissButton = {
            TextButton(onClick = { showInfoDialog = false }) {
                Text("稍后提醒")
            }
        }
    )
}
```

### 💬 Dialog 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `onDismissRequest` | `() -> Unit` | 关闭对话框回调 | - | ⭐⭐⭐⭐⭐ |
| `properties` | `DialogProperties` | 对话框属性 | `DialogProperties()` | ⭐⭐ |
| `content` | `@Composable () -> Unit` | 对话框内容 | - | ⭐⭐⭐⭐⭐ |

#### DialogProperties 配置

| 参数名 | 类型 | 功能说明 | 默认值 |
|--------|------|----------|--------|
| `dismissOnBackPress` | `Boolean` | 返回键是否关闭 | `true` |
| `dismissOnClickOutside` | `Boolean` | 点击外部是否关闭 | `true` |
| `securePolicy` | `SecureFlagPolicy` | 安全策略 | `SecureFlagPolicy.Inherit` |
| `usePlatformDefaultWidth` | `Boolean` | 是否使用平台默认宽度 | `false` |

#### 代码示例

```kotlin
// 自定义对话框
var showDialog by remember { mutableStateOf(false) }

if (showDialog) {
    Dialog(
        onDismissRequest = { showDialog = false },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                // 标题
                Text(
                    text = "自定义对话框",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // 内容
                Text(
                    text = "这是一个自定义样式的对话框，可以包含任意内容。",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // 按钮
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showDialog = false }) {
                        Text("取消")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { showDialog = false }) {
                        Text("确定")
                    }
                }
            }
        }
    }
}

// 带输入的对话框
var inputText by remember { mutableStateOf("") }
var showInputDialog by remember { mutableStateOf(false) }

if (showInputDialog) {
    Dialog(onDismissRequest = { showInputDialog = false }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "请输入内容",
                    style = MaterialTheme.typography.titleMedium
                )

                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("输入框") },
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showInputDialog = false }) {
                        Text("取消")
                    }
                    Button(
                        onClick = {
                            // 处理输入内容
                            showInputDialog = false
                        },
                        enabled = inputText.isNotBlank()
                    ) {
                        Text("确定")
                    }
                }
            }
        }
    }
}

// 全屏对话框
var showFullScreenDialog by remember { mutableStateOf(false) }

if (showFullScreenDialog) {
    Dialog(
        onDismissRequest = { showFullScreenDialog = false },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                TopAppBar(
                    title = { Text("全屏对话框") },
                    navigationIcon = {
                        IconButton(onClick = { showFullScreenDialog = false }) {
                            Icon(Icons.Default.Close, "关闭")
                        }
                    }
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(20) { index ->
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "项目 $index",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
```

### 📄 BottomSheet 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `onDismissRequest` | `() -> Unit` | 关闭底表单回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐ |
| `sheetState` | `SheetState` | 底表单状态 | `rememberModalBottomSheetState()` | ⭐⭐⭐ |
| `shape` | `Shape` | 底表单形状 | `ModalBottomSheetDefaults.shape` | ⭐⭐⭐ |
| `containerColor` | `Color` | 容器颜色 | `ModalBottomSheetDefaults.containerColor` | ⭐⭐⭐ |
| `tonalElevation` | `Dp` | 色调高度 | `ModalBottomSheetDefaults.Elevation` | ⭐⭐ |
| `dragHandle` | `@Composable (() -> Unit)?` | 拖拽手柄 | `ModalBottomSheetDefaults.DragHandle()` | ⭐⭐⭐ |
| `windowInsets` | `WindowInsets` | 窗口内边距 | `WindowInsets.systemBars` | ⭐⭐ |
| `content` | `@Composable (ColumnScope.() -> Unit)` | 底表单内容 | - | ⭐⭐⭐⭐⭐ |

#### SheetState 方法

| 方法名 | 功能 | 使用频率 |
|--------|------|----------|
| `show()` | 显示底表单 | ⭐⭐⭐⭐⭐ |
| `hide()` | 隐藏底表单 | ⭐⭐⭐⭐⭐ |
| `partialExpand()` | 部分展开 | ⭐⭐⭐ |
| `expand()` | 完全展开 | ⭐⭐⭐ |
| `currentValue` | 当前状态 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础底表单
val sheetState = rememberModalBottomSheetState()
val scope = rememberCoroutineScope()
var showBottomSheet by remember { mutableStateOf(false) }

if (showBottomSheet) {
    ModalBottomSheet(
        onDismissRequest = { showBottomSheet = false },
        sheetState = sheetState,
        dragHandle = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ModalBottomSheetDefaults.DragHandle()
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "选择操作",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 选项列表
            val options = listOf(
                "编辑" to Icons.Default.Edit,
                "分享" to Icons.Default.Share,
                "删除" to Icons.Default.Delete,
                "复制" to Icons.Default.ContentCopy
            )

            options.forEach { (text, icon) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch { sheetState.hide() }
                            .invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        icon,
                        contentDescription = text,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

// 分享底表单
val shareOptions = listOf(
    "微信" to Icons.Default.Message,
    "朋友圈" to Icons.Default.Share,
    "微博" to Icons.Default.Send,
    "QQ" to Icons.Default.Chat
)

ModalBottomSheet(
    onDismissRequest = { /* 关闭 */ }
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "分享到",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(shareOptions) { (name, icon) ->
                Column(
                    modifier = Modifier.clickable { /* 分享到指定平台 */ },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier.size(56.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                icon,
                                contentDescription = name,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
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

// 带输入的底表单
var noteText by remember { mutableStateOf("") }

ModalBottomSheet(
    onDismissRequest = { /* 关闭 */ }
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "添加备注",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text("备注内容") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 4
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { /* 关闭 */ }) {
                Text("取消")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { /* 保存备注 */ },
                enabled = noteText.isNotBlank()
            ) {
                Text("保存")
            }
        }
    }
}
```

## 7. 导航组件 (Navigation Components)

### 🚂 NavigationRail 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `containerColor` | `Color` | 导航栏容器颜色 | `MaterialTheme.colorScheme.surfaceVariant` | ⭐⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `MaterialTheme.colorScheme.onSurfaceVariant` | ⭐⭐⭐ |
| `header` | `@Composable (() -> Unit)?` | 头部内容 | `null` | ⭐⭐ |
| `windowInsets` | `WindowInsets` | 窗口内边距 | `WindowInsets.systemBars` | ⭐⭐ |

#### NavigationRailItem 参数

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selected` | `Boolean` | 是否选中 | - | ⭐⭐⭐⭐⭐ |
| `onClick` | `() -> Unit` | 点击事件 | - | ⭐⭐⭐⭐⭐ |
| `icon` | `@Composable () -> Unit` | 图标 | `null` | ⭐⭐⭐⭐ |
| `label` | `@Composable () -> Unit?` | 标签 | `null` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `colors` | `NavigationRailItemColors` | 颜色配置 | `NavigationRailItemDefaults.colors()` | ⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础导航栏
var selectedRailIndex by remember { mutableIntStateOf(0) }
val railItems = listOf(
    "首页" to Icons.Default.Home,
    "发现" to Icons.Default.Explore,
    "消息" to Icons.Default.Message,
    "设置" to Icons.Default.Settings
)

Row(modifier = Modifier.fillMaxSize()) {
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        railItems.forEachIndexed { index, (title, icon) ->
            NavigationRailItem(
                icon = { Icon(icon, title) },
                label = { Text(title) },
                selected = selectedRailIndex == index,
                onClick = { selectedRailIndex = index },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }

    // 主要内容区域
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "当前选择: ${railItems[selectedRailIndex].first}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(20) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "内容项目 $index",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

// 带头部的导航栏
NavigationRail(
    modifier = Modifier.fillMaxHeight(),
    header = {
        PaddingValues(vertical = 16.dp) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(64.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "用户头像",
                            modifier = Modifier.size(32.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "用户名称",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
) {
    // 导航项
}
```

### 🧭 NavigationBar 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `containerColor` | `Color` | 导航栏容器颜色 | `MaterialTheme.colorScheme.surface` | ⭐⭐⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `MaterialTheme.colorScheme.onSurface` | ⭐⭐⭐ |
| `tonalElevation` | `Dp` | 色调高度 | `3.dp` | ⭐⭐⭐ |

#### NavigationBarItem 参数

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selected` | `Boolean` | 是否选中 | - | ⭐⭐⭐⭐⭐ |
| `onClick` | `() -> Unit` | 点击事件 | - | ⭐⭐⭐⭐⭐ |
| `icon` | `@Composable () -> Unit` | 图标 | `null` | ⭐⭐⭐⭐ |
| `label` | `@Composable () -> Unit?` | 标签 | `null` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `alwaysShowLabel` | `Boolean` | 是否总是显示标签 | `false` | ⭐⭐ |

#### 代码示例

```kotlin
// 基础底部导航栏
var selectedBottomIndex by remember { mutableIntStateOf(0) }
val bottomItems = listOf(
    "首页" to Icons.Default.Home,
    "搜索" to Icons.Default.Search,
    "消息" to Icons.Default.Message,
    "个人" to Icons.Default.Person
)

NavigationBar(
    modifier = Modifier.fillMaxWidth(),
    containerColor = MaterialTheme.colorScheme.surfaceVariant
) {
    bottomItems.forEachIndexed { index, (title, icon) ->
        NavigationBarItem(
            icon = { Icon(icon, title) },
            label = { Text(title) },
            selected = selectedBottomIndex == index,
            onClick = { selectedBottomIndex = index },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

// 带徽章的导航栏
val unreadCount = mapOf(
    "消息" to 5,
    "通知" to 12
    "任务" to 3
)

NavigationBar(
    modifier = Modifier.fillMaxWidth()
) {
    bottomItems.forEachIndexed { index, (title, icon) ->
        NavigationBarItem(
            icon = {
                if (unreadCount.containsKey(title)) {
                    BadgedBox(
                        badge = {
                            Badge {
                                Text(
                                    text = unreadCount[title].toString(),
                                    modifier = Modifier.align(Alignment.TopEnd)
                                )
                            }
                        }
                    ) {
                        Icon(icon, title)
                    }
                } else {
                    Icon(icon, title)
                }
            },
            label = {
                Text(
                    text = title,
                    modifier = Modifier.offset(
                        x = if (unreadCount.containsKey(title)) (-4).dp else 0.dp
                    )
                )
            },
            selected = selectedBottomIndex == index,
            onClick = { selectedBottomIndex = index }
        )
    }
}
```

### 📑 TabRow 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selectedTabIndex` | `Int` | 当前选中标签索引 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `containerColor` | `Color` | 标签栏容器颜色 | `MaterialTheme.colorScheme.surface` | ⭐⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `MaterialTheme.colorScheme.primary` | ⭐⭐⭐ |
| `divider` | `@Composable (() -> Unit)?` | 分割线 | `null` | ⭐⭐ |

#### Tab 参数

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selected` | `Boolean` | 是否选中 | - | ⭐⭐⭐⭐⭐ |
| `onClick` | `() -> Unit` | 点击事件 | - | ⭐⭐⭐⭐⭐ |
| `text` | `@Composable () -> Unit` | 标签文本 | `null` | ⭐⭐⭐⭐ |
| `icon` | `@Composable () -> Unit?` | 标签图标 | `null` | ⭐⭐⭐ |
| `selectedContentColor` | `Color` | 选中内容颜色 | `LocalContentColor.current` | ⭐⭐ |
| `unselectedContentColor` | `Color` | 未选中内容颜色 | `LocalContentColor.current` | ⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础TabRow
var selectedTabIndex by remember { mutableIntStateOf(0) }
val tabs = listOf("推荐", "热门", "最新", "关注")

Column(modifier = Modifier.fillMaxSize()) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = { Text(title) },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // 内容区域
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        when (selectedTabIndex) {
            0 -> ContentTab(title = "推荐内容")
            1 -> ContentTab(title = "热门内容")
            2 -> ContentTab(title = "最新内容")
            3 -> ContentTab(title = "关注内容")
        }
    }
}

@Composable
private fun ContentTab(title: String) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(15) { index ->
            ListItem(
                headlineContent = { Text("$title 项目 $index") },
                supportingContent = { Text("这是$title 类别的详细描述信息") },
                leadingContent = {
                    Icon(Icons.Default.Circle, null)
                }
            )
            HorizontalDivider()
        }
    }
}

// 可滚动TabRow
val scrollableTabs = listOf(
    "全部", "Android", "iOS", "Flutter", "React Native",
    "Web", "后端", "数据库", "AI", "机器学习",
    "DevOps", "测试", "设计", "产品", "运营"
)

ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    modifier = Modifier.fillMaxWidth()
) {
    scrollableTabs.forEachIndexed { index, title ->
        Tab(
            selected = selectedTabIndex == index,
            onClick = { selectedTabIndex = index },
            text = { Text(title) }
        )
    }
}

// 带图标的TabRow
val iconTabs = listOf(
    "首页" to Icons.Default.Home,
    "搜索" to Icons.Default.Search,
    "通知" to Icons.Default.Notifications,
    "设置" to Icons.Default.Settings
)

TabRow(
    selectedTabIndex = selectedTabIndex
) {
    iconTabs.forEachIndexed { index, (title, icon) ->
        Tab(
            selected = selectedTabIndex == index,
            onClick = { selectedTabIndex = index },
            icon = { Icon(icon, contentDescription = title) },
            text = { Text(title) }
        )
    }
}

// 指示器TabRow
val tabsWithIndicator = listOf("Tab 1", "Tab 2", "Tab 3")
val indicatorWidth = remember { mutableStateOf(0f) }

LaunchedEffect(selectedTabIndex) {
    indicatorWidth.value = 1f / tabsWithIndicator.size
}

TabRow(
    selectedTabIndex = selectedTabIndex,
    divider = {
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    }
) {
    tabsWithIndicator.forEachIndexed { index, title ->
        Tab(
            selected = selectedTabIndex == index,
            onClick = { selectedTabIndex = index },
            text = { Text(title) },
            modifier = Modifier
                .offset(x = index * (indicatorWidth.value * 100.dp))
                .animateItemPlacement()
        )
    }
}
```

## 8. 现代Material 3组件 (Modern Material 3 Components)

### 🔍 SearchBar 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `query` | `String` | 搜索查询文本 | - | ⭐⭐⭐⭐⭐ |
| `onQueryChange` | `(String) -> Unit` | 查询变化回调 | - | ⭐⭐⭐⭐⭐ |
| `onSearch` | `(String) -> Unit` | 搜索执行回调 | - | ⭐⭐⭐⭐⭐ |
| `active` | `Boolean` | 是否激活状态 | `false` | ⭐⭐⭐⭐⭐ |
| `onActiveChange` | `(Boolean) -> Unit` | 激活状态变化回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `placeholder` | `@Composable () -> Unit?` | 占位符 | `null` | ⭐⭐⭐⭐⭐ |
| `leadingIcon` | `@Composable () -> Unit?` | 前置图标 | `null` | ⭐⭐⭐⭐ |
| `trailingIcon` | `@Composable () -> Unit?` | 后置图标 | `null` | ⭐⭐⭐⭐ |
| `shape` | `Shape` | 搜索栏形状 | `SearchBarDefaults.inputFieldShape` | ⭐⭐⭐ |
| `colors` | `SearchBarColors` | 颜色配置 | `SearchBarDefaults.colors()` | ⭐⭐⭐ |
| `tonalElevation` | `Dp` | 色调高度 | `SearchBarDefaults.TonalElevation` | ⭐⭐⭐ |
| `interactionSource` | `MutableInteractionSource?` | 交互源 | `null` | ⭐ |

#### 代码示例

```kotlin
// 基础搜索栏
var searchQuery by remember { mutableStateOf("") }
var isActive by remember { mutableStateOf(false) }
val searchHistory = remember { mutableStateOf(listOf("Android开发", "Kotlin", "Jetpack Compose")) }

SearchBar(
    query = searchQuery,
    onQueryChange = { searchQuery = it },
    onSearch = {
        if (it.isNotBlank()) {
            // 执行搜索逻辑
        }
        isActive = false
    },
    active = isActive,
    onActiveChange = { isActive = it },
    placeholder = { Text("搜索...") },
    leadingIcon = {
        Icon(Icons.Default.Search, "搜索")
    },
    trailingIcon = {
        if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
                Icon(Icons.Default.Clear, "清除")
            }
        }
    },
    modifier = Modifier.fillMaxWidth()
) {
    // 搜索建议/历史
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        if (searchHistory.isNotEmpty()) {
            item {
                Text(
                    text = "搜索历史",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }

        items(searchHistory) { historyItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        searchQuery = historyItem
                        isActive = false
                    }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.History,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = historyItem,
                    style = MaterialTheme.colorScheme.typography.bodyMedium
                )
            }
        }
    }
}

// 带实时搜索的搜索栏
var searchResults by remember { mutableStateOf<List<String>>(emptyList()) }
val scope = rememberCoroutineScope()

SearchBar(
    query = searchQuery,
    onQueryChange = { query ->
        searchQuery = query
        if (query.length > 2) {
            scope.launch {
                delay(300) // 防抖
                searchResults = performSearch(query)
            }
        } else {
            searchResults = emptyList()
        }
    },
    active = isActive,
    onActiveChange = { isActive = it },
    placeholder = { Text("搜索用户或话题") },
    modifier = Modifier.fillMaxWidth()
) {
    if (searchResults.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(searchResults) { result ->
                ListItem(
                    headlineContent = { Text(result) },
                    leadingContent = {
                        Icon(Icons.Default.Person, null)
                    },
                    modifier = Modifier.clickable {
                        searchQuery = result
                        isActive = false
                        // 导航到用户详情页
                    }
                )
            }
        }
    }
}

// 自定义样式的搜索栏
SearchBar(
    query = searchQuery,
    onQueryChange = { searchQuery = it },
    onSearch = { /* 搜索逻辑 */ },
    active = isActive,
    onActiveChange = { isActive = it },
    modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(28.dp)),
    placeholder = { Text("搜索内容...") },
    shape = RoundedCornerShape(28.dp),
    colors = SearchBarDefaults.colors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        dividerColor = MaterialTheme.colorScheme.outline,
        textColor = MaterialTheme.colorScheme.onSurfaceVariant
    )
) {
    // 自定义内容
}
```

### 📱 TopAppBar 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `title` | `@Composable () -> Unit?` | 标题 | `null` | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `navigationIcon` | `@Composable () -> Unit?` | 导航图标 | `null` | ⭐⭐⭐⭐ |
| `actions` | `@Composable RowScope.() -> Unit` | 操作按钮 | `{}` | ⭐⭐⭐⭐ |
| `colors` | `TopAppBarColors` | 颜色配置 | `TopAppBarDefaults.topAppBarColors()` | ⭐⭐⭐ |
| `scrollBehavior` | `TopAppBarScrollBehavior?` | 滚动行为 | `null` | ⭐⭐ |

#### TopAppBar 变体对比

| 类型 | 特点 | 使用场景 |
|------|------|----------|
| `TopAppBar` | 标准应用栏 | 通用应用 |
| `CenterAlignedTopAppBar` | 居中标题 | 特殊设计 |
| `LargeTopAppBar` | 大标题，可折叠 | 详情页面 |
| `MediumTopAppBar` | 中等高度 | 特殊需求 |

#### 代码示例

```kotlin
// 标准TopAppBar
TopAppBar(
    title = { Text("应用标题") },
    navigationIcon = {
        IconButton(onClick = { /* 打开抽屉 */ }) {
            Icon(Icons.Default.Menu, "菜单")
        }
    },
    actions = {
        IconButton(onClick = { /* 搜索 */ }) {
            Icon(Icons.Default.Search, "搜索")
        }
        IconButton(onClick = { /* 更多 */ }) {
            Icon(Icons.Default.MoreVert, "更多")
        }
    },
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
    ),
    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
)

// 带滚动行为的大标题应用栏
val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

LargeTopAppBar(
    title = {
        Text("文章详情")
    },
    scrollBehavior = scrollBehavior
) { paddingValues ->
    // 主要内容
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(100) { index ->
            Text(
                text = "内容项 $index",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

// 中心对齐标题应用栏
CenterAlignedTopAppBar(
    title = { Text("中心标题") },
    navigationIcon = {
        IconButton(onClick = { /* 返回 */ }) {
            Icon(Icons.Default.ArrowBack, "返回")
        }
    },
    actions = {
        IconButton(onClick = { /* 分享 */ }) {
            Icon(Icons.Default.Share, "分享")
        }
    }
)

// 动态应用栏
var title by remember { mutableStateOf("动态标题") }
var hasNotifications by remember { mutableStateOf(true) }

TopAppBar(
    title = { Text(title) },
    navigationIcon = {
        IconButton(onClick = { /* 返回 */ }) {
            Icon(Icons.Default.ArrowBack, "返回")
        }
    },
    actions = {
        if (hasNotifications) {
            IconButton(onClick = { /* 清除通知 */ }) {
                    Icon(Icons.Default.Notifications, "通知")
                }
            }
        IconButton(onClick = { /* 设置 */ }) {
            Icon(Icons.Default.Settings, "设置")
        }
    }
)
```

### 🔄 PullToRefresh 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `state` | `PullToRefreshState` | 刷新状态 | `rememberPullToRefreshState()` | ⭐⭐⭐⭐⭐⭐ |
| `onRefresh` | `() -> Unit` | 刷新回调 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐ |
| `content` | `@Composable () -> Unit` | 内容 | - | ⭐⭐⭐⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `MaterialTheme.colorScheme.onSurface` | ⭐⭐ |
| `scale` | `Float` | 缩放比例 | `1f` | ⭐⭐ |
| `threshold` | `Float` | 刷新阈值 | `DEFAULT_THRESHOLD` | ⭐ |
| `refreshingContentDescription` | `String` | 刷新状态描述 | `null` | ⭐⭐ |
| `positioning` | `PullToRefreshPositioning` | 定位方式 | `PullToRefreshPositioning.Start` | ⭐⭐ |

#### PullToRefreshState 方法

| 方法名 | 功能 | 使用频率 |
|--------|------|----------|
| `startRefresh()` | 开始刷新 | ⭐⭐⭐⭐⭐ |
| `endRefresh()` | 结束刷新 | ⭐⭐⭐⭐ |
| `isRefreshing` | 是否正在刷新 | ⭐⭐⭐⭐⭐ |
| `progress` | 刷新进度 | ⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础下拉刷新
val items = remember { mutableStateOf((1..20).map { "项目 $it" }) }
var isRefreshing by remember { mutableStateOf(false) }
val pullToRefreshState = rememberPullToRefreshState()

if (isRefreshing) {
    LaunchedEffect(true) {
        delay(2000) // 模拟网络请求
        items = (1..20).map { "更新项目 $it" }
        isRefreshing = false
    }
}

Box(
    modifier = Modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "下拉刷新演示",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(items) { item ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier.size(40.dp),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = item,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }

    if (pullToRefreshState.isRefreshing) {
        LaunchedEffect(true) {
            pullToRefreshState.startRefresh()
        }
    }

    PullToRefreshContainer(
        state = pullToRefreshState,
        modifier = Modifier.align(Alignment.TopCenter)
    )
}

// 自定义刷新指示器
PullToRefreshContainer(
    state = pullToRefreshState,
    modifier = Modifier.align(Alignment.TopCenter),
    content = {
        // 自定义刷新动画
        CircularProgressIndicator(
            modifier = Modifier
                .size(24.dp)
                .padding(end = 4.dp),
            strokeWidth = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "正在刷新...",
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }
)

// 带自定义刷新逻辑
val scope = rememberCoroutineScope()

PullToRefreshContainer(
    state = pullToRefreshState,
    onRefresh = {
        scope.launch {
            try {
                // 执行刷新逻辑
                isRefreshing = true
                refreshData()
                isRefreshing = false
            } catch (e: Exception) {
                // 处理错误
                isRefreshing = false
                showError("刷新失败: ${e.message}")
            } finally {
                pullToRefreshState.endRefresh()
            }
        }
    }
) {
    // 内容
}

@Composable
private fun refreshData() {
    // 刷新数据逻辑
}
```

### 🗑️ SwipeToDismiss 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `state` | `DismissState` | 滑动状态 | - | ⭐⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐⭐ |
| `confirmValueChange` | `(DismissValue) -> Boolean` | 确认值变化回调 | `null` | ⭐⭐⭐⭐⭐ |
| `background` | `@Composable () -> Unit` | 背景内容 | `null` | ⭐⭐⭐⭐ |
| `dismissContent` | `@Composable () -> Unit` | 滑动内容 | - | ⭐⭐⭐⭐⭐ |
| `dismissThreshold` | `Dp` | 滑动阈值 | `56.dp` | ⭐⭐ |
| `enableDismissFromEndToEnd` | `Boolean` | 是否允许从右向左滑动 | `false` | ⭐⭐ |
| `enableDismissFromStartToEnd` | `Boolean` | 是否允许从左向右滑动 | `false` | ⭐⭐ |
| `dragHandle` | `@Composable (() -> Unit)?` | 拖拽手柄 | `null` | ⭐⭐ |

#### DismissValue 状态

| 状态 | 说明 | 方向 |
|------|------|------|
| `DismissValue.Default` | 默认状态 | - |
| `DismissValue.DismissedToEnd` | 向右滑动 | → |
| `DismissValue.DismissedToStart` | 向左滑动 | ← |
| `DismissValue.DismissedToStart` | 向右滑动 | ← |

#### 代码示例

```kotlin
// 基础滑动删除
var items by remember { mutableStateOf((1..10).map { "项目 $it" }) }

LazyColumn(
    modifier = Modifier.fillMaxSize().padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(items, key = { it }) { item ->
        var dismissed by remember { mutableStateOf(false) }

        if (!dismissed) {
            SwipeToDismiss(
                state = rememberDismissState(
                    confirmValueChange = { dismissValue ->
                        if (dismissValue == DismissValue.DismissedToEnd ||
                            dismissValue == DismissValue.DismissedToStart) {
                            dismissed = true
                            items = items.filter { it != item }
                            true
                        } else {
                            false
                        }
                    }
                ),
                background = {
                    val color = when (dismissValue.dismissDirection) {
                        DismissDirection.StartToEnd -> Color.Green
                        DismissDirection.EndToStart -> Color.Red
                        null -> Color.Transparent
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "删除",
                            tint = Color.White
                        )
                    }
                },
                dismissContent = {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.size(40.dp),
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        Icons.Default.Swipe,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = item,
                                style = MaterialTheme.colorScheme.typography.titleMedium
                            )
                            IconButton(
                                onClick = { /* 显示更多操作 */ }
                            ) {
                                Icon(Icons.Default.MoreVert, "更多")
                            }
                        }
                    }
                }
            )
        }
    }
}

// 带撤销功能的滑动删除
val coroutineScope = rememberCoroutineScope()

SwipeToDismiss(
    state = rememberDismissState(
        confirmValueChange = { dismissValue ->
            if (dismissValue != DismissValue.Default) {
                // 显示撤销选项
                showUndoSnackbar = true
                coroutineScope.launch {
                    delay(3000) // 等待3秒后自动执行删除
                    if (showUndoSnackbar) {
                        items = items.filter { it != item }
                        showUndoSnackbar = false
                    }
                }
            }
            false
        }
    },
    background = {
        val backgroundColor = when (dismissValue.dismissDirection) {
            DismissDirection.StartToEnd -> MaterialTheme.colorScheme.surfaceVariant
            DismissDirection.EndToStart -> MaterialTheme.colorScheme.surfaceVariant
            null -> Color.Transparent
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "松开删除",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    },
    dismissContent = {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            ListItem(
                headlineContent = { Text(item) },
                supportingContent = { Text("向左或向右滑动删除此项") },
                leadingContent = {
                    Icon(Icons.Default.DragHandle, "拖拽")
                },
                trailingContent = {
                    IconButton(onClick = { /* 更多操作 */ }) {
                        Icon(Icons.Default.MoreVert, "更多")
                    }
                }
            )
        }
    }
}

// 带动画效果的滑动删除
val animatedDismissState = rememberDismissState(
    confirmValueChange = { dismissValue ->
        if (dismissValue != DismissValue.Default) {
            // 添加动画效果
            true
        }
        }
)

SwipeToDismiss(
    state = animatedDismissState,
    modifier = Modifier.animateItemPlacement(),
    background = {
        val backgroundColor = when (animatedDismissState.dismissDirection) {
            DismissDirection.StartToEnd -> MaterialTheme.colorScheme.errorContainer
            DismissDirection.EndToStart -> MaterialTheme.colorScheme.errorContainer
            null -> Color.Transparent
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "删除中...",
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }
    },
    dismissContent = {
        AnimatedVisibility(
            visible = !animatedDismissState.isDismissed(DismissDirection.EndToStart) &&
                     !animatedDismissState.isDismissed(DismissDirection.StartToEnd),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateItemPlacement()
            ) {
                // 卡片内容
            }
        }
    }
)
```

## 9. 特殊组件 (Special Components)

### 📅 DatePicker 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `state` | `DatePickerState` | 日期选择器状态 | `rememberDatePickerState()` | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `dateValidator` | `(Long) -> Boolean` | 日期验证器 | `null` | ⭐⭐⭐ |
| `title` | `(@Composable () -> Unit)?` | 标题 | `null` | ⭐⭐ |
| `headline` | `(@Composable () -> Unit)?` | 头部文本 | `null` | ⭐⭐ |
| `showModeToggle` | `Boolean` | 是否显示模式切换 | `false` | ⭐⭐ |

#### DatePickerState 方法

| 方法名 | 功能 | 使用频率 |
|--------|------|----------|
| `selectedDateMillis` | 获取选中的日期毫秒值 | ⭐⭐⭐⭐⭐ |
| `setSelectedDateMillis()` | 设置选中的日期 | ⭐⭐⭐⭐ |
| `displayedMonth` | 显示的月份 | ⭐⭐⭐ |
| `displayedYear` | 显示的年份 | ⭐⭐⭐ |

#### DatePickerDialog 参数

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `onDismissRequest` | `() -> Unit` | 关闭对话框回调 | - | ⭐⭐⭐⭐⭐ |
| `confirmButton` | `@Composable () -> Unit` | 确认按钮 | - | ⭐⭐⭐⭐⭐ |
| `dismissButton` | `@Composable () -> Unit?` | 取消按钮 | `null` | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础日期选择器
var showDatePicker by remember { mutableStateOf(false) }
var selectedDate by remember { mutableStateOf("2024年1月1日") }
val datePickerState = rememberDatePickerState()

if (showDatePicker) {
    DatePickerDialog(
        onDismissRequest = { showDatePicker = false },
        confirmButton = {
            TextButton(
                onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        val calendar = java.util.Calendar.getInstance()
                        calendar.timeInMillis = millis
                        selectedDate = "${calendar.get(java.util.Calendar.YEAR)}年${calendar.get(java.util.Calendar.MONTH) + 1}月${calendar.get(java.util.Calendar.DAY_OF_MONTH)}日"
                    }
                    showDatePicker = false
                }
            ) {
                Text("确定")
            }
        },
        dismissButton = {
            TextButton(onClick = { showDatePicker = false }) {
                Text("取消")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

// 带日期验证的日期选择器
val datePickerWithValidation = rememberDatePickerState(
    initialSelectedDateMillis = System.currentTimeMillis(),
    selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            val calendar = java.util.Calendar.getInstance()
            calendar.timeInMillis = utcTimeMillis
            val year = calendar.get(java.util.Calendar.YEAR)
            val month = calendar.get(java.util.Calendar.MONTH)
            val day = calendar.get(java.util.Calendar.DAY_OF_MONTH)

            // 只允许选择2024年的日期，且排除周末
            return year == 2024 &&
                   calendar.get(java.util.Calendar.DAY_OF_WEEK) != java.util.Calendar.SATURDAY &&
                   calendar.get(java.util.Calendar.DAY_OF_WEEK) != java.util.Calendar.SUNDAY
        }

        override fun isSelectableYear(year: Int): Boolean {
            return year == 2024
        }
    }
)

// 自定义样式的日期选择器
DatePickerDialog(
    onDismissRequest = { /* 关闭 */ },
    confirmButton = {
        TextButton(onClick = { /* 确认选择 */ }) {
            Text("确认", color = MaterialTheme.colorScheme.primary)
        }
    },
    dismissButton = {
        TextButton(onClick = { /* 取消 */ }) {
            Text("取消")
        }
    }
) {
    DatePicker(
        state = datePickerWithValidation,
        title = {
            Text(
                text = "选择预约日期",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        },
        headline = {
            Text(
                text = "可选工作日",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        },
        showModeToggle = true
    )
}
```

### ⏰ TimePicker 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `state` | `TimePickerState` | 时间选择器状态 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `layoutType` | `TimePickerLayoutType` | 布局类型 | `TimePickerLayoutType.Vertical` | ⭐⭐⭐ |

#### TimePickerState 方法

| 方法名 | 功能 | 使用频率 |
|--------|------|----------|
| `hour` | 当前小时(0-23) | ⭐⭐⭐⭐⭐ |
| `minute` | 当前分钟(0-59) | ⭐⭐⭐⭐⭐ |
| `is24hour` | 是否24小时制 | ⭐⭐⭐ |

#### TimePickerLayoutType 选项

| 选项 | 说明 | 使用场景 |
|------|------|----------|
| `Vertical` | 垂直滚轮布局 | 默认布局，移动端推荐 |
| `Horizontal` | 水平表盘布局 | 平板或大屏设备 |

#### 代码示例

```kotlin
// 基础时间选择器
var showTimePicker by remember { mutableStateOf(false) }
var selectedTime by remember { mutableStateOf("12:00") }
val timePickerState = rememberTimePickerState(
    initialHour = 12,
    initialMinute = 0,
    is24Hour = true
)

if (showTimePicker) {
    Dialog(onDismissRequest = { showTimePicker = false }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "选择时间",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                TimePicker(state = timePickerState)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showTimePicker = false }) {
                        Text("取消")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(
                        onClick = {
                            selectedTime = "${timePickerState.hour}:${timePickerState.minute.toString().padStart(2, '0')}"
                            showTimePicker = false
                        }
                    ) {
                        Text("确定")
                    }
                }
            }
        }
    }
}

// 12小时制时间选择器
val timePicker12Hour = rememberTimePickerState(
    initialHour = 3,
    initialMinute = 30,
    is24Hour = false
)

Dialog(onDismissRequest = { /* 关闭 */ }) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "选择上午/下午时间",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            TimePicker(
                state = timePicker12Hour,
                layoutType = TimePickerLayoutType.Horizontal
            )
        }
    }
}

// 带时间验证的时间选择器
val timeValidationState = rememberTimePickerState()
val isValidTime = remember {
    derivedStateOf {
        val hour = timeValidationState.hour
        val minute = timeValidationState.minute
        // 只允许选择9:00-18:00的工作时间
        hour in 9..17 || (hour == 18 && minute == 0)
    }
}

Column {
    Text(
        text = "选择工作时间",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    if (!isValidTime.value) {
        Text(
            text = "请选择9:00-18:00之间的时间",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }

    TimePicker(state = timeValidationState)

    Button(
        onClick = { /* 确认时间 */ },
        enabled = isValidTime.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text("确认预约")
    }
}
```

### 🏷️ Badge 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `containerColor` | `Color` | 容器颜色 | `MaterialTheme.colorScheme.error` | ⭐⭐⭐ |
| `contentColor` | `Color` | 内容颜色 | `MaterialTheme.colorScheme.onError` | ⭐⭐⭐ |
| `content` | `@Composable () -> Unit` | 徽章内容 | - | ⭐⭐⭐⭐ |

#### BadgedBox 参数

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `badge` | `@Composable () -> Unit` | 徽章内容 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `content` | `@Composable () -> Unit` | 主要内容 | - | ⭐⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 数字徽章
BadgedBox(
    badge = {
        Badge {
            Text("5")
        }
    }
) {
    Icon(
        Icons.Default.Notifications,
        contentDescription = "通知",
        modifier = Modifier.size(32.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}

// 点徽章
BadgedBox(
    badge = {
        Badge(
            modifier = Modifier
                .size(8.dp)
                .background(
                    color = MaterialTheme.colorScheme.error,
                    shape = CircleShape
                )
        )
    }
) {
    Icon(
        Icons.Default.Mail,
        contentDescription = "邮件",
        modifier = Modifier.size(32.dp)
    )
}

// 大数字徽章
BadgedBox(
    badge = {
        Badge {
            Text(
                text = "99+",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
) {
    Icon(
        Icons.Default.Message,
        contentDescription = "消息",
        modifier = Modifier.size(32.dp)
    )
}

// 自定义样式徽章
BadgedBox(
    badge = {
        Badge(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Text(
                text = "新",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
            )
        }
    }
) {
    Text(
        text = "文章标题",
        style = MaterialTheme.typography.titleMedium
    )
}

// 带动画的徽章
var badgeCount by remember { mutableStateOf(0) }

LaunchedEffect(Unit) {
    delay(1000)
    badgeCount = 3
}

BadgedBox(
    badge = {
        if (badgeCount > 0) {
            Badge(
                modifier = Modifier.animateContentSize()
            ) {
                Text(
                    text = if (badgeCount > 99) "99+" else badgeCount.toString(),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
) {
    IconButton(onClick = { badgeCount = 0 }) {
        Icon(
            Icons.Default.ShoppingCart,
            contentDescription = "购物车",
            modifier = Modifier.size(32.dp)
        )
    }
}

// 状态徽章
Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    // 在线状态
    BadgedBox(
        badge = {
            Badge(
                containerColor = Color.Green,
                modifier = Modifier.size(8.dp)
            ) {}
        }
    ) {
        Text("在线")
    }

    // 离线状态
    BadgedBox(
        badge = {
            Badge(
                containerColor = Color.Gray,
                modifier = Modifier.size(8.dp)
            ) {}
        }
    ) {
        Text("离线")
    }

    // 忙碌状态
    BadgedBox(
        badge = {
            Badge(
                containerColor = Color.Red,
                modifier = Modifier.size(8.dp)
            ) {}
        }
    ) {
        Text("忙碌")
    }
}
```

### 🏷️ Chip 组件

#### API 参数详解

| 参数名 | 类型 | 功能说明 | 默认值 | 使用频率 |
|--------|------|----------|--------|----------|
| `selected` | `Boolean` | 是否选中 | `false` | ⭐⭐⭐⭐⭐ |
| `onClick` | `() -> Unit` | 点击事件 | - | ⭐⭐⭐⭐⭐ |
| `label` | `@Composable () -> Unit` | 标签内容 | - | ⭐⭐⭐⭐⭐ |
| `modifier` | `Modifier` | 修饰符 | `Modifier` | ⭐⭐⭐⭐ |
| `enabled` | `Boolean` | 是否启用 | `true` | ⭐⭐⭐⭐ |
| `leadingIcon` | `@Composable () -> Unit?` | 前置图标 | `null` | ⭐⭐⭐ |
| `trailingIcon` | `@Composable () -> Unit?` | 后置图标 | `null` | ⭐⭐⭐ |
| `shape` | `Shape` | 形状 | `FilterChipDefaults.shape` | ⭐⭐ |
| `colors` | `ChipColors` | 颜色配置 | `FilterChipDefaults.filterChipColors()` | ⭐⭐⭐ |
| `border` | `BorderStroke?` | 边框 | `FilterChipDefaults.border` | ⭐⭐ |

#### Chip 类型对比

| 类型 | 使用场景 | 特点 |
|------|----------|------|
| `FilterChip` | 筛选、过滤 | 可选中/取消选中 |
| `InputChip` | 输入标签 | 可删除 |
| `SuggestionChip` | 建议选项 | 不可选中，点击执行操作 |
| `AssistChip` | 辅助操作 | 不可选中，带图标 |

#### 代码示例

```kotlin
// 可选择的FilterChip
val chips = listOf(
    "Android", "Kotlin", "Jetpack Compose", "Material Design",
    "MVVM", "Coroutines", "Flow", "Hilt"
)
var selectedChips by remember { mutableStateOf(setOf<String>()) }

Column(
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    Text(
        text = "选择技术栈",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    LazyColumn(
        modifier = Modifier.height(200.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(chips) { chip ->
            FilterChip(
                selected = selectedChips.contains(chip),
                onClick = {
                    selectedChips = if (selectedChips.contains(chip)) {
                        selectedChips - chip
                    } else {
                        selectedChips + chip
                    }
                },
                label = { Text(chip) },
                leadingIcon = if (selectedChips.contains(chip)) {
                    {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "已选中",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                } else null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    Text(
        text = "已选择: ${selectedChips.joinToString(", ")}",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

// 带图标的InputChip
val skills = listOf(
    "Android开发" to Icons.Default.Android,
    "Kotlin编程" to Icons.Default.Code,
    "UI设计" to Icons.Default.Palette
)
var selectedSkills by remember { mutableStateOf(setOf<String>()) }

LazyRow(
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(skills) { (skill, icon) ->
        InputChip(
            selected = selectedSkills.contains(skill),
            onClick = {
                selectedSkills = if (selectedSkills.contains(skill)) {
                    selectedSkills - skill
                } else {
                    selectedSkills + skill
                }
            },
            label = { Text(skill) },
            leadingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "移除",
                    modifier = Modifier.size(16.dp)
                )
            },
            selectedIconColor = MaterialTheme.colorScheme.primary
        )
    }
}

// SuggestionChip建议标签
val suggestions = listOf("了解更多", "查看文档", "下载示例", "联系支持")

LazyRow(
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(suggestions) { suggestion ->
        SuggestionChip(
            onClick = {
                // 执行建议的操作
            },
            label = { Text(suggestion) },
            icon = {
                Icon(
                    Icons.Default.Lightbulb,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        )
    }
}

// AssistChip辅助操作
AssistChip(
    onClick = {
        // 执行辅助操作，如分享、帮助等
    },
    label = { Text("获取帮助") },
    leadingIcon = {
        Icon(
            Icons.Default.Help,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    },
    colors = AssistChipDefaults.assistChipColors(
        leadingIconContentColor = MaterialTheme.colorScheme.primary
    )
)

// 自定义样式的Chip
FilterChip(
    selected = isSelected,
    onClick = { isSelected = !isSelected },
    label = { Text("高级选项") },
    leadingIcon = {
        Icon(
            Icons.Default.Settings,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    },
    shape = RoundedCornerShape(20.dp),
    colors = FilterChipDefaults.filterChipColors(
        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
        selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
    ),
    border = BorderStroke(
        1.dp,
        if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.outline
    )
)
```

### 🌊 StaggeredGrid 瀑布流组件

#### 概述

瀑布流布局是一种特殊的网格布局，其中项目具有不同的高度，以不规则的方式排列，形成类似瀑布的效果。在当前项目中使用LazyColumn实现了简化版的瀑布流。

#### 实现方式

由于LazyVerticalStaggeredGrid在某些Compose版本中可能不可用，项目中使用LazyColumn配合动态高度的Card来实现瀑布流效果。

#### 代码示例

```kotlin
// 简化版瀑布流实现（使用LazyColumn）
@Composable
fun StaggeredGridDemo() {
    val items = (1..20).map { index ->
        StaggeredItem(
            id = index,
            title = "卡片 $index",
            description = "这是第 $index 个卡片项目，具有不同的高度来展示瀑布流效果",
            height = (80..160).random()
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "瀑布流演示",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(items) { item ->
            StaggeredGridCard(item = item)
        }
    }
}

// 瀑布流卡片组件
@Composable
private fun StaggeredGridCard(item: StaggeredItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // 顶部颜色条
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = when (item.id % 5) {
                    0 -> MaterialTheme.colorScheme.primary
                    1 -> MaterialTheme.colorScheme.secondary
                    2 -> MaterialTheme.colorScheme.tertiary
                    3 -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.surfaceVariant
                },
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            // 图标
            Icon(
                imageVector = when (item.id % 5) {
                    0 -> Icons.Default.Star
                    1 -> Icons.Default.Favorite
                    2 -> Icons.Default.ThumbUp
                    3 -> Icons.Default.Bookmark
                    else -> Icons.Default.Info
                },
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = when (item.id % 5) {
                    0 -> MaterialTheme.colorScheme.primary
                    1 -> MaterialTheme.colorScheme.secondary
                    2 -> MaterialTheme.colorScheme.tertiary
                    3 -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 标题
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 描述
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = if (item.height > 120) 3 else 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// 真实的瀑布流实现（使用LazyVerticalStaggeredGrid - 如果可用）
@Composable
fun RealStaggeredGrid() {
    val items = (1..50).map { index ->
        StaggeredItem(
            id = index,
            title = "瀑布流项目 $index",
            description = "这是一个随机高度的瀑布流项目",
            height = (100..250).random()
        )
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(item.height.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    // 渐变色背景
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.secondary
                                    )
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Photo,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // 底部操作按钮
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { /* 点赞 */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                Icons.Default.FavoriteBorder,
                                contentDescription = "点赞",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        IconButton(
                            onClick = { /* 分享 */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                Icons.Default.Share,
                                contentDescription = "分享",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        IconButton(
                            onClick = { /* 收藏 */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                Icons.Default.BookmarkBorder,
                                contentDescription = "收藏",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// 双列瀑布流实现
@Composable
fun DualColumnStaggeredGrid() {
    val items = (1..30).map { index ->
        StaggeredItem(
            id = index,
            title = "双列项目 $index",
            description = "双列瀑布流布局的项目",
            imageUrl = "https://picsum.photos/150/${100 + index * 10}",
            height = (120..220).random()
        )
    }

    // 分割数据到两列
    val leftColumnItems = items.filterIndexed { index, _ -> index % 2 == 0 }
    val rightColumnItems = items.filterIndexed { index, _ -> index % 2 == 1 }

    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 左列
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(leftColumnItems) { item ->
                StaggeredGridCardWithImage(item = item)
            }
        }

        // 右列
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(rightColumnItems) { item ->
                StaggeredGridCardWithImage(item = item)
            }
        }
    }
}

@Composable
private fun StaggeredGridCardWithImage(item: StaggeredItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            // 图片区域
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(item.height.dp * 0.6f)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                AsyncImage(
                    model = "https://picsum.photos/300/${200 + item.id * 5}",
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // 文本区域
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

// 数据模型
data class StaggeredItem(
    val id: Int,
    val title: String,
    val description: String,
    val height: Int
)
```

---

## 10. Modifier API 详解 (Modifier API Reference)

Modifier是Compose中用于装饰和修改Composable组件的核心概念。它是一个有序的、不可变的集合，用于添加布局、绘制、行为、焦点、语义、无障碍和平台特定等修饰。

### 📋 基础概念

#### Modifier 的工作原理

| 特性 | 说明 |
|------|------|
| **有序性** | Modifier按顺序应用，后面的修饰会覆盖前面的 |
| **不可变性** | 每个Modifier操作都返回新的Modifier实例 |
| **链式调用** | 支持流畅的链式调用语法 |
| **组合性** | 可以组合多个不同类型的修饰 |

#### Modifier 类型分类

| 类型 | 功能 | 常用方法 |
|------|------|----------|
| **布局修饰符** | 尺寸、位置、排列 | `size`, `width`, `height`, `padding`, `fillMaxWidth` |
| **绘制修饰符** | 背景、边框、阴影 | `background`, `border`, `shadow` |
| **行为修饰符** | 点击、滚动、拖拽 | `clickable`, `scrollable`, `draggable` |
| **焦点修饰符** | 键盘导航、焦点状态 | `focusable`, `focusRequester` |
| **图形修饰符** | 旋转、缩放、裁剪 | `rotate`, `scale`, `clip` |
| **无障碍修饰符** | 语义、内容描述 | `semantics`, `clearAndSetSemantics` |

### 📏 尺寸与布局修饰符

#### 基础尺寸修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `size(width, height)` | Dp | 设置固定宽度和高度 | ⭐⭐⭐⭐ |
| `size(size)` | Dp | 设置正方形尺寸 | ⭐⭐⭐ |
| `width(width)` | Dp | 设置固定宽度 | ⭐⭐⭐⭐ |
| `height(height)` | Dp | 设置固定高度 | ⭐⭐⭐⭐ |
| `fillMaxWidth(fraction)` | Float | 填充最大宽度 | ⭐⭐⭐⭐⭐ |
| `fillMaxHeight(fraction)` | Float | 填充最大高度 | ⭐⭐⭐⭐ |
| `fillMaxSize(fraction)` | Float | 填充最大尺寸 | ⭐⭐⭐⭐⭐ |
| `wrapContentWidth()` | - | 包裹内容宽度 | ⭐⭐⭐ |
| `wrapContentHeight()` | - | 包裹内容高度 | ⭐⭐⭐ |

#### 内边距修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `padding(all)` | Dp | 四周内边距 | ⭐⭐⭐⭐⭐ |
| `padding(horizontal, vertical)` | Dp | 水平和垂直内边距 | ⭐⭐⭐⭐⭐ |
| `padding(start, top, end, bottom)` | Dp | 各方向独立内边距 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础尺寸设置
Box(
    modifier = Modifier
        .size(100.dp)           // 100dp x 100dp
        .background(Color.Blue)
)

// 响应式尺寸
Column(
    modifier = Modifier
        .fillMaxWidth()         // 填充父容器宽度
        .height(200.dp)         // 固定高度
) {
    Text(
        text = "响应式文本",
        modifier = Modifier
            .fillMaxWidth(0.8f) // 80%的父容器宽度
            .padding(16.dp)    // 四周16dp内边距
    )
}
```

### 🎨 绘制与视觉修饰符

#### 背景修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `background(color, shape)` | Color, Shape | 设置背景颜色和形状 | ⭐⭐⭐⭐⭐ |
| `background(brush, shape, alpha)` | Brush, Shape, Float | 设置背景渐变和形状 | ⭐⭐⭐ |

#### 边框修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `border(width, color, shape)` | Dp, Color, Shape | 设置边框 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础背景和边框
Card(
    modifier = Modifier
        .fillMaxWidth()
        .background(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(12.dp)
        )
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp)
        )
        .padding(16.dp)
) {
    Text("带边框的卡片")
}

// 渐变背景
Box(
    modifier = Modifier
        .size(200.dp)
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                )
            ),
            shape = CircleShape
        )
) {
    Text(
        text = "渐变圆形",
        modifier = Modifier.align(Alignment.Center),
        color = Color.White
    )
}
```

### 🖱️ 交互与行为修饰符

#### 点击和手势修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `clickable(onClick, enabled, role, indication, interactionSource)` | 函数, Boolean, Role, Indication, InteractionSource | 点击交互 | ⭐⭐⭐⭐⭐ |
| `combinedClickable(onClick, onLongClick, onDoubleClick)` | 函数, 函数, 函数 | 组合点击事件 | ⭐⭐⭐⭐ |
| `toggleable(value, onValueChange, enabled, role, interactionSource)` | Boolean, 函数, Boolean, Role, InteractionSource | 切换状态 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 基础点击交互
var clickCount by remember { mutableStateOf(0) }

Card(
    modifier = Modifier
        .fillMaxWidth()
        .clickable {
            clickCount++
        }
        .background(
            if (clickCount > 0)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surface
        )
        .padding(16.dp)
) {
    Text("点击次数: $clickCount")
}

// 组合点击事件
var message by remember { mutableStateOf("等待操作") }

Box(
    modifier = Modifier
        .size(100.dp)
        .background(MaterialTheme.colorScheme.primary, CircleShape)
        .combinedClickable(
            onClick = { message = "单击" },
            onLongClick = { message = "长按" },
            onDoubleClick = { message = "双击" }
        ),
    contentAlignment = Alignment.Center
) {
    Text(
        text = message,
        color = Color.White,
        style = MaterialTheme.typography.bodySmall
    )
}
```

### 🔄 图形变换修饰符

#### 变换修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `rotate(degrees)` | Float | 旋转角度 | ⭐⭐⭐ |
| `scale(scaleX, scaleY)` | Float, Float | 缩放比例 | ⭐⭐⭐ |
| `translate(x, y)` | Int, Int | 平移偏移 | ⭐⭐ |
| `clip(shape)` | Shape | 裁剪形状 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 旋转动画
var rotation by remember { mutableStateOf(0f) }

LaunchedEffect(Unit) {
    while (true) {
        delay(16)
        rotation = (rotation + 1f) % 360f
    }
}

Icon(
    Icons.Default.Refresh,
    contentDescription = "旋转图标",
    modifier = Modifier
        .size(48.dp)
        .rotate(rotation)
        .clickable { /* 重置旋转 */ }
)

// 缩放效果
var scale by remember { mutableStateOf(1f) }

Card(
    modifier = Modifier
        .size(100.dp)
        .scale(scale)
        .clickable {
            scale = if (scale == 1f) 1.2f else 1f
        }
        .background(MaterialTheme.colorScheme.primary)
) {
    // 内容
}

// 裁剪效果
Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    // 圆形裁剪
    Image(
        painter = painterResource(R.drawable.avatar),
        contentDescription = "头像",
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
    )
}
```

### 🎯 焦点与无障碍修饰符

#### 焦点修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `focusable(enabled)` | Boolean | 是否可以获得焦点 | ⭐⭐⭐ |
| `focusRequester(focusRequester)` | FocusRequester | 请求焦点 | ⭐⭐⭐⭐ |
| `onFocus(event, onFocusEvent)` | FocusState, 函数 | 焦点状态变化 | ⭐⭐⭐ |

#### 无障碍修饰符

| 修饰符 | 类型 | 功能说明 | 使用频率 |
|--------|------|----------|----------|
| `semantics(mergeDescendants, properties)` | Boolean, SemanticsPropertyReceiver | 添加语义属性 | ⭐⭐⭐⭐ |
| `contentDescription(content)` | String | 内容描述 | ⭐⭐⭐⭐⭐ |
| `testTag(tag)` | String | 测试标签 | ⭐⭐⭐⭐ |

#### 代码示例

```kotlin
// 焦点管理
val focusRequester = remember { FocusRequester() }
var isFocused by remember { mutableStateOf(false) }

TextField(
    value = text,
    onValueChange = { text = it },
    modifier = Modifier
        .fillMaxWidth()
        .focusRequester(focusRequester)
        .onFocusChanged { focusState ->
            isFocused = focusState.isFocused
        }
        .background(
            if (isFocused)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surface,
            RoundedCornerShape(8.dp)
        ),
    placeholder = { Text("点击获得焦点") }
)

// 无障碍支持
Button(
    onClick = { /* 执行操作 */ },
    modifier = Modifier
        .semantics {
            contentDescription = "提交表单"
            role = Role.Button
            stateDescription = if (isLoading) "正在加载" else "可以提交"
        }
        .testTag("submit_button")
) {
    Text("提交")
}
```

### 🧪 实用修饰符组合

#### 常用修饰符组合

```kotlin
// 卡片修饰符组合
fun Modifier.cardModifier(
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    borderColor: Color = Color.Transparent,
    cornerRadius: Dp = 12.dp,
    elevation: Dp = 4.dp
) = this
    .fillMaxWidth()
    .background(backgroundColor, RoundedCornerShape(cornerRadius))
    .border(1.dp, borderColor, RoundedCornerShape(cornerRadius))
    .shadow(elevation, RoundedCornerShape(cornerRadius))
    .padding(16.dp)

// 按钮修饰符组合
fun Modifier.primaryButtonModifier(
    enabled: Boolean = true,
    isLoading: Boolean = false
) = this
    .fillMaxWidth()
    .height(48.dp)
    .background(
        if (enabled && !isLoading)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        RoundedCornerShape(8.dp)
    )
    .clickable(enabled = enabled && !isLoading) { /* 处理点击 */ }
    .padding(horizontal = 24.dp)

// 使用示例
Card(
    modifier = Modifier.cardModifier(
        borderColor = MaterialTheme.colorScheme.primary
    )
) {
    Text("这是使用修饰符组合的卡片")
}

Button(
    onClick = { /* 处理点击 */ },
    modifier = Modifier.primaryButtonModifier(
        enabled = true,
        isLoading = false
    )
) {
    Text("主要操作按钮")
}
```

### 📊 Modifier 最佳实践

#### 使用原则

1. **顺序很重要**：修饰符按顺序应用，要注意顺序对最终效果的影响
2. **组合使用**：将相关修饰符组合成可重用的函数
3. **性能考虑**：避免在重组中创建新的修饰符实例
4. **无障碍优先**：始终考虑无障碍支持，添加适当的语义

#### 常见模式

```kotlin
// ✅ 好的实践
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .semantics { contentDescription = text }
    ) {
        Text(text)
    }
}

// ✅ 修饰符组合
@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            content = content
        )
    }
}

// ❌ 避免的做法
@Composable
fun BadExample() {
    // 在重组中创建新的修饰符
    Box(
        modifier = Modifier
            .size(
                if (someCondition) 100.dp else 200.dp // 每次重组都会创建新的SizeModifier
            )
    ) {
        // 内容
    }
}

// ✅ 正确的做法
@Composable
fun GoodExample() {
    val size = if (someCondition) 100.dp else 200.dp
    Box(
        modifier = Modifier
            .size(size) // 使用预先计算的值
    ) {
        // 内容
    }
}
```


## 📊 项目结构

```
app/src/main/java/com/hong/compose/test/
├── app/
│   └── MainApp.kt                    # 主应用入口
├── components/
│   ├── basic/                        # 基础组件
│   │   ├── TextComponents.kt
│   │   ├── ButtonComponents.kt
│   │   ├── TextFieldComponents.kt
│   │   └── FABComponents.kt
│   ├── layout/                       # 布局组件
│   │   └── LayoutComponents.kt
│   ├── input/                        # 输入组件
│   │   └── InputComponents.kt
│   ├── list/                         # 列表组件
│   │   └── ListComponents.kt
│   ├── image/                        # 图片组件
│   │   └── ImageComponents.kt
│   ├── dialog/                       # 对话框组件
│   │   └── DialogComponents.kt
│   ├── navigation/                   # 导航组件
│   │   └── NavigationComponents.kt
│   ├── modern/                       # 现代组件
│   │   └── ModernComponents.kt
│   └── special/                      # 特殊组件
│       └── SpecialComponents.kt
├── Material3DemoScreen.kt            # 主演示页面
├── Screen.kt                         # 路由定义
├── NavigationBar.kt                  # 底部导航
├── HomeScreen.kt                     # 首页
├── SearchScreen.kt                   # 搜索页
├── MessageScreen.kt                  # 消息页
└── MineScreen.kt                     # 个人页
```

## 🚀 运行项目

### 环境要求
- **Android Studio** - Arctic Fox 或更高版本
- **Kotlin** - 1.7.0 或更高版本
- **Gradle** - 7.0 或更高版本
- **最低 SDK** - API 24 (Android 7.0)
- **目标 SDK** - API 34 (Android 14)

### 安装步骤
1. 克隆项目到本地
```bash
git clone [项目地址]
cd compose_test
```

2. 同步项目依赖
```bash
./gradlew build
```

3. 运行应用
```bash
./gradlew installDebug
```

---

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进这个项目！

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

---

*最后更新: 2024年12月*