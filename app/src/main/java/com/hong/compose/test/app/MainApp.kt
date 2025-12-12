package com.hong.compose.test.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hong.compose.test.components.BottomNavigationDemo
import com.hong.compose.test.components.Material3DemoScreen
import com.hong.compose.test.components.basic.*
import com.hong.compose.test.components.layout.*
import com.hong.compose.test.components.input.*
import com.hong.compose.test.components.list.*
import com.hong.compose.test.components.image.*
import com.hong.compose.test.components.dialog.*
import com.hong.compose.test.components.modern.*
import com.hong.compose.test.components.special.*
import com.hong.compose.test.components.HomeScreen
import com.hong.compose.test.components.NavigationRailDemo
import com.hong.compose.test.components.Screen
import com.hong.compose.test.components.ScrollableTabRowDemo
import com.hong.compose.test.components.TabRowDemo
import com.hong.compose.test.components.theme.ThemeSelector
import com.hong.compose.test.components.theme.ThemeShowcase
import com.hong.compose.test.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    themeViewModel: ThemeViewModel? = null
) {
    var showThemeSelector by remember { mutableStateOf(false) }

    val navController = rememberNavController()

    Scaffold(
//        bottomBar = {
//            NavigationBar(navController, modifier = Modifier)
//        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.HomeScreen.route) {
                HomeScreen(navController, themeViewModel)
            }

            // Material 3 Demo Navigation
            composable("material3_demo") {
                Material3DemoScreen(navController)
            }

            // Basic Display Components
            composable("basic_display/text") {
                TextDemo()
            }

            composable("basic_display/button") {
                ButtonDemo()
            }

            composable("basic_display/textfield") {
                TextFieldDemo()
            }

            composable("basic_display/fab") {
                FloatingActionButtonDemo()
            }

            // Layout Components
            composable("layout/card") {
                CardDemo()
            }

            composable("layout/surface") {
                SurfaceDemo()
            }

            composable("layout/scaffold") {
                ScaffoldDemo()
            }

            // Input Components
            composable("input/checkbox") {
                CheckboxDemo()
            }

            composable("input/radiobutton") {
                RadioButtonDemo()
            }

            composable("input/switch") {
                SwitchDemo()
            }

            composable("input/slider") {
                SliderDemo()
            }

            composable("input/progressbar") {
                ProgressBarDemo()
            }

            // List Components
            composable("list/list") {
                ListDemo()
            }

            composable("list/lazycolumn") {
                LazyColumnDemo()
            }

            composable("list/lazyrow") {
                LazyRowDemo()
            }

            composable("list/lazyverticalgrid") {
                LazyVerticalGridDemo()
            }

            // Image Components
            composable("image/image") {
                ImageDemo()
            }

            composable("image/asyncimage") {
                AsyncImageDemo()
            }

            composable("image/icon") {
                IconDemo()
            }

            // Dialog Components
            composable("dialog/alertdialog") {
                AlertDialogDemo()
            }

            composable("dialog/dialog") {
                DialogDemo()
            }

            composable("dialog/bottomsheet") {
                BottomSheetDemo()
            }

            composable("dialog/modalbottomsheet") {
                ModalBottomSheetDemo()
            }

            // Navigation Components
            composable("navigation/navigationrail") {
                NavigationRailDemo()
            }

            composable("navigation/bottomnavigation") {
                BottomNavigationDemo()
            }

            composable("navigation/tabrow") {
                TabRowDemo()
            }

            composable("navigation/scrollabletabrow") {
                ScrollableTabRowDemo()
            }

            // Modern Material 3 Components
            composable("modern/searchbar") {
                SearchBarDemo()
            }

            composable("modern/topappbar") {
                TopAppBarDemo()
            }

            composable("modern/pulltorefresh") {
                PullToRefreshDemo()
            }

            composable("modern/swipetodismiss") {
                SwipeToDismissDemo()
            }

            // Special Components
            composable("special/datepicker") {
                DatePickerDemo()
            }

            composable("special/timepicker") {
                TimePickerDemo()
            }

            composable("special/badge") {
                BadgeDemo()
            }

            composable("special/chip") {
                ChipDemo()
            }

            composable("special/staggeredgrid") {
                StaggeredGridDemo()
            }

            // Theme Showcase
            composable("theme/showcase") {
                ThemeShowcase()
            }
        }

        // 主题选择器
        if (showThemeSelector && themeViewModel != null) {
            ThemeSelector(
                viewModel = themeViewModel,
                onDismiss = { showThemeSelector = false }
            )
        }
    }
}