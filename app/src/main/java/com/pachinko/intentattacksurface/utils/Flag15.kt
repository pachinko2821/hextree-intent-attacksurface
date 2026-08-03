package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object Flag15 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = "https://iampachinko.site/hxt.html".toUri()
        }
        context.startActivity(intent)
    }
}
