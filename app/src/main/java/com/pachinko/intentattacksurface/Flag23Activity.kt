package com.pachinko.intentattacksurface

import android.app.ActivityOptions
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pachinko.intentattacksurface.ui.theme.IntentAttackSurfaceTheme
import com.pachinko.intentattacksurface.utils.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

class Flag23Activity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("Flag23Activity", "onCreate called")
        Utils.showDialog(this, intent)
        val pendingIntent = intent.getParcelableExtra("pending_intent", PendingIntent::class.java)
        val intent = Intent().apply {
            putExtra("code", 42)
        }
        Utils.showDialog(this, intent)
        runBlocking {
            delay(3000.milliseconds)
            pendingIntent?.send(this@Flag23Activity, 0, intent)
        }
    }
}