package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ComponentInfo

object Flag14 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag14Activity"
            )
        }
        context.startActivity(intent)
    }
}
