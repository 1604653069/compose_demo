package com.hong.compose.test.ui.theme

import androidx.compose.ui.graphics.Color

// ==================== 原有iOS风格颜色（保留）====================

// iOS风格的主题色彩 - 蓝色系为主，优雅简洁
// 浅色模式主题色
val iOSBlue = Color(0xFF007AFF)           // iOS标准蓝
val iOSBlueLight = Color(0xFF5AC8FA)      // iOS浅蓝
val iOSBackground = Color(0xFFF2F2F7)     // iOS背景色
val iOSSurface = Color(0xFFFFFFFF)         // iOS卡片背景
val iOSOnSurface = Color(0xFF1C1C1E)     // iOS主要文字
val iOSOnSurfaceVariant = Color(0xFF8E8E93) // iOS次要文字
val iOSBlueContainer = Color(0xFFE3F2FD)  // iOS蓝色容器背景

// 深色模式主题色
val iOSBlueDark = Color(0xFF0A84FF)      // iOS深色蓝
val iOSBackgroundDark = Color(0xFF000000) // iOS深色背景
val iOSSurfaceDark = Color(0xFF1C1C1E)   // iOS深色卡片
val iOSOnSurfaceDark = Color(0xFFFFFFFF) // iOS深色主要文字
val iOSOnSurfaceVariantDark = Color(0xFF8E8E93) // iOS深色次要文字
val iOSBlueContainerDark = Color(0xFF1E3A8A) // iOS深色蓝色容器背景

// ==================== 新增丰富主题颜色 ====================

// 主色调渐变系列
val PrimaryLight = Color(0xFF6366F1)      // 现代紫色主色
val PrimaryDark = Color(0xFF818CF8)       // 深色模式主色
val PrimaryContainerLight = Color(0xFFEDE9FE)  // 主色容器浅色
val PrimaryContainerDark = Color(0xFF4C1D95)   // 主色容器深色

// 次要色调 - 温暖橙红色系
val SecondaryLight = Color(0xFFEF4444)    // 温暖红色
val SecondaryDark = Color(0xFFF87171)     // 深色模式次要色
val SecondaryContainerLight = Color(0xFFFEE2E2)  // 次要容器浅色
val SecondaryContainerDark = Color(0xFF7F1D1D)    // 次要容器深色

// 第三色调 - 自然绿色系
val TertiaryLight = Color(0xFF10B981)     // 自然绿色
val TertiaryDark = Color(0xFF34D399)      // 深色模式第三色
val TertiaryContainerLight = Color(0xFFD1FAE5)  // 第三容器浅色
val TertiaryContainerDark = Color(0xFF064E3B)    // 第三容器深色

// 功能性颜色 - 成功/警告/错误
val SuccessGreen = Color(0xFF22C55E)      // 成功绿
val WarningAmber = Color(0xFFF59E0B)      // 警告琥珀色
val ErrorRose = Color(0xFFF43F5E)         // 错误玫瑰色
val InfoBlue = Color(0xFF3B82F6)          // 信息蓝色

// 中性色系 - 灰度层次丰富
val Gray50 = Color(0xFFF9FAFB)            // 极浅灰
val Gray100 = Color(0xFFF3F4F6)           // 浅灰
val Gray200 = Color(0xFFE5E7EB)           // 中浅灰
val Gray300 = Color(0xFFD1D5DB)           // 中灰
val Gray400 = Color(0xFF9CA3AF)           // 中深灰
val Gray500 = Color(0xFF6B7280)           // 深灰
val Gray600 = Color(0xFF4B5563)           // 较深灰
val Gray700 = Color(0xFF374151)           // 深灰
val Gray800 = Color(0xFF1F2937)           // 极深灰
val Gray900 = Color(0xFF111827)           // 最深灰

// 背景色系统
val BackgroundLight = Color(0xFFFAFAFA)   // 现代浅色背景
val BackgroundDark = Color(0xFF0F172A)    // 现代深色背景
val SurfaceLight = Color(0xFFFFFFFF)      // 现代浅色表面
val SurfaceDark = Color(0xFF1E293B)       // 现代深色表面
val SurfaceVariantLight = Color(0xFFF8FAFC) // 浅色变体表面
val SurfaceVariantDark = Color(0xFF334155)   // 深色变体表面

// 文本颜色系统
val OnPrimaryLight = Color(0xFFFFFFFF)     // 主色上的文字（浅色模式）
val OnPrimaryDark = Color(0xFF0F172A)      // 主色上的文字（深色模式）
val OnSecondaryLight = Color(0xFFFFFFFF)   // 次要色上的文字（浅色模式）
val OnSecondaryDark = Color(0xFFF9FAFB)    // 次要色上的文字（深色模式）
val OnTertiaryLight = Color(0xFFFFFFFF)    // 第三色上的文字（浅色模式）
val OnTertiaryDark = Color(0xFFF0FDF4)     // 第三色上的文字（深色模式）
val OnBackgroundLight = Color(0xFF1F2937)  // 背景上的文字（浅色模式）
val OnBackgroundDark = Color(0xFFF9FAFB)   // 背景上的文字（深色模式）
val OnSurfaceLight = Color(0xFF374151)     // 表面上的文字（浅色模式）
val OnSurfaceDark = Color(0xFFF1F5F9)      // 表面上的文字（深色模式）

// 装饰性颜色
val AccentViolet = Color(0xFF8B5CF6)       // 强调紫色
val AccentTeal = Color(0xFF14B8A6)         // 强调青色
val AccentPink = Color(0xFFEC4899)         // 强调粉色
val AccentYellow = Color(0xFFFBBF24)       // 强调黄色
val AccentIndigo = Color(0xFF6366F1)       // 强调靛蓝色

// 渐变色组合
val GradientStart = Color(0xFF667EEA)      // 渐变开始色
val GradientEnd = Color(0xFF764BA2)        // 渐变结束色
val GradientAltStart = Color(0xFFF093FB)   // 替代渐变开始色
val GradientAltEnd = Color(0xFFF5576C)     // 替代渐变结束色

// 特殊状态色
val DisabledLight = Color(0xFFE5E7EB)      // 禁用状态（浅色模式）
val DisabledDark = Color(0xFF4B5563)       // 禁用状态（深色模式）
val DisabledOnLight = Color(0xFF9CA3AF)    // 禁用状态文字（浅色模式）
val DisabledOnDark = Color(0xFF6B7280)     // 禁用状态文字（深色模式）

// 保留原有颜色作为备用
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)