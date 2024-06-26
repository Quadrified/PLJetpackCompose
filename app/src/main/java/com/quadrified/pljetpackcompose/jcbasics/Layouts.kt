package com.quadrified.pljetpackcompose.jcbasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Layouts(modifier: Modifier = Modifier) {
//    ColumnExample()
    RowExample()
}

@Composable
fun ColumnExample(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5FFEF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Green)
        )
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Blue)
        )

    }
}

@Composable
fun RowExample(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Green)
        )
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LayoutsPreview() {
    Layouts()
}