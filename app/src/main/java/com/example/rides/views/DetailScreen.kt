package com.example.rides.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun detailScreen(vehicleDetail: String) {


    val vehicleDetailList = vehicleDetail.split("_")
    val vin = vehicleDetailList[0]
    val model = vehicleDetailList[1]
    val color = vehicleDetailList[2]
    val type = vehicleDetailList[3]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "$vin",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center

        )
        Text(
            text = "$model",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$color",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$type",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )


    }
}

@Composable
@Preview(showBackground = true)
fun previewDetailScreen() {
    //detailScreen("")
}