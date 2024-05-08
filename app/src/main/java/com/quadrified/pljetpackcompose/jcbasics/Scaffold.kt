package com.quadrified.pljetpackcompose.jcbasics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val scaffoldState = remember { SnackbarHostState() }
    var textValue by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textValue,
                onValueChange = { textValue = it },
                label = {
                    Text(text = "Enter text")
                },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.showSnackbar("Hello $textValue")
                }
            }) {
                Text(text = "Show Greeting!")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldExamplePreview() {
    ScaffoldExample()
}