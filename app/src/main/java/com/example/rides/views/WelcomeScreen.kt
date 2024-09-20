package com.example.rides.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun welcomeScreen(onClick: (numbersOfVehicle: String) -> Unit) {

    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(30.dp, 0.dp, 30.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            value = textValue,
            onValueChange = {
                textValue = it
            },
            label = {
                Text(
                    "Enter the number of vehicles", style = TextStyle(
                        color =
                        Color.LightGray
                    )
                )
            }
        )

        Button(modifier = Modifier.height(75.dp).width(150.dp),
            onClick = {
                if(textValue.isEmpty()){
                    textValue = "10"
                }
                onClick(textValue)
            }
        ) {
            Text(text = "Click Me", fontSize = 20.sp)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun previewWelcomeScreen() {
    // welcomeScreen(fun : ()->Unit)
}