package com.pachinko.intentattacksurface

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pachinko.intentattacksurface.ui.theme.IntentAttackSurfaceTheme
import com.pachinko.intentattacksurface.utils.*

class MainHextreeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Utils.showDialog(this, intent)

        val flag8Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.d("Flag8 Receiver", "Result code: ${result.resultCode}")
            Utils.showDialog(this, result.data ?: Intent())
        }

        setContent {
            IntentFireButton { flagNumber ->
                when (flagNumber) {
                    1 -> Flag1.getFlag(this)
                    2 -> Flag2.getFlag(this)
                    3 -> Flag3.getFlag(this)
                    4 -> Flag4.getFlag(this)
                    5 -> Flag5.getFlag(this)
                    6 -> Flag6.getFlag(this)
                    7 -> Flag7.getFlag(this)
                    8 -> Flag8.getFlag(this, flag8Launcher)
                    9 -> Flag9.getFlag(this)
                    10 -> Flag10.getFlag(this)
                    11 -> Flag11.getFlag(this)
                    12 -> Flag12.getFlag(this)
                    13 -> Flag13.getFlag(this)
                    14 -> Flag14.getFlag(this)
                    15 -> Flag15.getFlag(this)
                    16 -> Flag16.getFlag(this)
                    17 -> Flag17.getFlag(this)
                    18 -> Flag18.getFlag(this)
                    19 -> Flag19.getFlag(this)
                    20 -> Flag20.getFlag(this)
                    21 -> Flag21.getFlag(this)
                    22 -> Flag22.getFlag(this)
                    23 -> Flag23.getFlag(this)
                    24 -> Flag24.getFlag(this)
                    25 -> Flag25.getFlag(this)
                    26 -> Flag26.getFlag(this)
                    27 -> Flag27.getFlag(this)
                    28 -> Flag28.getFlag(this)
                    29 -> Flag29.getFlag(this)
                    30 -> Flag30.getFlag(this)
                    31 -> Flag31.getFlag(this)
                    32 -> Flag32.getFlag(this)
                    33 -> Flag33.getFlag(this)
                    34 -> Flag34.getFlag(this)
                    35 -> Flag35.getFlag(this)
                    36 -> Flag36.getFlag(this)
                    37 -> Flag37.getFlag(this)
                    38 -> Flag38.getFlag(this)
                    39 -> Flag39.getFlag(this)
                    40 -> Flag40.getFlag(this)
                    41 -> Flag41.getFlag(this)
                }
            }
        }
    }
}

@Composable
fun IntentFireButton(onFlagClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(41) { index ->
            val flagNumber = index + 1
            Button(
                onClick = { onFlagClick(flagNumber) }
            ) {
                Text("Flag $flagNumber")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntentFireButtonPreview() {
    IntentAttackSurfaceTheme {
        IntentFireButton(onFlagClick = {})
    }
}
