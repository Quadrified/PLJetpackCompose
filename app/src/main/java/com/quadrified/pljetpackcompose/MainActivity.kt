package com.quadrified.pljetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.quadrified.pljetpackcompose.jcbasics.AllJetpackComposeBasics
import com.quadrified.pljetpackcompose.ui.theme.PLJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PLJetpackComposeTheme {
                Surface {
                    AllJetpackComposeBasics()
                }
            }
        }
    }
}
