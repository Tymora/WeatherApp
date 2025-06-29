package com.tymora.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.tymora.weatherapp.data.CurrentCityRespItem
import com.tymora.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherAppNavigation()
                }
            }
        }
    }
}

//@Composable
//fun CityInput(city: String, onCityChange: (String) -> Unit) {
//
//    OutlinedTextField(
//        textStyle = TextStyle(fontSize = 24.sp),
//        shape = RoundedCornerShape(16.dp),
//        value = city,
//        onValueChange = onCityChange,
//        label = { Text("Введите название города", fontSize = 20.sp) },
//        modifier = Modifier.wrapContentWidth()
//    )
//}

//@Composable
//fun ButtonGetCity(onClick: () -> Unit) {
//    FilledTonalButton(
//        modifier = Modifier.wrapContentWidth(),
//        colors = ButtonDefaults.filledTonalButtonColors()
//            .copy(containerColor = colorResource(R.color.teal_200).copy(alpha = 0.5f)),
//        onClick = onClick
//    ) {
//        Text("Узнать погоду", style = TextStyle(fontSize = 24.sp))
//    }
//}


//@Composable
//fun ResultCityWeather(city: CurrentCityRespItem?, cityTemp: Double?) {
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        Text(
//            "Координаты: lon - ${city?.lon ?: "Неизвестно"}, lat = ${city?.lat ?: "Неизвестно"}",
//            style = TextStyle(fontSize = 24.sp)
//        )
//        Text(
//            text = "Температура: ${cityTemp ?: "Неизвестно"} °C",
//            style = TextStyle(fontSize = 24.sp)
//
//        )
//
//    }
//}



