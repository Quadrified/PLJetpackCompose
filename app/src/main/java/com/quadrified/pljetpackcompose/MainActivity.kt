package com.quadrified.pljetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quadrified.pljetpackcompose.ui.theme.PLJetpackComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Global => alive as long as the app
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("coroutine", "Dispatchers.Main: ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            // IO => For I/O operations, for API calls
            getAPIData()
            Log.d("coroutine", "Dispatchers.IO: ${Thread.currentThread().name}")

            // Switching context
            withContext(Dispatchers.Main) {
                // Update UI in "main" thread
                Log.d("coroutine", "Dispatchers.Main: ${Thread.currentThread().name}")
            }
        }

        GlobalScope.launch(Dispatchers.Default) {
            Log.d("coroutine", "Dispatchers.Default: ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d("coroutine", "Dispatchers.Unconfined: ${Thread.currentThread().name}")
        }

        // lifecycleScope => alive as long as the activity
//        lifecycleScope.launch {
//            Log.d("coroutine", "lifecycleScope: ${Thread.currentThread().name}")
//        }


        setContent {
            PLJetpackComposeTheme {
                Surface {

                }
            }
        }
    }

    private suspend fun getAPIData() {
        Log.d("coroutine", "start getting data 1")
        delay(4000)
        Log.d("coroutine", "got data 1")
    }

    private suspend fun getAPIData2() {
        Log.d("coroutine", "start getting data 2")
        delay(3000)
        Log.d("coroutine", "got data 2")
    }
}


@Preview(showSystemUi = true)
@Composable
fun Previews(modifier: Modifier = Modifier) {

}