// Emre Deniz
// Adv. Android - Assignment 3

package com.example.mapd721_a3_emredeniz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

class ScaleAnimActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaleAnimationScreen(onBackPressed = { onBackPressed() })
        }
    }
}

@Composable
fun ScaleAnimationScreen(onBackPressed: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(30.dp)
    ) {
        BackButton(onBackPressed = onBackPressed)

        Spacer(modifier = Modifier.size(150.dp))

        ScaleButton()
    }
}

@Composable
fun ScaleButton() {
    var scale by remember { mutableStateOf(1f) }

    Button(
        onClick = { scale = if (scale == 1f) 1.3f else 1f },
        modifier = Modifier.scale(scale)
    ) {
        Text("Click me to animate")
    }
}

@Composable
fun BackButton(onBackPressed: () -> Unit) {
    Button(onClick = onBackPressed) {
        Text("Back")
    }
}
