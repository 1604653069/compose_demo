package com.hong.compose.test.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// 扩展属性创建DataStore实例
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_preferences")

class ThemePreferences private constructor(private val context: Context) {

    private val dataStore = context.dataStore

    // 主题类型键
    private val themeTypeKey = stringPreferencesKey("theme_type")
    // 深色模式键
    private val darkModeKey = booleanPreferencesKey("dark_mode")
    // 动态颜色键
    private val dynamicColorKey = booleanPreferencesKey("dynamic_color")

    // 保存主题设置
    suspend fun saveThemeSettings(
        themeType: String,
        darkMode: Boolean,
        dynamicColor: Boolean
    ) {
        dataStore.edit { preferences ->
            preferences[themeTypeKey] = themeType
            preferences[darkModeKey] = darkMode
            preferences[dynamicColorKey] = dynamicColor
        }
    }

    // 保存主题类型
    suspend fun saveThemeType(themeType: String) {
        dataStore.edit { preferences ->
            preferences[themeTypeKey] = themeType
        }
    }

    // 保存深色模式设置
    suspend fun saveDarkMode(darkMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[darkModeKey] = darkMode
        }
    }

    // 保存动态颜色设置
    suspend fun saveDynamicColor(dynamicColor: Boolean) {
        dataStore.edit { preferences ->
            preferences[dynamicColorKey] = dynamicColor
        }
    }

    // 获取主题类型Flow
    val themeTypeFlow: Flow<String> = dataStore.data.map { preferences ->
        preferences[themeTypeKey] ?: "IOS" // 默认iOS主题
    }

    // 获取深色模式Flow
    val darkModeFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[darkModeKey] ?: false // 默认浅色模式
    }

    // 获取动态颜色Flow
    val dynamicColorFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[dynamicColorKey] ?: false // 默认不使用动态颜色
    }

    companion object {
        @Volatile
        private var INSTANCE: ThemePreferences? = null

        fun getInstance(context: Context): ThemePreferences {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ThemePreferences(context).also { INSTANCE = it }
            }
        }
    }
}