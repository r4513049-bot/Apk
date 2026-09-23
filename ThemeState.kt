package com.originstyle.customizer.ui

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val AccentColors = listOf(
    Color(0xFF3DDC84) to "Origin Green",
    Color(0xFF2196F3) to "Ocean Blue",
    Color(0xFF9C6BFF) to "Nebula Purple",
    Color(0xFFFF4757) to "Crimson",
    Color(0xFFFF9F43) to "Amber",
    Color(0xFF00E5FF) to "Neon Cyan",
    Color(0xFFFF5C8A) to "Sakura Pink"
)

class ThemeState {
    var dark by mutableStateOf(true)
    var amoled by mutableStateOf(true)
    var accent by mutableStateOf(AccentColors.first().first)

    fun scheme(): ColorScheme {
        val a = accent
        return if (dark) darkColorScheme(
            primary = a,
            onPrimary = Color.Black,
            secondary = a.copy(alpha = 0.75f),
            tertiary = a.copy(alpha = 0.55f),
            background = if (amoled) Color(0xFF000000) else Color(0xFF101014),
            surface = if (amoled) Color(0xFF0A0A0A) else Color(0xFF17171C),
            surfaceVariant = if (amoled) Color(0xFF121212) else Color(0xFF232329),
            onBackground = Color(0xFFECECEC),
            onSurface = Color(0xFFECECEC),
            onSurfaceVariant = Color(0xFFAFAFB6)
        ) else lightColorScheme(
            primary = a,
            onPrimary = Color.White,
            secondary = a.copy(alpha = 0.8f)
        )
    }
}

@Composable
fun OriginStyleTheme(theme: ThemeState, content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = theme.scheme(), content = content)
}
