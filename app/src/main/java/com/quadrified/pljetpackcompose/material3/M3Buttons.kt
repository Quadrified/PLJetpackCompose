package com.quadrified.pljetpackcompose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun M3Buttons(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Filled Button (Primary Button)
        Button(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Confirm")
        }

        Spacer(modifier = Modifier.padding(5.dp))

        // Elevated Button
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Confirm")
        }

        Spacer(modifier = Modifier.padding(5.dp))

        // Tonal Buttons
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Open in browser")
        }

        Spacer(modifier = Modifier.padding(5.dp))

        // Outlined Buttons
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "I have an existing account")
        }

        Spacer(modifier = Modifier.padding(5.dp))

        // Text Buttons
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn More")
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun M3ButtonsPreview() {
    M3Buttons()
}