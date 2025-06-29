package com.tymora.weatherapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import com.tymora.weatherapp.data.CurrentCityRespItem
import kotlinx.coroutines.launch


@Composable
fun WeatherScreen(navController: NavHostController) {
    var cityData by remember { mutableStateOf<CurrentCityRespItem?>(null) }
    var cityInput by remember { mutableStateOf("") }
    var cityTemp by remember { mutableStateOf<Double?>(null) }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        CityInput(
            city = cityInput,
            onCityChange = { cityInput = it }
        )
        ButtonGetCity(
            onClick = {
                scope.launch {
                    val response =
                        OpenWeatherApi.instance.getCoord(cityName = cityInput)
                    cityData = response.firstOrNull()
                    val weather = OpenWeatherApi.instance.getWeather(
                        cityData?.lat ?: 0.0, cityData?.lon ?: 0.0
                    )
                    cityTemp = weather.main.temp
                }
            }
        )
        ResultCityWeather(cityData, cityTemp)
    }
}

@Composable
fun ButtonGetCity(onClick: () -> Unit) {
    FilledTonalButton(
        modifier = Modifier.wrapContentWidth(),
        colors = ButtonDefaults.filledTonalButtonColors()
            .copy(containerColor = colorResource(R.color.teal_200).copy(alpha = 0.5f)),
        onClick = onClick
    ) {
        Text("Узнать погоду", style = TextStyle(fontSize = 24.sp))
    }
}

@Composable
fun ResultCityWeather(city: CurrentCityRespItem?, cityTemp: Double?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Координаты: lon - ${city?.lon ?: "Неизвестно"}, lat = ${city?.lat ?: "Неизвестно"}",
            style = TextStyle(fontSize = 24.sp)
        )
        Text(
            text = "Температура: ${cityTemp ?: "Неизвестно"} °C",
            style = TextStyle(fontSize = 24.sp)

        )

    }
}

@Composable
fun CityInput(city: String, onCityChange: (String) -> Unit) {

    OutlinedTextField(
        textStyle = TextStyle(fontSize = 24.sp),
        shape = RoundedCornerShape(16.dp),
        value = city,
        onValueChange = onCityChange,
        label = { Text("Введите название города", fontSize = 20.sp) },
        modifier = Modifier.wrapContentWidth()
    )
}