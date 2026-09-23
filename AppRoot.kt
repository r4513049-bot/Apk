package com.originstyle.customizer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Wallpaper
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot(theme: ThemeState) {
    var tab by rememberSaveable { mutableStateOf("themes") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Origin Style") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = androidx.compose.ui.graphics.Color.Transparent
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = tab == "themes",
                    onClick = { tab = "themes" },
                    icon = { Icon(Icons.Default.Palette, contentDescription = null) },
                    label = { Text("Themes") }
                )
                NavigationBarItem(
                    selected = tab == "wallpapers",
                    onClick = { tab = "wallpapers" },
                    icon = { Icon(Icons.Default.Wallpaper, contentDescription = null) },
                    label = { Text("Walls") }
                )
                NavigationBarItem(
                    selected = tab == "icons",
                    onClick = { tab = "icons" },
                    icon = { Icon(Icons.Default.Apps, contentDescription = null) },
                    label = { Text("Icons") }
                )
                NavigationBarItem(
                    selected = tab == "widgets",
                    onClick = { tab = "widgets" },
                    icon = { Icon(Icons.Default.Widgets, contentDescription = null) },
                    label = { Text("Widgets") }
                )
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (tab) {
                "themes" -> ThemesScreen(theme)
                "wallpapers" -> WallpapersScreen()
                "icons" -> IconsScreen(theme)
                else -> WidgetsScreen()
            }
        }
    }
}
