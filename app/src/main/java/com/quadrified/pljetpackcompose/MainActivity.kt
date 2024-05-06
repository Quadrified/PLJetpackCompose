package com.quadrified.pljetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quadrified.pljetpackcompose.ui.theme.PLJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ComposeItems(name = "Omer Quadri")
            // ComposableState()
            FinalUI()

        }
    }
}

@Composable
fun FinalUI() {
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

@Preview(showBackground = true)
@Composable
fun FinalUIPreview() {
    PLJetpackComposeTheme {
        FinalUI()
    }
}

@Composable
fun ComposeItems(name: String) {
    // Layouts in Jetpack Compose
    // LayoutsInCompose("Column", name)

    // Images in Jetpack Compose
    // ImagesInCompose(name)

    // Lists in Jetpack Compose
    // ListsInCompose()

}

@Composable
fun LayoutsInCompose(type: String = "Column", name: String = "World") {
    when (type) {
        "Column" -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Hello $name!", color = Color.Blue, fontSize = 30.sp
            )
            Text(
                text = "Some Other Text!", color = Color.Blue, fontSize = 30.sp
            )
        }

        "Row" -> Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Hello $name!", color = Color.Blue, fontSize = 30.sp
            )
            Text(
                text = "Some Other Text!", color = Color.Blue, fontSize = 30.sp
            )
        }

        "Box" -> Box(
            modifier = Modifier.size(400.dp)
        ) {
            Text(
                text = "Hello $name!",
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
            Text(
                text = "Some Other Text!", color = Color.Blue, fontSize = 30.sp
            )
        }
    }

}

@Composable
fun ImagesInCompose(name: String = "Omer") {
    if (name.length > 5) {
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier.size(100.dp)
        )
    } else {

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp, 300.dp)
                .fillMaxWidth()
                .background(Color.Red)
        )
    }
}

@Composable
fun ListsInCompose() {
    val fruits = listOf(
        "Apple",
        "Banana",
        "Orange",
        "Mango",
        "Pineapple",
        "Watermelon",
        "Cherry",
        "Strawberry",
        "Grapes",
        "Peach",
        "Pear",
        "Lemon",
        "Pineapplew",
        "Watermelonw",
        "Cherryw",
        "Strawbwerry",
        "Grapesw",
        "Peacsh",
        "Pears",
        "Lemosn",
        "Pineaspple",
        "Watermelon",
        "Cherrsy",
        "Strawaberry",
        "Grapses",
        "Peacdh",
        "Peadr",
        "Lemxon",
        "Wemon",
        "Pineapplew",
        "Watermelonw",
        "Cherryw",
        "Strawbwerry",
        "Grapesw",
        "Peacsh",
        "Pears",
        "Lemosn",
        "Pineaspple",
        "Watermelon",
        "Cherrsy",
        "Strawaberry",
        "Grapses",
        "Peacdh",
        "Peadr",
        "Lemxon",
    )

    Column {
        LazyRow {
            items(fruits) { fruit ->
                Text(text = fruit, fontSize = 20.sp)
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .background(Color.LightGray)
                )
            }
        }

        LazyColumn(
            modifier = Modifier.background(Color.White)
        ) {
            items(fruits) { fruit ->
                Text(text = fruit, fontSize = 20.sp)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray)
                )
            }
        }

    }

}

@Composable
fun ComposableState() {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = count.toString(), fontSize = 30.sp)
        Button(onClick = {
            count++
        }) {
            Text(text = "Click Me!")
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeItemsPreview() {
    PLJetpackComposeTheme {
        ComposeItems("Omer Quadri")
    }
}

