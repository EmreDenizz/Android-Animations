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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
//        AnimButton("Transition Animation") {
//            navigateToActivity(Intent(context, TransitionAnimationActivity::class.java))
//        }
        AnimButton("Scale Animation") {
            navigateToActivity(Intent(context, ScaleAnimActivity::class.java))
        }
        AnimButton("Infinite Animation") {
            navigateToActivity(Intent(context, InfiniteAnimActivity::class.java))
        }
        AnimButton("Enter Exit Animation") {
            navigateToActivity(Intent(context, EnterExitAnimActivity::class.java))
        }
    }
}

@Composable
fun AnimButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}
