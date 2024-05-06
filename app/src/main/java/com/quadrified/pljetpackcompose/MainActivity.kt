package com.quadrified.pljetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.quadrified.pljetpackcompose.jcbasics.AllJetpackComposeBasics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllJetpackComposeBasics()
        }
    }
}
