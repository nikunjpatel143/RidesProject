package com.example.rides.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rides.datas.Vehicle
import com.example.rides.repository.RidesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RidesViewModel @Inject constructor(private val ridesRepository: RidesRepository) : ViewModel(){

    public val vehicleData : StateFlow<List<Vehicle>> get() =  ridesRepository.vehicleData

    fun getVehicleList(numberOfVehicle: String){
        viewModelScope.launch {
            ridesRepository.getVehicleData(numberOfVehicle)
        }
    }

}