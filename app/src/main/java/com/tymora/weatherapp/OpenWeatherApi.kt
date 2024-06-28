package com.tymora.weatherapp

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import com.tymora.weatherapplication.ApiWeather.data.CurrentWeatherResp

interface OpenWeatherApi {

    @GET("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}")
    suspend fun getMoviesList(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Header("X-API-KEY") apiKey: String = API_KEY
    ): CurrentWeatherResp

    companion object{

        const val API_KEY = ""
    }
}