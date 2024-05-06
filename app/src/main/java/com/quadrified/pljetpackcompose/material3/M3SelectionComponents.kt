package com.quadrified.pljetpackcompose.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun M3SelectionComponents(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // M3 Checkboxes
        Checkboxes()

        Spacer(modifier = Modifier.height(16.dp))

        // M3 Switch
        Switches()

    }

}

@Preview(showSystemUi = true)
@Composable
fun M3SelectionComponentsPreview() {
    M3SelectionComponents()
}

data class ToggleableInfo(
    val isChecked: Boolean, val text: String
)

@Composable
fun Checkboxes() {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo(
                isChecked = false, text = "Photos"
            ),
            ToggleableInfo(
                isChecked = false, text = "Videos"
            ),
            ToggleableInfo(
                isChecked = false, text = "Audio"
            ),
        )
    }


    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }

    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkboxes.indices.forEach { index ->
            checkboxes[index] = checkboxes[index].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleTriState() }) {

        TriStateCheckbox(state = triState, onClick = toggleTriState)
        Text(text = "File Types")
    }


    checkboxes.forEachIndexed { index, info ->
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkboxes[index] = info.copy(
                        isChecked = !info.isChecked
                    )
                }
                .padding(end = 16.dp)) {

            Checkbox(checked = info.isChecked, onCheckedChange = { isChecked ->
                checkboxes[index] = info.copy(
                    isChecked = isChecked
                )
            })
            Text(text = info.text)

        }
    }
}

@Composable
fun Switches() {
    var switch by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = false, text = "Dark Mode"
            )
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.clickable {
            switch = switch.copy(isChecked = !switch.isChecked)
        }
    ) {
        Text(text = switch.text)
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = switch.isChecked, onCheckedChange = { isChecked ->
            switch = switch.copy(
                isChecked = isChecked
            )
        })

    }
}