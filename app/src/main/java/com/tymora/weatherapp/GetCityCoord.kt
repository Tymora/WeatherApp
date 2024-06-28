package com.tymora.weatherapp

import android.location.Location

fun getCityCoord(city: String):Unit {
    var lat = Location(city).latitude
    var long = Location(city).longitude


}