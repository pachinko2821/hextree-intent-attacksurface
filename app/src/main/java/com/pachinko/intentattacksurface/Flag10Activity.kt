package com.pachinko.intentattacksurface

import android.content.Intent
import android.os.Bundle
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
import com.pachinko.intentattacksurface.utils.Utils
import android.util.Log
import android.widget.Toast

class Flag10Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("Flag10Activity", "onCreate called")
        Utils.showDialog(this, intent)
        setContent {
            IntentAttackSurfaceTheme {
                val data = intent.getStringExtra("flag") ?: "No data received"
                Flag10Screen(data)
            }
        }
    }
}

@Composable
fun Flag10Screen(data: String) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = data,
                modifier = Modifier.padding(innerPadding)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun Flag10ScreenPreview() {
    Flag10Screen(data = "Preview Data")
}