package com.example.rides.repository

import com.example.rides.datas.Vehicle
import com.example.rides.ridesApis.RidesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class RidesRepository @Inject constructor(private val ridesApi: RidesApi) {


    private val _vehicleData = MutableStateFlow<List<Vehicle>>(emptyList())
    public val vehicleData: StateFlow<List<Vehicle>> get() = _vehicleData.asStateFlow()

    suspend fun getVehicleData(numberOfVehicle :  String): String {
        val response = ridesApi.getVehicleList(numberOfVehicle)
        if (response.isSuccessful && response.body() != null) {
            val response = response.body()
            _vehicleData.emit(response!!)
        }
        return "No Data"
    }

}