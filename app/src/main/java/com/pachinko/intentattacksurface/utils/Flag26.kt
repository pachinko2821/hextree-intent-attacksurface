package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder

object Flag26 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "com.pachinko.intentattacksurface",
                "com.pachinko.intentattacksurface.Flag26Activity"
            )
        }
        context.startActivity(intent)
    }
}
