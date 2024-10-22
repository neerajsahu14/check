package com.example.check

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.check.ui.theme.CheckTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckTheme {

                MyComposable2()
//                 val section = listOf( "A", "B", "C", "D", "E", "F")
//                LazyColumn( //modifier = Modifier.background(Color.Gray),
//                    contentPadding = PaddingValues(12.dp),
//                    verticalArrangement = Arrangement.spacedBy(12.dp)) {
//                    section.forEach{
//                        stickyHeader {
//                            Text( modifier = Modifier.fillMaxSize()
//                                .background(Color.Gray)
//                                .padding(12.dp),
//                                text = "Header $it",
//                                style = MaterialTheme.typography.labelMedium,
//                                color = Color.Black
//                            )
//                        }
//                        items(10) {
//                            Text("item $it from section $it")
//                        }
//                    }
//                }
            }
        }
        CoroutineScope(Dispatchers.Main).launch {
            val result = withContext(Dispatchers.IO) {
                // Perform heavy computation here
                heavyComputation()
            }
            // Update UI with the result
            updateUI(result)
        }
    }

    private fun heavyComputation(): String {
        // Simulate heavy computation
        Thread.sleep(2000)
        return "Computation Result"
    }

    private fun updateUI(result: String) {
        // Update UI with the result
    }
}

@Composable
fun TextFieldDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("type something....") }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text("Label")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("TextFieldDemo", "Search clicked")
                }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("TextFieldDemo", " keyboard Search clicked")
                }
            )
        )
    }
}

@Composable
fun MyComposable(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){  var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name,
            onValueChange ={newName -> name = newName},
            label = { Text(text="name")},
            placeholder = { Text(text="Enter your name")},
            maxLines = 1
        )
    }
}
@Composable
fun MyComposable2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var name by remember { mutableStateOf("") }
        val maxChar = 10
        OutlinedTextField(
            value = name,
            onValueChange = {
                if (it.length <= maxChar) {
                    name = it
                }
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckTheme {
        GradientButton();
    }
}