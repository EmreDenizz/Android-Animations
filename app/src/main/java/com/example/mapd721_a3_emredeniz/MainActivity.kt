// Emre Deniz
// Adv. Android - Assignment 3

package com.example.mapd721_a3_emredeniz

import android.content.Intent
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationButtons(this) { intent ->
                startActivity(intent)
            }
        }
    }
}

@Composable
fun AnimationButtons(context: Context, navigateToActivity: (Intent) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(10.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // Transition Animation button
        AnimButton("Transition Animation") {
            navigateToActivity(Intent(context, TransitionAnimActivity::class.java))
        }
        Spacer(modifier = Modifier.size(5.dp))

        // Scale Animation button
        AnimButton("Scale Animation") {
            navigateToActivity(Intent(context, ScaleAnimActivity::class.java))
        }
        Spacer(modifier = Modifier.size(5.dp))

        // Infinite Animation button
        AnimButton("Infinite Animation") {
            navigateToActivity(Intent(context, InfiniteAnimActivity::class.java))
        }
        Spacer(modifier = Modifier.size(5.dp))

        // Enter Exit Animation button
        AnimButton("Enter Exit Animation") {
            navigateToActivity(Intent(context, EnterExitAnimActivity::class.java))
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun AnimButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text)
        }
    }
}
