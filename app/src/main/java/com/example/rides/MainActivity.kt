package com.example.rides

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rides.views.detailScreen
import com.example.rides.views.mainScreen
import com.example.rides.views.welcomeScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable(route = "welcomeScreen"){
            welcomeScreen{
                navController.navigate("mainScreen/${it}")
            }
        }

        composable(route = "mainScreen/{numbersOfVehicle}", arguments = listOf(
            navArgument("numbersOfVehicle"){
                type = NavType.StringType
            }
        )){ it ->
            val number = it.arguments!!.getString("numbersOfVehicle")
            mainScreen(number!!){ it ->
                navController.navigate("detailScreen/$it")
            }

        }
        composable(route = "detailScreen/{vehicleDetail}", arguments = listOf(
            navArgument("vehicleDetail"){
                type= NavType.StringType
            },

        )){
            val vehicleDetail = it.arguments!!.getString("vehicleDetail")
            detailScreen(vehicleDetail!!)
        }

    }
}


