package com.originstyle.customizer.data

import androidx.annotation.DrawableRes
import com.originstyle.customizer.R

enum class WallCat { ANIME, DARK, BLACK }

data class WallpaperItem(
    val title: String,
    @DrawableRes val resId: Int,
    val cat: WallCat
)

val Wallpapers = listOf(
    WallpaperItem("Ultra Instinct Neon", R.drawable.wp_goku, WallCat.ANIME),
    WallpaperItem("Itadori AMOLED", R.drawable.wp_itadori, WallCat.ANIME),
    WallpaperItem("Take Your Time", R.drawable.wp_persona, WallCat.ANIME),
    WallpaperItem("Lightning Shinobi", R.drawable.wp_kakashi, WallCat.ANIME),
    WallpaperItem("Ghoul Glow", R.drawable.wp_ghoul, WallCat.ANIME),
    WallpaperItem("Neon Hood", R.drawable.wp_neonhood, WallCat.ANIME),
    WallpaperItem("Jujutsu Crimson", R.drawable.wp_jjk, WallCat.ANIME),
    WallpaperItem("Astral Chart", R.drawable.wp_astral, WallCat.DARK),
    WallpaperItem("Midnight Bloom", R.drawable.wp_flower, WallCat.DARK),
    WallpaperItem("Void Ring", R.drawable.wp_void_ring, WallCat.BLACK),
    WallpaperItem("Ember Core", R.drawable.wp_ember, WallCat.BLACK),
    WallpaperItem("Sakura Core", R.drawable.wp_sakura_core, WallCat.BLACK)
)

data class Feature(val icon: androidx.compose.ui.graphics.vector.ImageVector, val title: String, val desc: String)
