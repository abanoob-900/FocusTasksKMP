package com.bob.focustasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bob.focustasks.ui.components.AppBottomBar
import com.bob.focustasks.ui.components.BottomNavTab
import com.bob.focustasks.ui.screens.CalendarScreen
import com.bob.focustasks.ui.screens.FocusScreen
import com.bob.focustasks.ui.screens.HomeScreen
import com.bob.focustasks.ui.screens.SettingsScreen
import com.bob.focustasks.ui.theme.FocusTasksTheme

@Preview
@Composable
fun App() {
    FocusTasksTheme {
        var currentTab by remember { mutableStateOf(BottomNavTab.Tasks) }

        Scaffold(
            bottomBar = {
                AppBottomBar(
                    currentTab = currentTab,
                    onTabSelected = { selectedTab ->
                        currentTab = selectedTab
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentTab) {
                    BottomNavTab.Tasks -> HomeScreen()

                    BottomNavTab.Calendar -> CalendarScreen()

                    BottomNavTab.Focus -> FocusScreen()

                    BottomNavTab.Settings -> SettingsScreen()
                }
            }
        }
    }
}