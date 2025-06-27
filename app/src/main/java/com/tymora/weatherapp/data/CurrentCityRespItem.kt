package com.tymora.weatherapp.data

data class CurrentCityRespItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)