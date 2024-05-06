package com.quadrified.pljetpackcompose.crashcourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quadrified.pljetpackcompose.ui.theme.PLJetpackComposeTheme

@Composable
fun StateUIExample() {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = name,
                label = { Text(text = "Enter Name") },
                onValueChange = { text ->
                    name = text
                })
            Button(
                onClick = {
                    if (name.isNotEmpty()) {
                        names = names + name
                        name = ""
                    }
                }) {
                Text(text = "Add")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn() {
            items(names) { currentName ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = currentName,
                    fontSize = 18.sp
                )
                Divider()
            }
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun StateUIExamplePreview() {
    PLJetpackComposeTheme {
        StateUIExample()
    }
}
