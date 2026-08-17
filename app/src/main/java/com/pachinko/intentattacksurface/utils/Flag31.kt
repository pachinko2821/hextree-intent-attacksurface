package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.util.Log
import androidx.core.net.toUri

object Flag31 {
    fun getFlag(context: Context) {
        val uri = "content://io.hextree.flag31/flag/31".toUri()
        try {
            val cursor: Cursor? = context.contentResolver.query(
                uri,
                null, null, null, null
            )
            cursor?.use {
                val cursorDump = DatabaseUtils.dumpCursorToString(it)
                Log.d("Flag31", cursorDump)
            }
        } catch (e: Error) {
            Log.e("Flag31", e.message.toString())
        }
    }
}
