package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag27 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "com.pachinko.intentattacksurface",
                "com.pachinko.intentattacksurface.Flag27Activity"
            )
        }
        context.startActivity(intent)
    }
}
