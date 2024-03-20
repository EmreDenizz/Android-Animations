// Emre Deniz
// Adv. Android - Assignment 3

package com.example.mapd721_a3_emredeniz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class TransitionAnimActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransitionAnimationScreen(onBackPressed = { onBackPressed() })
        }
    }
}

@Composable
fun TransitionAnimationScreen(onBackPressed: () -> Unit) {
    var showRocket by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        BackButton(onBackPressed = onBackPressed)

        AnimatedVisibility(
            visible = !showRocket,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LaunchButton(onClick = { showRocket = true })
        }

        AnimatedVisibility(
            visible = showRocket,
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
        ) {
            Animation(onClick = { showRocket = false })
        }
    }
}

@Composable
fun LaunchButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Launch Rocket")
    }
}

@Composable
fun Animation(onClick: () -> Unit) {
    val offsetY by animateDpAsState(
        targetValue = (-200).dp,
        animationSpec = tween(durationMillis = 3000)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.Transparent)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = onClick) {
                Text(text = "Land Rocket")
            }
        }

        Image(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = "Rocket",
            modifier = Modifier.offset(y = offsetY).height(200.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}
