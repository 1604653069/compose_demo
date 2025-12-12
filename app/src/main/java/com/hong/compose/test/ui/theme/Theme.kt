package com.hong.compose.test.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// iOS风格的深色主题
private val iOSDarkColorScheme = darkColorScheme(
    primary = iOSBlueDark,
    onPrimary = Color.White,
    primaryContainer = iOSBlueContainerDark,
    onPrimaryContainer = Color.White,
    inversePrimary = iOSBlue,
    secondary = iOSBlueLight,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF2E2E3E),
    onSecondaryContainer = Color.White,
    tertiary = iOSBlue,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF2A3F5F),
    onTertiaryContainer = Color.White,
    background = iOSBackgroundDark,
    onBackground = iOSOnSurfaceDark,
    surface = iOSSurfaceDark,
    onSurface = iOSOnSurfaceDark,
    surfaceVariant = Color(0xFF2C2C2E),
    onSurfaceVariant = iOSOnSurfaceVariantDark,
    surfaceTint = iOSBlueDark,
    inverseSurface = Color.White,
    inverseOnSurface = Color.Black,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFF3E1111),
    onErrorContainer = Color(0xFFFFE5E5),
    outline = Gray600,
    outlineVariant = Gray700,
    scrim = Color(0xFF000000),
    surfaceBright = Color(0xFF3A3A3C),
    surfaceContainer = Color(0xFF1C1C1E),
    surfaceContainerHigh = Color(0xFF2C2C2E),
    surfaceContainerHighest = Color(0xFF3A3A3C),
    surfaceContainerLow = Color(0xFF000000),
    surfaceContainerLowest = Color.Black,
    surfaceDim = Color(0xFF1C1C1E)
)

// iOS风格的浅色主题
private val iOSLightColorScheme = lightColorScheme(
    primary = iOSBlue,
    onPrimary = Color.White,
    primaryContainer = iOSBlueContainer,
    onPrimaryContainer = iOSBlueDark,
    inversePrimary = iOSBlueDark,
    secondary = iOSBlueLight,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE8F5E8),
    onSecondaryContainer = Color(0xFF1B5E20),
    tertiary = iOSBlueDark,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFF0F8FF),
    onTertiaryContainer = Color(0xFF0D47A1),
    background = iOSBackground,
    onBackground = iOSOnSurface,
    surface = iOSSurface,
    onSurface = iOSOnSurface,
    surfaceVariant = Color(0xFFF2F2F7),
    onSurfaceVariant = iOSOnSurfaceVariant,
    surfaceTint = iOSBlue,
    inverseSurface = Gray800,
    inverseOnSurface = Color.White,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFFFFE5E5),
    onErrorContainer = Color(0xFF7F1D1D),
    outline = Gray300,
    outlineVariant = Gray200,
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceContainer = Color(0xFFF9F9F9),
    surfaceContainerHigh = Color(0xFFF0F0F0),
    surfaceContainerHighest = Color(0xFFE5E5EA),
    surfaceContainerLow = Color(0xFFFFFEFF),
    surfaceContainerLowest = Color.White,
    surfaceDim = Color(0xFFD1D1D6)
)

// 现代渐变主题 - 浅色模式
private val ModernLightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = PrimaryDark,
    inversePrimary = AccentViolet,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = Color(0xFF991B1B),
    tertiary = TertiaryLight,
    onTertiary = OnTertiaryLight,
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = Color(0xFF065F46),
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = Gray600,
    surfaceTint = PrimaryLight,
    inverseSurface = Gray800,
    inverseOnSurface = Color.White,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFFFFE5E5),
    onErrorContainer = Color(0xFF7F1D1D),
    outline = Gray300,
    outlineVariant = Gray200,
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceContainer = Gray100,
    surfaceContainerHigh = Gray200,
    surfaceContainerHighest = Gray300,
    surfaceContainerLow = Color(0xFFFFFAFE),
    surfaceContainerLowest = Color.White,
    surfaceDim = Gray700
)

// 现代渐变主题 - 深色模式
private val ModernDarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = Color(0xFFE9D5FF),
    inversePrimary = PrimaryLight,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = Color(0xFFFECACA),
    tertiary = TertiaryDark,
    onTertiary = OnTertiaryDark,
    tertiaryContainer = TertiaryContainerDark,
    onTertiaryContainer = Color(0xFFA7F3D0),
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = Gray400,
    surfaceTint = PrimaryDark,
    inverseSurface = Gray200,
    inverseOnSurface = Gray900,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFF3E1111),
    onErrorContainer = Color(0xFFFFE5E5),
    outline = Gray600,
    outlineVariant = Gray700,
    scrim = Color(0xFF000000),
    surfaceBright = Gray200,
    surfaceContainer = Gray800,
    surfaceContainerHigh = Gray700,
    surfaceContainerHighest = Gray600,
    surfaceContainerLow = Gray900,
    surfaceContainerLowest = Color.Black,
    surfaceDim = Gray800
)

// 清新自然主题 - 浅色模式
private val NatureLightColorScheme = lightColorScheme(
    primary = TertiaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = TertiaryContainerLight,
    onPrimaryContainer = Color(0xFF064E3B),
    inversePrimary = AccentTeal,
    secondary = AccentTeal,
    onSecondary = OnPrimaryLight,
    secondaryContainer = Color(0xFFCCFBF1),
    onSecondaryContainer = Color(0xFF134E4A),
    tertiary = SuccessGreen,
    onTertiary = OnPrimaryLight,
    tertiaryContainer = Color(0xFFDCFCE7),
    onTertiaryContainer = Color(0xFF14532D),
    background = Gray50,
    onBackground = OnBackgroundLight,
    surface = Color.White,
    onSurface = OnSurfaceLight,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = Gray600,
    surfaceTint = TertiaryLight,
    inverseSurface = Gray800,
    inverseOnSurface = Color.White,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFFFFE5E5),
    onErrorContainer = Color(0xFF7F1D1D),
    outline = Gray300,
    outlineVariant = Gray200,
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceContainer = Gray100,
    surfaceContainerHigh = Gray200,
    surfaceContainerHighest = Gray300,
    surfaceContainerLow = Color(0xFFFFFAFE),
    surfaceContainerLowest = Color.White,
    surfaceDim = Gray700
)

// 清新自然主题 - 深色模式
private val NatureDarkColorScheme = darkColorScheme(
    primary = TertiaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = TertiaryContainerDark,
    onPrimaryContainer = Color(0xFFA7F3D0),
    inversePrimary = TertiaryLight,
    secondary = AccentTeal,
    onSecondary = OnPrimaryLight,
    secondaryContainer = Color(0xFF134E4A),
    onSecondaryContainer = Color(0xFF5EEAD4),
    tertiary = SuccessGreen,
    onTertiary = OnPrimaryLight,
    tertiaryContainer = Color(0xFF052E16),
    onTertiaryContainer = Color(0xFF86EFAC),
    background = Gray900,
    onBackground = OnBackgroundDark,
    surface = Gray800,
    onSurface = OnSurfaceDark,
    surfaceVariant = Gray700,
    onSurfaceVariant = Gray300,
    surfaceTint = TertiaryDark,
    inverseSurface = Gray200,
    inverseOnSurface = Gray900,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFF3E1111),
    onErrorContainer = Color(0xFFFFE5E5),
    outline = Gray600,
    outlineVariant = Gray700,
    scrim = Color(0xFF000000),
    surfaceBright = Gray200,
    surfaceContainer = Gray800,
    surfaceContainerHigh = Gray700,
    surfaceContainerHighest = Gray600,
    surfaceContainerLow = Gray900,
    surfaceContainerLowest = Color.Black,
    surfaceDim = Gray800
)

// 温暖日落主题 - 浅色模式
private val SunsetLightColorScheme = lightColorScheme(
    primary = SecondaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = SecondaryContainerLight,
    onPrimaryContainer = Color(0xFF7F1D1D),
    inversePrimary = AccentPink,
    secondary = AccentYellow,
    onSecondary = Color(0xFF78350F),
    secondaryContainer = Color(0xFFFDE68A),
    onSecondaryContainer = Color(0xFF78350F),
    tertiary = AccentPink,
    onTertiary = OnPrimaryLight,
    tertiaryContainer = Color(0xFFFBCFE8),
    onTertiaryContainer = Color(0xFF831843),
    background = Color(0xFFFFFEF7),
    onBackground = Color(0xFF451A03),
    surface = Color.White,
    onSurface = Color(0xFF1C1917),
    surfaceVariant = Color(0xFFFEF3C7),
    onSurfaceVariant = Gray600,
    surfaceTint = SecondaryLight,
    inverseSurface = Gray800,
    inverseOnSurface = Color.White,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFFFFE5E5),
    onErrorContainer = Color(0xFF7F1D1D),
    outline = Gray300,
    outlineVariant = Gray200,
    scrim = Color(0xFF000000),
    surfaceBright = Color.White,
    surfaceContainer = Gray100,
    surfaceContainerHigh = Gray200,
    surfaceContainerHighest = Gray300,
    surfaceContainerLow = Color(0xFFFFFAFE),
    surfaceContainerLowest = Color.White,
    surfaceDim = Gray700
)

// 温暖日落主题 - 深色模式
private val SunsetDarkColorScheme = darkColorScheme(
    primary = SecondaryDark,
    onPrimary = OnSecondaryDark,
    primaryContainer = SecondaryContainerDark,
    onPrimaryContainer = Color(0xFFFECACA),
    inversePrimary = SecondaryLight,
    secondary = AccentYellow,
    onSecondary = Color(0xFF1C1917),
    secondaryContainer = Color(0xFF713F12),
    onSecondaryContainer = Color(0xFFFDE047),
    tertiary = AccentPink,
    onTertiary = OnPrimaryLight,
    tertiaryContainer = Color(0xFF831843),
    onTertiaryContainer = Color(0xFFFBCFE8),
    background = Color(0xFF18181B),
    onBackground = Color(0xFFF5F5F4),
    surface = Color(0xFF27272A),
    onSurface = Color(0xFFE5E5E4),
    surfaceVariant = Color(0xFF3F3F46),
    onSurfaceVariant = Gray400,
    surfaceTint = SecondaryDark,
    inverseSurface = Gray200,
    inverseOnSurface = Gray900,
    error = ErrorRose,
    onError = Color.White,
    errorContainer = Color(0xFF3E1111),
    onErrorContainer = Color(0xFFFFE5E5),
    outline = Gray600,
    outlineVariant = Gray700,
    scrim = Color(0xFF000000),
    surfaceBright = Gray200,
    surfaceContainer = Gray800,
    surfaceContainerHigh = Gray700,
    surfaceContainerHighest = Gray600,
    surfaceContainerLow = Gray900,
    surfaceContainerLowest = Color.Black,
    surfaceDim = Gray800
)

// 保留原有的Material主题作为备用选项
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

// 主题类型枚举
enum class AppTheme {
    IOS,        // iOS风格主题
    MODERN,     // 现代渐变主题
    NATURE,     // 清新自然主题
    SUNSET,     // 温暖日落主题
    MATERIAL    // Material默认主题
}

@Composable
fun Compose_testTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    themeType: AppTheme = AppTheme.IOS,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        // 根据主题类型选择配色方案
        themeType == AppTheme.IOS -> {
            if (darkTheme) iOSDarkColorScheme else iOSLightColorScheme
        }

        themeType == AppTheme.MODERN -> {
            if (darkTheme) ModernDarkColorScheme else ModernLightColorScheme
        }

        themeType == AppTheme.NATURE -> {
            if (darkTheme) NatureDarkColorScheme else NatureLightColorScheme
        }

        themeType == AppTheme.SUNSET -> {
            if (darkTheme) SunsetDarkColorScheme else SunsetLightColorScheme
        }

        themeType == AppTheme.MATERIAL -> {
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        // 默认使用iOS主题
        else -> {
            if (darkTheme) iOSDarkColorScheme else iOSLightColorScheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// 便捷的主题切换函数
@Composable
fun ModernTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Compose_testTheme(darkTheme = darkTheme, themeType = AppTheme.MODERN, content = content)
}

@Composable
fun NatureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Compose_testTheme(darkTheme = darkTheme, themeType = AppTheme.NATURE, content = content)
}

@Composable
fun SunsetTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Compose_testTheme(darkTheme = darkTheme, themeType = AppTheme.SUNSET, content = content)
}

@Composable
fun IOSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Compose_testTheme(darkTheme = darkTheme, themeType = AppTheme.IOS, content = content)
}