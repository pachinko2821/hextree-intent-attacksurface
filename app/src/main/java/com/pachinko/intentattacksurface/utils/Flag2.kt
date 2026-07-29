package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag2 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag2Activity"
            )
            action = "io.hextree.action.GIVE_FLAG"
        }
        Utils.showDialog(context, intent)
        context.startActivity(intent)
    }
}
