// Emre Deniz
// Adv. Android - Assignment 3

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
        modifier = Modifier.padding(20.dp)
    ) {
        BackButton(onBackPressed = onBackPressed)

        Spacer(modifier = Modifier.size(200.dp))

        ContinuousAnimatedCircle(size)
    }
}

@Composable
fun ContinuousAnimatedCircle(size: Dp) {
    var currSize by remember { mutableStateOf(size) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(currSize)
            .background(color = Color.Black, shape = CircleShape)
    ) {
        LaunchedEffect(Unit) {
            while (true) {
                currSize = size * 1.2f
                delay(750)
                currSize = size
                delay(750)
            }
        }
    }
}
