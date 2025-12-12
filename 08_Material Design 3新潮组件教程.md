# Jetpack Compose Material Design 3 新潮组件完全指南

## 前言

Material Design 3 引入了许多现代化的组件和设计理念，为开发者提供了更加丰富和灵活的 UI 组件选择。这些新潮组件不仅视觉上更加美观，在交互体验上也更加人性化。本文将详细介绍 Material Design 3 中的新潮组件，包括 SearchBar、DatePicker、TimePicker、Badge、Chip 等，帮助你构建现代化的用户界面。

---

## 1. SearchBar - 搜索栏组件

SearchBar 是 Material Design 3 中新增的搜索组件，提供了更加优雅的搜索体验。

### 1.1 基础 SearchBar

```kotlin
@Composable
fun BasicSearchBarExample() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var searchHistory by remember { mutableStateOf(listOf("Android开发", "Kotlin", "Jetpack Compose", "Material Design")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { /* 执行搜索 */ },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text("搜索内容...")
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "搜索")
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { query = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "清除")
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // 搜索历史和建议
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                item {
                    Text(
                        text = "搜索历史",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                items(searchHistory) { historyItem ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                query = historyItem
                                active = false
                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.History,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = historyItem,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 搜索结果展示
        if (query.isNotEmpty()) {
            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "搜索结果",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    repeat(5) { index ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.size(40.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${index + 1}",
                                        style = MaterialTheme.typography.titleSmall,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "关于 \"$query\" 的结果 ${index + 1}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "这是搜索结果的具体描述信息...",
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
}
```

### 1.2 带实时搜索的 SearchBar

```kotlin
@Composable
fun RealTimeSearchBarExample() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var searchResults by remember { mutableStateOf<List<SearchResult>>(emptyList()) }

    // 模拟实时搜索
    LaunchedEffect(query) {
        if (query.isNotEmpty()) {
            delay(300) // 模拟网络延迟
            searchResults = generateSearchResults(query)
        } else {
            searchResults = emptyList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { /* 执行搜索 */ },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text("搜索应用、游戏、电影...")
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "搜索")
            },
            trailingIcon = {
                Row {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { query = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "清除")
                        }
                    }
                    IconButton(onClick = { /* 语音搜索 */ }) {
                        Icon(Icons.Default.Mic, contentDescription = "语音搜索")
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // 搜索建议
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (searchResults.isNotEmpty()) {
                    item {
                        Text(
                            text = "搜索建议",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    items(searchResults) { result ->
                        SearchResultItem(
                            result = result,
                            onSelect = {
                                query = result.title
                                active = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 热门搜索
        if (!active) {
            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "热门搜索",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(getHotSearchTerms()) { term ->
                            FilterChip(
                                onClick = {
                                    query = term
                                    active = true
                                },
                                label = { Text(term) },
                                selected = false
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchResultItem(
    result: SearchResult,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = result.icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = result.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = result.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// 数据类
data class SearchResult(
    val title: String,
    val description: String,
    val icon: ImageVector
)

private fun generateSearchResults(query: String): List<SearchResult> {
    val icons = listOf(
        Icons.Default.Android,
        Icons.Default.Computer,
        Icons.Default.Phone,
        Icons.Default.Tablet,
        Icons.Default.Watch
    )

    return (1..5).map { index ->
        SearchResult(
            title = "$query 结果 $index",
            description = "与 $query 相关的第 $index 个搜索结果",
            icon = icons[index % icons.size]
        )
    }
}

private fun getHotSearchTerms(): List<String> {
    return listOf(
        "Jetpack Compose",
        "Kotlin协程",
        "Material Design 3",
        "Android 14",
        "Flutter vs Compose",
        "MVVM架构",
        "Room数据库",
        "Retrofit网络"
    )
}
```

---

## 2. DatePicker - 日期选择器

DatePicker 是 Material Design 3 中重新设计的日期选择组件，提供了更加直观的日期选择体验。

### 2.1 基础 DatePicker

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicDatePickerExample() {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("未选择日期") }
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "选择的日期",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedDate,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Button(
                        onClick = { showDatePicker = true }
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("选择日期")
                    }
                }
            }
        }

        // 日期选择器对话框
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
                DatePicker(
                    state = datePickerState,
                    title = {
                        Text(
                            text = "选择日期",
                            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 24.dp)
                        )
                    },
                    headline = {
                        Text(
                            text = "请选择您想要的日期",
                            modifier = Modifier.padding(start = 24.dp, top = 8.dp, end = 24.dp)
                        )
                    }
                )
            }
        }

        // 日期选择器特性
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "DatePicker 特性",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val features = listOf(
                    "• Material 3 日期选择器设计",
                    "• 支持日期范围选择",
                    "• 自定义日期格式",
                    "• 内置本地化支持",
                    "• 触摸友好的界面",
                    "• 支持日期验证"
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
}
```

### 2.2 日期范围选择器

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerExample() {
    var showDateRangePicker by remember { mutableStateOf(false) }
    var selectedRange by remember { mutableStateOf("未选择日期范围") }
    val dateRangePickerState = rememberDateRangePickerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "日期范围选择",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = selectedRange,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                Button(
                    onClick = { showDateRangePicker = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("选择日期范围")
                }
            }
        }

        // 日期范围选择器对话框
        if (showDateRangePicker) {
            DatePickerDialog(
                onDismissRequest = { showDateRangePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            dateRangePickerState.selectedStartDateMillis?.let { startMillis ->
                                dateRangePickerState.selectedEndDateMillis?.let { endMillis ->
                                    val startCalendar = java.util.Calendar.getInstance()
                                    startCalendar.timeInMillis = startMillis

                                    val endCalendar = java.util.Calendar.getInstance()
                                    endCalendar.timeInMillis = endMillis

                                    selectedRange = "${startCalendar.get(java.util.Calendar.YEAR)}年${startCalendar.get(java.util.Calendar.MONTH) + 1}月${startCalendar.get(java.util.Calendar.DAY_OF_MONTH)}日 - " +
                                              "${endCalendar.get(java.util.Calendar.YEAR)}年${endCalendar.get(java.util.Calendar.MONTH) + 1}月${endCalendar.get(java.util.Calendar.DAY_OF_MONTH)}日"
                                }
                            }
                            showDateRangePicker = false
                        }
                    ) {
                        Text("确定")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDateRangePicker = false }) {
                        Text("取消")
                    }
                }
            ) {
                DateRangePicker(
                    state = dateRangePickerState,
                    title = {
                        Text(
                            text = "选择日期范围",
                            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 24.dp)
                        )
                    }
                )
            }
        }

        // 快速选择选项
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "快速选择",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val quickRanges = listOf(
                    "今天" to 0,
                    "昨天" to -1,
                    "最近7天" to -7,
                    "最近30天" to -30
                )

                quickRanges.forEach { (label, days) ->
                    OutlinedButton(
                        onClick = {
                            val calendar = java.util.Calendar.getInstance()
                            calendar.add(java.util.Calendar.DAY_OF_MONTH, days)
                            selectedRange = if (days == 0) {
                                "今天"
                            } else {
                                val today = java.util.Calendar.getInstance()
                                val startDate = today.clone() as java.util.Calendar
                                startDate.add(java.util.Calendar.DAY_OF_MONTH, days)
                                "${startDate.get(java.util.Calendar.YEAR)}年${startDate.get(java.util.Calendar.MONTH) + 1}月${startDate.get(java.util.Calendar.DAY_OF_MONTH)}日 - " +
                                "${today.get(java.util.Calendar.YEAR)}年${today.get(java.util.Calendar.MONTH) + 1}月${today.get(java.util.Calendar.DAY_OF_MONTH)}日"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(label)
                    }
                }
            }
        }
    }
}
```

---

## 3. TimePicker - 时间选择器

TimePicker 是 Material Design 3 中重新设计的时间选择组件，提供了 12/24 小时制支持。

### 3.1 基础 TimePicker

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTimePickerExample() {
    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("12:00") }
    var is24Hour by remember { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState(is24Hour = is24Hour)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "时间选择",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedTime,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Button(
                        onClick = { showTimePicker = true }
                    ) {
                        Icon(
                            Icons.Default.Schedule,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("选择时间")
                    }
                }

                // 时间制式切换
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "24小时制",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = is24Hour,
                        onCheckedChange = { is24Hour = it }
                    )
                }
            }
        }

        // 时间选择器对话框
        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onConfirm = {
                    selectedTime = "${timePickerState.hour.toString().padStart(2, '0')}:${timePickerState.minute.toString().padStart(2, '0')}"
                    showTimePicker = false
                },
                timePickerState = timePickerState,
                is24Hour = is24Hour
            )
        }

        // 预设时间
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "快速选择",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                val presetTimes = listOf(
                    "09:00" to "上班时间",
                    "12:00" to "午餐时间",
                    "18:00" to "下班时间",
                    "22:00" to "睡眠时间"
                )

                presetTimes.forEach { (time, label) ->
                    OutlinedButton(
                        onClick = {
                            selectedTime = time
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(time)
                            Text(
                                text = label,
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
private fun TimePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    timePickerState: TimePickerState,
    is24Hour: Boolean
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "选择时间",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                TimePicker(
                    state = timePickerState,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text("取消")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = onConfirm) {
                        Text("确定")
                    }
                }
            }
        }
    }
}
```

---

## 4. Badge - 徽章组件

Badge 是用于显示状态、数量或指示器的小型组件，常用于通知和状态显示。

### 4.1 不同类型的 Badge

```kotlin
@Composable
fun BadgeTypesExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Badge 类型示例",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 数字徽章
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "数字徽章",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Triple(1, "1", "单数"),
                        Triple(5, "5", "小数"),
                        Triple(99, "99", "大数"),
                        Triple(999, "999+", "超大")
                    ).forEach { (count, display, label) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            BadgedBox(
                                badge = {
                                    Badge {
                                        Text(display, style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Notifications,
                                    contentDescription = "通知",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                            Text(
                                text = label,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        // 点徽章
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "点徽章",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Pair(Icons.Default.Mail, "邮件"),
                        Pair(Icons.Default.Message, "消息"),
                        Pair(Icons.Default.Phone, "电话"),
                        Pair(Icons.Default.Favorite, "收藏")
                    ).forEach { (icon, label) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            BadgedBox(
                                badge = {
                                    Badge()
                                }
                            ) {
                                Icon(
                                    icon,
                                    contentDescription = label,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                            Text(
                                text = label,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        // 自定义颜色徽章
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "自定义颜色徽章",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Triple(MaterialTheme.colorScheme.primary, "主要", 3),
                        Triple(MaterialTheme.colorScheme.secondary, "次要", 12),
                        Triple(MaterialTheme.colorScheme.error, "错误", 1),
                        Triple(MaterialTheme.colorScheme.tertiary, "第三", 8)
                    ).forEach { (color, label, count) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            BadgedBox(
                                badge = {
                                    Badge(
                                        containerColor = color
                                    ) {
                                        Text(
                                            text = count.toString(),
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.ShoppingCart,
                                    contentDescription = label,
                                    modifier = Modifier.size(32.dp),
                                    tint = color
                                )
                            }
                            Text(
                                text = label,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        // 实际应用示例
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "应用示例",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // 模拟导航栏
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BadgedBox(
                            badge = {
                                Badge { Text("5") }
                            }
                        ) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "首页",
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        BadgedBox(
                            badge = {
                                Badge { Text("12") }
                            }
                        ) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "搜索",
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        BadgedBox(
                            badge = {
                                Badge()
                            }
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "添加",
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        BadgedBox(
                            badge = {
                                Badge { Text("99+") }
                            }
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "个人",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
```

---

## 5. Chip - 芯片组件

Chip 是用于显示选择项、筛选条件或标签的组件，在 Material Design 3 中提供了更加丰富的类型。

### 5.1 不同类型的 Chip

```kotlin
@Composable
fun ChipTypesExample() {
    val techChips = listOf(
        "Android", "Kotlin", "Jetpack Compose", "Material Design",
        "MVVM", "Coroutines", "Flow", "Hilt", "Room", "Retrofit"
    )
    val selectedChips = remember { mutableStateOf(setOf<String>()) }
    var singleSelection by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Chip 类型示例",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // FilterChip - 多选
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "FilterChip (多选)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "已选择: ${selectedChips.value.joinToString(", ")}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    techChips.take(6).forEach { chip ->
                        FilterChip(
                            selected = selectedChips.value.contains(chip),
                            onClick = {
                                selectedChips.value = if (selectedChips.value.contains(chip)) {
                                    selectedChips.value - chip
                                } else {
                                    selectedChips.value + chip
                                }
                            },
                            label = { Text(chip) },
                            leadingIcon = if (selectedChips.value.contains(chip)) {
                                {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "已选择",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            } else null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        // InputChip - 输入标签
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "InputChip (输入标签)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "可点击的操作标签",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(
                        "添加到收藏" to Icons.Default.Favorite,
                        "分享" to Icons.Default.Share,
                        "编辑" to Icons.Default.Edit,
                        "删除" to Icons.Default.Delete
                    ).forEach { (label, icon) ->
                        InputChip(
                            selected = false,
                            onClick = { /* 处理点击 */ },
                            label = { Text(label, style = MaterialTheme.typography.labelSmall) },
                            icon = {
                                Icon(
                                    icon,
                                    contentDescription = label,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        )
                    }
                }
            }
        }

        // SuggestionChip - 建议标签
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "SuggestionChip (建议标签)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "搜索建议和推荐",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(techChips.takeLast(5)) { chip ->
                        SuggestionChip(
                            onClick = { /* 处理点击 */ },
                            label = { Text(chip, style = MaterialTheme.typography.labelSmall) }
                        )
                    }
                }
            }
        }

        // AssistChip - 辅助标签
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "AssistChip (辅助标签)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "辅助操作按钮",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AssistChip(
                        onClick = { /* 处理点击 */ },
                        label = { Text("获取帮助") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Help,
                                contentDescription = "帮助",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )

                    AssistChip(
                        onClick = { /* 处理点击 */ },
                        label = { Text("查看详情") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Info,
                                contentDescription = "详情",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )

                    AssistChip(
                        onClick = { /* 处理点击 */ },
                        label = { Text("反馈") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Feedback,
                                contentDescription = "反馈",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )
                }
            }
        }
    }
}
```

---

## 6. StaggeredGrid - 瀑布流布局

StaggeredGrid 是一种瀑布流布局，适合展示不同高度的卡片内容，如图片墙或动态内容流。

### 6.1 基础瀑布流

```kotlin
@Composable
fun StaggeredGridExample() {
    val items = remember {
        (1..20).map { index ->
            StaggeredItem(
                id = index,
                title = "卡片 $index",
                description = "这是第 $index 个瀑布流卡片项目的内容描述",
                height = (80..200).random(),
                color = when (index % 5) {
                    0 -> MaterialTheme.colorScheme.primary
                    1 -> MaterialTheme.colorScheme.secondary
                    2 -> MaterialTheme.colorScheme.tertiary
                    3 -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.surfaceVariant
                },
                icon = when (index % 5) {
                    0 -> Icons.Default.Star
                    1 -> Icons.Default.Favorite
                    2 -> Icons.Default.ThumbUp
                    3 -> Icons.Default.Bookmark
                    else -> Icons.Default.Info
                }
            )
        }
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items) { item ->
            StaggeredGridCard(item = item)
        }
    }
}

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
                color = item.color,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            // 图标
            Surface(
                modifier = Modifier.size(36.dp),
                shape = CircleShape,
                color = item.color.copy(alpha = 0.1f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = item.color
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 标题
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 描述
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = if (item.height > 120) 3 else 2
            )

            Spacer(modifier = Modifier.weight(1f))

            // 底部操作
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "喜欢",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "分享",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "更多",
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// 瀑布流项目数据类
data class StaggeredItem(
    val id: Int,
    val title: String,
    val description: String,
    val height: Int,
    val color: Color,
    val icon: ImageVector
)
```

---

## 7. 实践示例：完整的现代化界面

```kotlin
@Composable
fun ModernUIShowcase() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    var selectedChips by remember { mutableStateOf(setOf<String>()) }

    val tabs = listOf("发现", "创作", "消息")
    val techTags = listOf("Compose", "Kotlin", "Material", "Android", "Flutter", "React")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("现代化 UI 展示") },
                navigationIcon = {
                    IconButton(onClick = { /* 导航 */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "菜单")
                    }
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge { Text("3") }
                        }
                    ) {
                        IconButton(onClick = { /* 通知 */ }) {
                            Icon(Icons.Default.Notifications, contentDescription = "通知")
                        }
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        icon = {
                            when (index) {
                                0 -> Icon(Icons.Default.Explore, contentDescription = tab)
                                1 -> Icon(Icons.Default.Create, contentDescription = tab)
                                else -> Icon(Icons.Default.Message, contentDescription = tab)
                            }
                        },
                        label = { Text(tab) },
                        selected = selectedTab == index,
                        onClick = { selectedTab = index }
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 搜索栏
            item {
                var query by remember { mutableStateOf("") }
                var active by remember { mutableStateOf(false) }

                SearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = { /* 搜索 */ },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text("搜索内容...") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "搜索")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {}
            }

            // 日期选择器
            item {
                Card {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "计划日期",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = selectedDate.ifEmpty { "点击选择日期" },
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Button(
                            onClick = { showDatePicker = true }
                        ) {
                            Icon(Icons.Default.DateRange, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("选择")
                        }
                    }
                }
            }

            // 标签选择
            item {
                Card {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "技术标签",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(techTags) { tag ->
                                FilterChip(
                                    selected = selectedChips.contains(tag),
                                    onClick = {
                                        selectedChips = if (selectedChips.contains(tag)) {
                                            selectedChips - tag
                                        } else {
                                            selectedChips + tag
                                        }
                                    },
                                    label = { Text(tag) },
                                    leadingIcon = if (selectedChips.contains(tag)) {
                                        {
                                            Icon(
                                                Icons.Default.Check,
                                                contentDescription = "已选择",
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    } else null
                                )
                            }
                        }

                        if (selectedChips.isNotEmpty()) {
                            Text(
                                text = "已选择: ${selectedChips.joinToString(", ")}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // 瀑布流内容
            item {
                Text(
                    text = "精彩内容",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // 瀑布流卡片
            item {
                val items = remember {
                    (1..6).map { index ->
                        StaggeredItem(
                            id = index,
                            title = "精彩内容 $index",
                            description = "这是一个精彩的内容描述，展示了现代化的设计理念。",
                            height = (100..180).random(),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            icon = Icons.Default.Star
                        )
                    }
                }

                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items) { item ->
                        StaggeredGridCard(item = item)
                    }
                }
            }
        }
    }

    // 日期选择器对话框
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()

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
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
```

---

## 8. 最佳实践

### 8.1 组件选择原则

1. **SearchBar**：需要搜索功能和搜索建议时使用
2. **DatePicker/TimePicker**：日期和时间输入的标准化选择
3. **Badge**：用于状态指示、数量显示和通知
4. **Chip**：标签、筛选和快速操作
5. **StaggeredGrid**：不规则内容展示

### 8.2 设计一致性

1. **遵循 Material Design 3 规范**
2. **保持颜色和样式的一致性**
3. **合理的间距和布局**
4. **适当的使用动画效果**

### 8.3 用户体验优化

1. **提供清晰的视觉反馈**
2. **支持无障碍访问**
3. **响应式设计适配**
4. **合理的加载状态**

---

## 9. 总结

Material Design 3 的新潮组件为 Jetpack Compose 应用提供了现代化的 UI 解决方案：

1. **SearchBar**：优雅的搜索体验
2. **DatePicker/TimePicker**：标准化的日期时间选择
3. **Badge**：灵活的状态指示器
4. **Chip**：多样化的标签组件
5. **StaggeredGrid**：瀑布流布局支持

通过合理使用这些组件，你可以构建符合 Material Design 3 规范的现代化用户界面。

在最后一篇文章中，我们将探讨特殊功能组件，学习一些高级的组件使用技巧。

---

## 相关资源

- [Material 3 Components Documentation](https://m3.material.io/components)
- [Compose Material 3 Documentation](https://developer.android.com/jetpack/compose/material3)
- [Material Design Guidelines](https://m3.material.io/)

---

*本文基于 Android Jetpack Compose 最新版本编写，部分 API 可能会随着版本更新而变化。*