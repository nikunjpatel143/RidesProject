package com.example.rides.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rides.datas.Vehicle
import com.example.rides.viewModels.RidesViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider


@Composable
fun mainScreen(numbersOfVehicle: String, onClick: (vehicleDetail: String) -> Unit) {

    val ridesViewMode: RidesViewModel = hiltViewModel()
    ridesViewMode.getVehicleList(numbersOfVehicle)
    val values: State<List<Vehicle>> = ridesViewMode.vehicleData.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        LazyColumn {
            items(values.value) { item ->

                Box(modifier = Modifier
                    .padding(30.dp, 0.dp, 30.dp, 0.dp)
                    .clickable {
                        val sb: StringBuilder = StringBuilder()
                        sb.append(item.vin)
                        sb.append("_")
                        sb.append(item.make_and_model)
                        sb.append("_")
                        sb.append(item.color)
                        sb.append("_")
                        sb.append(item.car_type)
                        onClick(sb.toString())

                        Log.d("Hello", "Hello: click = ${sb.toString()}")
                    }) {
                    Column {
                        Text(
                            text = "${item.make_and_model}",
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "${item.vin}",
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 10.sp,
                            color = Color.DarkGray
                        )
                    }
                }
                Divider(color = Color.LightGray, thickness = 1.dp)

            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun previewMainScreen() {
    //mainScreen("")
}