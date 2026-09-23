package com.originstyle.customizer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.BlurCircular
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.originstyle.customizer.data.Feature

private val Features = listOf(
    Feature(Icons.Default.Widgets, "Atomic Widgets", "OriginOS-style glance widgets: clock, battery, weather, music."),
    Feature(Icons.Default.Palette, "Color Engine", "System-wide accent color with 7 curated OriginOS-style tones."),
    Feature(Icons.Default.DarkMode, "AMOLED Black", "True-black theme that saves battery on OLED screens."),
    Feature(Icons.Default.BlurCircular, "Squircle Icons", "Soft squircle icon shapes with rounded corners."),
    Feature(Icons.Default.Speed, "Smooth Motion", "Spring based animations tuned for a fluid 120Hz feel."),
    Feature(Icons.Default.AutoAwesome, "Wallpaper Studio", "One-tap anime, dark and AMOLED wallpapers for home & lock.")
)

@Composable
fun ThemesScreen(theme: ThemeState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Appearance", style = MaterialTheme.typography.titleLarge)
        }
        item {
            Card {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Mode", style = MaterialTheme.typography.titleMedium)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = !theme.dark,
                            onClick = { theme.dark = false },
                            label = { Text("Light") }
                        )
                        FilterChip(
                            selected = theme.dark && !theme.amoled,
                            onClick = { theme.dark = true; theme.amoled = false },
                            label = { Text("Dark") }
                        )
                        FilterChip(
                            selected = theme.dark && theme.amoled,
                            onClick = { theme.dark = true; theme.amoled = true },
                            label = { Text("AMOLED") }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text("True black (AMOLED)", style = MaterialTheme.typography.bodyLarge)
                            Text(
                                "Pure black pixels, saves battery on OLED",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Switch(
                            checked = theme.amoled && theme.dark,
                            onCheckedChange = { theme.amoled = it; if (it) theme.dark = true },
                            enabled = theme.dark
                        )
                    }
                }
            }
        }
        item {
            Text("Accent color", style = MaterialTheme.typography.titleLarge)
        }
        item {
            Card {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AccentColors.forEach { (color, name) ->
                        val selected = theme.accent == color
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .border(
                                        width = if (selected) 3.dp else 0.dp,
                                        color = if (selected) MaterialTheme.colorScheme.onBackground
                                        else androidx.compose.ui.graphics.Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable { theme.accent = color }
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(name, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }
        item {
            Text("OriginOS 7 inspired features", style = MaterialTheme.typography.titleLarge)
        }
        items(Features) { f -> FeatureRow(f) }
    }
}

@Composable
private fun FeatureRow(f: Feature) {
    Card {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                f.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(Modifier.width(14.dp))
            Column {
                Text(f.title, style = MaterialTheme.typography.titleSmall)
                Text(
                    f.desc,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
