package com.quadrified.pljetpackcompose.jcbasics

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimations() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
        label = "",
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 300,
            easing = EaseInOut
        )
//        animationSpec = spring(
//            Spring.DampingRatioHighBouncy
//        )
//        animationSpec = keyframes {
//            durationMillis = 5000
//            sizeState at 0 using LinearEasing
//            sizeState * 1.5f at 1000 using FastOutSlowInEasing
//            sizeState * 2f at 5000
//        }
    )

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        label = "",
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(tween(2000), RepeatMode.Reverse),
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "Increase Size")
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SimpleAnimationsPreview() {
    SimpleAnimations()
}