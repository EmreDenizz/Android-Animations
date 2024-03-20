package com.example.mapd721_a3_emredeniz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.delay

class InfiniteAnimActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfiniteAnimation(onBackPressed = { onBackPressed() })
        }
    }
}

@Composable
fun InfiniteAnimation(onBackPressed: () -> Unit) {
    var size by remember { mutableStateOf(150.dp) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        BackButton(onBackPressed = onBackPressed)

        Spacer(modifier = Modifier.size(150.dp))

        ContinuousAnimatedCircle(size)
    }
}

@Composable
fun ContinuousAnimatedCircle(size: Dp) {
    var currSize by remember { mutableStateOf(size) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(currSize)
            .background(color = Color.Red, shape = CircleShape)
    ) {
        LaunchedEffect(Unit) {
            while (true) {
                currSize = size * 1.2f
                delay(500)
                currSize = size
                delay(500)
            }
        }
    }
}
