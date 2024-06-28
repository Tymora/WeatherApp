package com.tymora.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tymora.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
               Surface {
                       Column(
                           modifier = Modifier.fillMaxSize(),
                           verticalArrangement   =  Arrangement.Center,
                           horizontalAlignment  =  Alignment.CenterHorizontally,){
                       CityInput()
                       ButtonGetCity(onClick = { getCityCoord("Москва") })
                   }
                }
            }
        }
    }
}

@Composable
fun CityInput() {
    var city by remember { mutableStateOf("") }

    OutlinedTextField(
        shape = RoundedCornerShape(16.dp),
        value = city,
        onValueChange = { city = it },
        label = { Text("Введите название города") }
    )
}

@Composable
fun ButtonGetCity(onClick: () -> Unit)  {
    FilledTonalButton(
        modifier  =  Modifier.padding(16.dp),
        colors = ButtonDefaults.filledTonalButtonColors().copy(containerColor = colorResource(R.color.teal_200).copy(alpha = 0.5f),),
        onClick = onClick
    ) {
        Text("Узнать погоду")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val count = remember{mutableStateOf(0)}
    WeatherAppTheme {
        Column(
        ){
            CityInput()
            ButtonGetCity(onClick = { count.value += 1 } )
        }

    }
}