package com.hong.compose.test.components.basic

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
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hong.compose.test.ui.theme.Compose_testTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonDemo() {
    var clickCount by remember { mutableIntStateOf(0) }
    var isToggleOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Button 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "点击次数: $clickCount",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // 基础按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "基础按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("主要按钮")
                    }

                    OutlinedButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("轮廓按钮")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("文本按钮")
                    }

                    ElevatedButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("凸起按钮")
                    }
                }
            }
        }

        // 带图标的按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "带图标的按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "添加",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("添加")
                    }

                    OutlinedButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "编辑",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("编辑")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "分享",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("分享")
                    }

                    ElevatedButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "下载",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("下载")
                    }
                }
            }
        }

        // 仅图标的按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "仅图标的按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { clickCount++ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "喜欢",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }

                    IconButton(onClick = { clickCount++ }) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "收藏",
                            tint = Color.Yellow
                        )
                    }

                    IconButton(onClick = { clickCount++ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "通知",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    IconButton(onClick = { clickCount++ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "设置"
                        )
                    }
                }
            }
        }

        // 不同状态的按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同状态的按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { clickCount++ },
                    enabled = true,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("启用状态")
                }

                Button(
                    onClick = { /* 禁用状态下无法点击 */ },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("禁用状态")
                }

                // 切换按钮
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilterChip(
                        onClick = { isToggleOn = !isToggleOn },
                        label = { Text("切换状态") },
                        selected = isToggleOn
                    )
                }
            }
        }

        // 不同颜色的按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同颜色的按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("默认按钮")
                    }

                    Button(
                        onClick = { clickCount++ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("次要按钮")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { clickCount++ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("错误按钮")
                    }

                    Button(
                        onClick = { clickCount++ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("第三按钮")
                    }
                }
            }
        }

        // 不同尺寸的按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "不同尺寸的按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { clickCount++ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("全宽按钮")
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { clickCount++ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("中等按钮")
                    }

                    Button(
                        onClick = { clickCount++ },
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text("小按钮")
                    }
                }
            }
        }

        // 分割按钮
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "分割按钮",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                // 手动实现分割按钮效果
                Row {
                    Button(
                        onClick = { clickCount++ },
                        shape = MaterialTheme.shapes.small.copy(
                            topEnd = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("操作")
                    }

                    Button(
                        onClick = { /* 显示选项 */ },
                        shape = MaterialTheme.shapes.small.copy(
                            topStart = ZeroCornerSize,
                            bottomStart = ZeroCornerSize
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "下拉"
                        )
                    }
                }
            }
        }
    }
}


// 1. 基本预览
@Preview(showBackground = true, name = "按钮演示 - 默认",
    device = "spec:width=1080px,height=3840px,dpi=440"
)
@Composable
fun ButtonDemoPreview() {
    Compose_testTheme {
        ButtonDemo()
    }
}
