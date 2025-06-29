package com.tymora.weatherapp


import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import com.tymora.weatherapplication.ApiWeather.data.CurrentWeatherResp
import com.tymora.weatherapp.data.CurrentCityResp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface OpenWeatherApi {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"

        val instance: OpenWeatherApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenWeatherApi::class.java)
        }
    }

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): CurrentWeatherResp

    @GET("geo/1.0/direct")
    suspend fun getCoord(
        @Query("q") cityName: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): CurrentCityResp

}


