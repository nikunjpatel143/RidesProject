package com.example.rides.datas

data class Vehicle(
    val car_options: List<String>,
    val car_type: String,
    val color: String,
    val doors: Int,
    val drive_type: String,
    val fuel_type: String,
    val id: Int,
    val kilometrage: Int,
    val license_plate: String,
    val make_and_model: String,
    val mileage: Int,
    val specs: List<String>,
    val transmission: String,
    val uid: String,
    val vin: String
)