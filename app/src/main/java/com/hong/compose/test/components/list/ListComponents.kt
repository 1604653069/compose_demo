package com.hong.compose.test.components.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDemo() {
    val items = (1..20).map { "列表项目 $it" }
    val listState = rememberLazyListState()
    var firstVisibleIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(listState.firstVisibleItemIndex) {
        firstVisibleIndex = listState.firstVisibleItemIndex
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "List 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "当前可见项目索引: $firstVisibleIndex",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                ListItem(
                    headlineContent = { Text(item) },
                    supportingContent = { Text("这是item的支持内容") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "详情"
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnDemo() {
    val items = generatePersonList()
    val listState = rememberLazyListState()
    var isScrolling by remember { mutableStateOf(false) }

    LaunchedEffect(listState.isScrollInProgress) {
        isScrolling = listState.isScrollInProgress
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "LazyColumn 组件演示",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            if (isScrolling) {
                Text(
                    text = "滚动中...",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        text = "头部 - 共${items.size}个项目",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            items(items) { person ->
                PersonListItem(person = person)
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Text(
                        text = "底部 - 列表结束",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyRowDemo() {
    val categories = listOf(
        "推荐", "热门", "最新", "免费", "付费",
        "游戏", "教育", "工具", "娱乐", "生活"
    )

    var currentCategory by remember { mutableStateOf("推荐") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "LazyRow 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    onClick = {
                        currentCategory = category
                    },
                    label = { Text(category) },
                    selected = category == currentCategory
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "图片列表",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(10) { index ->
                ImageCard(index = index)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyVerticalGridDemo() {
    val products = generateProductList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "LazyVerticalGrid 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PersonListItem(person: Person) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(48.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = person.name.first().toString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = person.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = person.role,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = if (expanded) "收起" else "展开"
                )
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = person.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = person.email,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = person.phone,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ImageCard(index: Int) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(160.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = "图片",
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Text(
                text = "图片 $index",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.small
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = product.icon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "¥${product.price}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun HorizontalDivider() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}

private fun generatePersonList(): List<Person> {
    return listOf(
        Person(
            name = "张三",
            role = "Android 开发工程师",
            email = "zhangsan@example.com",
            phone = "13800138000",
            description = "专注于Android应用开发，有5年开发经验，熟悉Jetpack Compose和Kotlin。"
        ),
        Person(
            name = "李四",
            role = "UI/UX 设计师",
            email = "lisi@example.com",
            phone = "13900139000",
            description = "专业的移动应用界面设计师，擅长Material Design和用户体验设计。"
        ),
        Person(
            name = "王五",
            role = "产品经理",
            email = "wangwu@example.com",
            phone = "13700137000",
            description = "负责产品规划和需求分析，有丰富的项目管理经验。"
        ),
        Person(
            name = "赵六",
            role = "后端开发工程师",
            email = "zhaoliu@example.com",
            phone = "13600136000",
            description = "专注于服务器端开发，熟悉微服务架构和云原生技术。"
        ),
        Person(
            name = "钱七",
            role = "测试工程师",
            email = "qianqi@example.com",
            phone = "13500135000",
            description = "负责产品质量保证，擅长自动化测试和性能测试。"
        ),
        Person(
            name = "孙八",
            role = "DevOps 工程师",
            email = "sunba@example.com",
            phone = "13400134000",
            description = "负责持续集成和部署，精通Docker和Kubernetes。"
        ),
        Person(
            name = "周九",
            role = "数据分析师",
            email = "zhoujiu@example.com",
            phone = "13300133000",
            description = "专注于数据挖掘和分析，熟悉机器学习算法。"
        ),
        Person(
            name = "吴十",
            role = "前端开发工程师",
            email = "wushi@example.com",
            phone = "13200132000",
            description = "专注于Web前端开发，熟悉React和Vue框架。"
        )
    )
}

private fun generateProductList(): List<Product> {
    val icons = listOf(
        Icons.Default.Phone,
        Icons.Default.Laptop,
        Icons.Default.Headphones,
        Icons.Default.Camera,
        Icons.Default.Watch,
        Icons.Default.Tablet,
        Icons.Default.Smartphone,
        Icons.Default.Computer,
        Icons.Default.Devices,
        Icons.Default.DevicesOther
    )

    return listOf(
        Product("智能手机", "最新款5G手机，拍照效果出色", 2999, icons[0]),
        Product("笔记本电脑", "轻薄便携，性能强劲", 5999, icons[1]),
        Product("无线耳机", "降噪功能，音质清晰", 899, icons[2]),
        Product("数码相机", "专业摄影，高清画质", 4599, icons[3]),
        Product("智能手表", "健康监测，运动追踪", 1299, icons[4]),
        Product("平板电脑", "大屏幕，适合阅读", 2499, icons[5]),
        Product("蓝牙音箱", "便携式，音质出众", 399, icons[6]),
        Product("机械键盘", "游戏专用，手感舒适", 799, icons[7]),
        Product("游戏鼠标", "精准定位，RGB背光", 299, icons[8]),
        Product("路由器", "高速WiFi，信号稳定", 199, icons[9]),
        Product("移动硬盘", "大容量，传输快速", 599, icons[0]),
        Product("显示器", "4K分辨率，色彩准确", 1899, icons[1])
    )
}

private data class Person(
    val name: String,
    val role: String,
    val email: String,
    val phone: String,
    val description: String
)

private data class Product(
    val name: String,
    val description: String,
    val price: Int,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)