package com.quadrified.pljetpackcompose.jcbasics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
fun ComposeState() {
    var color by remember {
        mutableStateOf(Color.Magenta)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color)
        .clickable {
            color = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            )
        })
}

@Preview(showSystemUi = true)
@Composable
fun ComposeStatePreview() {
    ComposeState()
}