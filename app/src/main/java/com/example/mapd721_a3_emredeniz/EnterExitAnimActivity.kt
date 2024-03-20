package com.example.mapd721_a3_emredeniz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

class EnterExitAnimActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnterExitAnimation(onBackPressed = { onBackPressed() })
        }
    }
}

@Composable
fun EnterExitAnimation(onBackPressed: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        BackButton(onBackPressed = onBackPressed)

        Spacer(modifier = Modifier.size(200.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(animationSpec = tween(durationMillis = 3000)),
            exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut(animationSpec = tween(durationMillis = 3000))
        ) {
            AnimatedImage()
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = { isVisible = !isVisible }
        ) {
            Text(if (isVisible) "Press for Exit Animation" else "Press for Enter Animation")
        }
    }
}

@Composable
fun AnimatedImage() {
    var size by remember { mutableStateOf(200.dp) }
    val transition = updateTransition(targetState = size, label = "")
    val sizeValue by transition.animateDp(
        transitionSpec = { keyframes { durationMillis = 2500 } }
    ) { targetSize -> targetSize }

    Image(
        painter = painterResource(id = R.drawable.fruit),
        contentDescription = null,
        modifier = Modifier
            .size(sizeValue)
            .border(1.dp, Color.Black, CircleShape)
    )
}
