package com.pachinko.intentattacksurface

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
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
import com.pachinko.intentattacksurface.utils.Utils

class Flag11Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("Flag11Activity", "onCreate called")
        Utils.showDialog(this, intent)
        val resultIntent = Intent().apply {
            putExtra("token", 1094795585)
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}

@Composable
fun Flag11Screen(data: String) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = data,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Flag11ScreenPreview() {
    Flag11Screen(data = "Preview Data")
}