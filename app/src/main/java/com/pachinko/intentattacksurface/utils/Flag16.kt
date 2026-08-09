package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag16 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.receivers.Flag16Receiver"
            )
            putExtra("flag", "give-flag-16")
        }
        context.sendBroadcast(intent)
    }
}
