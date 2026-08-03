package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

object Flag9 {
    fun getFlag(context: Context, launcher: ActivityResultLauncher<Intent>) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag9Activity"
            )
        }
        launcher.launch(intent)
    }
}
