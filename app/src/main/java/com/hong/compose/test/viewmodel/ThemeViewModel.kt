package com.hong.compose.test.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hong.compose.test.data.ThemePreferences
import com.hong.compose.test.ui.theme.AppTheme
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// 数据类用于保存主题状态
data class ThemeState(
    val themeType: AppTheme = AppTheme.IOS,
    val darkMode: Boolean = false,
    val dynamicColor: Boolean = false
)

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val themePreferences = ThemePreferences.getInstance(application)

    // 使用StateFlow来管理主题状态
    private val _themeState = MutableStateFlow(ThemeState())
    val themeState: StateFlow<ThemeState> = _themeState.asStateFlow()

    // 为Compose使用而设置的state变量
    var currentThemeType by mutableStateOf(AppTheme.IOS)
        private set
    var isDarkMode by mutableStateOf(false)
        private set
    var isDynamicColor by mutableStateOf(false)
        private set

    init {
        // 初始化时加载保存的主题设置
        loadThemeSettings()
    }

    private fun loadThemeSettings() {
        viewModelScope.launch {
            // 合并三个Flow来获取完整的主题设置
            combine(
                themePreferences.themeTypeFlow,
                themePreferences.darkModeFlow,
                themePreferences.dynamicColorFlow
            ) { themeType, darkMode, dynamicColor ->
                ThemeState(
                    themeType = parseThemeType(themeType),
                    darkMode = darkMode,
                    dynamicColor = dynamicColor
                )
            }.collect { state ->
                _themeState.value = state
                // 更新Compose state变量
                currentThemeType = state.themeType
                isDarkMode = state.darkMode
                isDynamicColor = state.dynamicColor
            }
        }
    }

    // 切换主题类型
    fun changeThemeType(themeType: AppTheme) {
        viewModelScope.launch {
            themePreferences.saveThemeType(themeType.name)
            // 立即更新本地状态
            currentThemeType = themeType
            _themeState.value = _themeState.value.copy(themeType = themeType)
        }
    }

    // 切换深色模式
    fun toggleDarkMode() {
        viewModelScope.launch {
            val newDarkMode = !isDarkMode
            themePreferences.saveDarkMode(newDarkMode)
            // 立即更新本地状态
            isDarkMode = newDarkMode
            _themeState.value = _themeState.value.copy(darkMode = newDarkMode)
        }
    }

    // 设置深色模式
    fun updateDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            themePreferences.saveDarkMode(darkMode)
            // 立即更新本地状态
            isDarkMode = darkMode
            _themeState.value = _themeState.value.copy(darkMode = darkMode)
        }
    }

    // 切换动态颜色
    fun toggleDynamicColor() {
        viewModelScope.launch {
            val newDynamicColor = !isDynamicColor
            themePreferences.saveDynamicColor(newDynamicColor)
            // 立即更新本地状态
            isDynamicColor = newDynamicColor
            _themeState.value = _themeState.value.copy(dynamicColor = newDynamicColor)
        }
    }

    // 设置动态颜色
    fun updateDynamicColor(dynamicColor: Boolean) {
        viewModelScope.launch {
            themePreferences.saveDynamicColor(dynamicColor)
            // 立即更新本地状态
            isDynamicColor = dynamicColor
            _themeState.value = _themeState.value.copy(dynamicColor = dynamicColor)
        }
    }

    // 保存所有主题设置
    fun saveThemeSettings(
        themeType: AppTheme,
        darkMode: Boolean,
        dynamicColor: Boolean
    ) {
        viewModelScope.launch {
            themePreferences.saveThemeSettings(
                themeType.name,
                darkMode,
                dynamicColor
            )
            // 立即更新本地状态
            currentThemeType = themeType
            isDarkMode = darkMode
            isDynamicColor = dynamicColor
            _themeState.value = ThemeState(themeType, darkMode, dynamicColor)
        }
    }

    // 解析字符串为AppTheme枚举
    private fun parseThemeType(themeType: String): AppTheme {
        return try {
            AppTheme.valueOf(themeType)
        } catch (e: IllegalArgumentException) {
            AppTheme.IOS // 默认值
        }
    }

    // 获取所有可用的主题类型
    fun getAvailableThemes(): List<AppTheme> {
        return AppTheme.entries
    }

    // 检查是否支持动态颜色（Android 12+）
    fun supportsDynamicColor(): Boolean {
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S
    }
}

// ViewModelFactory用于创建ThemeViewModel
class ThemeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThemeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ThemeViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}