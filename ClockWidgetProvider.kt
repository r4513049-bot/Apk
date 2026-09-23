package com.originstyle.customizer.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.originstyle.customizer.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ClockWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val date = SimpleDateFormat("EEE, d MMM", Locale.getDefault()).format(Date())
        for (id in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_clock)
            views.setTextViewText(R.id.widget_time, time)
            views.setTextViewText(R.id.widget_date, date)
            appWidgetManager.updateAppWidget(id, views)
        }
    }
}
