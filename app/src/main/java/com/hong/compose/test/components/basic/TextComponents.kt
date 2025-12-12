package com.hong.compose.test.components.basic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hong.compose.test.ui.theme.Compose_testTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Text 组件演示",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // 基础文本样式
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "基础文本样式",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "默认文本样式 (bodyLarge)")
                Text(
                    text = "标题样式 (headlineSmall)",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "副标题样式 (titleMedium)",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "标签样式 (labelMedium)",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        // 字体样式
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "字体样式",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "粗体文本",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "斜体文本",
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "下划线文本",
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "删除线文本",
                    textDecoration = TextDecoration.LineThrough
                )
                Text(
                    text = "自定义字体大小",
                    fontSize = 20.sp
                )
                Text(
                    text = "自定义字体族",
                    fontFamily = FontFamily.Serif
                )
            }
        }

        // 文本对齐
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "文本对齐",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "左对齐文本",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "居中对齐文本",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "右对齐文本",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }

        // 文本颜色
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "文本颜色",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "主要颜色文本",
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "次要颜色文本",
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "错误颜色文本",
                    color = MaterialTheme.colorScheme.error
                )
                Text(
                    text = "成功颜色文本",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // 文本溢出
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "文本溢出处理",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "这是一段很长的文本，如果超出容器宽度会如何显示？",
                    modifier = Modifier.width(200.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Text(
                    text = "这是一段很长的文本，使用省略号处理溢出...",
                    modifier = Modifier.width(200.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "这是一段很长的文本，如果超出容器宽度会如何显示？",
                    modifier = Modifier.width(200.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // 多行文本
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "多行文本",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = """这是第一行
这是第二行
这是第三行""",
                    lineHeight = 24.sp
                )
            }
        }

        // 动态文本
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "动态文本",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                var counter by remember { mutableIntStateOf(0) }

                Text(
                    text = "点击次数: $counter",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Button(
                    onClick = { counter++ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("增加计数")
                }
            }
        }
    }
}

// 1. 基本预览
@Preview(showBackground = true, name = "按钮演示 - 默认",
    device = "spec:width=1080px,height=3940px,dpi=440"
)
@Composable
fun TextDemoPreview() {
    Compose_testTheme {
        TextDemo()
    }
}