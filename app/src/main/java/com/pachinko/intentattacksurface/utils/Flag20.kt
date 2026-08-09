package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag20 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            action = "io.hextree.broadcast.GET_FLAG"
            putExtra("give-flag", true)
        }
        context.sendBroadcast(intent)
    }
}
