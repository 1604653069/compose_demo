package com.hong.compose.test.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3DemoScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Material 3 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "基础显示组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getBasicDisplayComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("basic_display/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "布局和容器组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getLayoutComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("layout/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "选择和输入组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getInputComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("input/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "列表组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getListComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("list/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "图像组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getImageComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("image/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "对话框和弹窗",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getDialogComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("dialog/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "导航组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getNavigationComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("navigation/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Material Design 3 新潮组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getModernComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("modern/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "特殊功能组件",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(getSpecialComponents()) { component ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("special/${component.route}")
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = component.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = component.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

data class ComponentItem(
    val name: String,
    val description: String,
    val route: String
)

fun getBasicDisplayComponents() = listOf(
    ComponentItem("Text - 文本显示", "各种样式的文本组件", "text"),
    ComponentItem("Button - 按钮", "各种类型的按钮组件", "button"),
    ComponentItem("TextField - 文本输入框", "文本输入和编辑组件", "textfield"),
    ComponentItem("FloatingActionButton - 悬浮按钮", "圆形悬浮操作按钮", "fab")
)

fun getLayoutComponents() = listOf(
    ComponentItem("Card - 卡片", "带阴影和圆角的容器组件", "card"),
    ComponentItem("Surface - 表面", "可设置背景和高度的容器", "surface"),
    ComponentItem("Scaffold - 脚手架", "包含应用基本结构的布局", "scaffold")
)

fun getInputComponents() = listOf(
    ComponentItem("Checkbox - 复选框", "多选框组件", "checkbox"),
    ComponentItem("RadioButton - 单选按钮", "单选框组件", "radiobutton"),
    ComponentItem("Switch - 开关", "滑动开关组件", "switch"),
    ComponentItem("Slider - 滑块", "范围选择滑块", "slider"),
    ComponentItem("ProgressBar - 进度条", "线性进度指示器", "progressbar"),
    ComponentItem("CircularProgressIndicator - 圆形进度条", "圆形进度指示器", "circularprogress")
)

fun getListComponents() = listOf(
    ComponentItem("List - 列表", "基础列表组件", "list"),
    ComponentItem("LazyColumn - 垂直懒加载列表", "垂直滚动的懒加载列表", "lazycolumn"),
    ComponentItem("LazyRow - 水平懒加载列表", "水平滚动的懒加载列表", "lazyrow"),
    ComponentItem("LazyVerticalGrid - 垂直网格", "垂直滚动的网格布局", "lazyverticalgrid")
)

fun getImageComponents() = listOf(
    ComponentItem("Image - 图片显示", "本地和网络图片显示", "image"),
    ComponentItem("AsyncImage - 异步图片", "使用Coil库异步加载图片", "asyncimage"),
    ComponentItem("Icon - 图标", "Material Design图标", "icon")
)

fun getDialogComponents() = listOf(
    ComponentItem("AlertDialog - 警告对话框", "确认和警告对话框", "alertdialog"),
    ComponentItem("Dialog - 通用对话框", "自定义对话框容器", "dialog"),
    ComponentItem("BottomSheet - 底部弹窗", "从底部滑出的面板", "bottomsheet"),
    ComponentItem("ModalBottomSheet - 模态底部弹窗", "模态底部弹窗", "modalbottomsheet")
)

fun getNavigationComponents() = listOf(
    ComponentItem("Navigation Rail - 导航栏", "侧边导航栏", "navigationrail"),
    ComponentItem("Bottom Navigation - 底部导航", "底部导航栏", "bottomnavigation"),
    ComponentItem("TabRow - 标签页", "固定标签页", "tabrow"),
    ComponentItem("ScrollableTabRow - 可滚动标签页", "可滚动的标签页", "scrollabletabrow")
)

fun getModernComponents() = listOf(
    ComponentItem("NavigationDrawer - 导航抽屉", "侧边抽屉导航", "navigationdrawer"),
    ComponentItem("SearchBar - 搜索栏", "Material 3搜索组件", "searchbar"),
    ComponentItem("TopAppBar - 顶部应用栏", "应用顶部栏", "topappbar"),
    ComponentItem("PullToRefresh - 下拉刷新", "下拉刷新手势", "pulltorefresh"),
    ComponentItem("SwipeToDismiss - 滑动删除", "滑动删除手势", "swipetodismiss")
)

fun getSpecialComponents() = listOf(
    ComponentItem("DatePicker - 日期选择器", "日期选择对话框", "datepicker"),
    ComponentItem("TimePicker - 时间选择器", "时间选择对话框", "timepicker"),
    ComponentItem("Badge - 徽章", "数量标记徽章", "badge"),
    ComponentItem("Chip - 芯片标签", "可选择的标签组件", "chip"),
    ComponentItem("LazyVerticalStaggeredGrid - 瀑布流", "不等高的瀑布流布局", "staggeredgrid")
)