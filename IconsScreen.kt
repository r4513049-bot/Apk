package com.originstyle.customizer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val IconShapes = listOf(
    "Squircle" to RoundedCornerShape(32),
    "Rounded" to RoundedCornerShape(16),
    "Soft" to RoundedCornerShape(24),
    "Circle" to CircleShape
)

private val FakeApps = listOf(
    "Phone" to "P", "Messages" to "M", "Camera" to "C", "Gallery" to "G",
    "Settings" to "S", "Play" to "▶", "Music" to "♪", "Browser" to "B"
)

@Composable
fun IconsScreen(theme: ThemeState) {
    var shapeName by remember { mutableStateOf(IconShapes.first().first) }
    val shape: Shape = IconShapes.first { it.first == shapeName }.second

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item(key = "chips") {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IconShapes.forEach { (name, _) ->
                    FilterChip(
                        selected = shapeName == name,
                        onClick = { shapeName = name },
                        label = { Text(name) }
                    )
                }
            }
        }
        item(key = "gridcard") {
            Card {
                Column(Modifier.padding(16.dp)) {
                    Text("Preview", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        FakeApps.take(4).forEach { (name, glyph) ->
                            FakeAppIcon(name, glyph, shape, theme)
                        }
                    }
                    Spacer(Modifier.height(18.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        FakeApps.drop(4).forEach { (name, glyph) ->
                            FakeAppIcon(name, glyph, shape, theme)
                        }
                    }
                }
            }
        }
        item(key = "notecard") {
            Card {
                Column(Modifier.padding(16.dp)) {
                    Text("Apply icon packs on any launcher", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "1. Long-press an app icon and tap Edit.\n" +
                        "2. Choose an icon pack (this app ships a squircle style).\n" +
                        "3. On Nova / Lawnchair: Settings > Look & feel > Icon style.\n\n" +
                        "Note: third-party apps cannot change icons of other apps directly " +
                        "on Android - launchers apply the pack for you.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun FakeAppIcon(name: String, glyph: String, shape: Shape, theme: ThemeState) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .aspectRatio(1f)
                .clip(shape)
                .background(theme.accent.copy(alpha = 0.18f))
                .border(1.5.dp, theme.accent, shape)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(glyph, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = theme.accent)
        }
        Spacer(Modifier.height(6.dp))
        Text(name, style = MaterialTheme.typography.labelSmall)
    }
}
