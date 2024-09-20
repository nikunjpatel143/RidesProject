package com.example.rides.ridesApis

import com.example.rides.datas.Vehicle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RidesApi {

    @GET("/api/vehicle/random_vehicle")
    suspend fun getVehicleList(@Query("size") title: String): Response<List<Vehicle>>
}