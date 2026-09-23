package com.originstyle.customizer.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.annotation.DrawableRes

object WallpaperApplier {
    const val HOME = WallpaperManager.FLAG_SYSTEM
    const val LOCK = WallpaperManager.FLAG_LOCK

    fun apply(context: Context, @DrawableRes resId: Int, which: Int) {
        try {
            val wm = WallpaperManager.getInstance(context)
            val bmp = BitmapFactory.decodeResource(context.resources, resId)
            when (which) {
                HOME -> wm.setBitmap(bmp, null, true, HOME)
                LOCK -> wm.setBitmap(bmp, null, true, LOCK)
                else -> {
                    wm.setBitmap(bmp, null, true, HOME)
                    wm.setBitmap(bmp, null, true, LOCK)
                }
            }
            Toast.makeText(context, "Wallpaper applied", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Failed: " + e.message, Toast.LENGTH_LONG).show()
        }
    }
}
