package uz.farkhod.weather.android.auth.screens.main.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.farkhod.weather.android.R

import uz.farkhod.weather.android.core.domain.utils.getCurrentHumidity
import uz.farkhod.weather.android.core.domain.utils.getCurrentTemperature
import uz.farkhod.weather.android.core.domain.utils.getCurrentWeatherIcon
import uz.farkhod.weather.android.core.domain.utils.getCurrentWind
import uz.farkhod.weather.android.core.domain.utils.getWeatherNameFromCode
import uz.farkhod.weather.auth.main.data.MainDto

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawerHeader(
    weatherList: List<MainDto>?,
    onClick: (Int) -> Unit
) {

    Column(modifier = Modifier) {
        val gradientColors = listOf(
            Color(0xFF391A49),
            Color(0xFF301D5C),
            Color(0xFF262171),
            Color(0xFF301D5C),
            Color(0xFF391A49)
        )

        val gradient = Brush.linearGradient(
            colors = gradientColors,
            start = Offset(0f, 0f),
            end = Offset(1000f, 1000f), // Adjust as per need
            tileMode = TileMode.Clamp
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(all = 16.dp)

        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = "Saved Locations",
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.search_loupe),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                WeatherCard(
                    cityName = "Tashkent",
                    weatherCondition = "Sunny",
                    humidity = getCurrentHumidity(
                        weatherList?.get(0)?.hourly?.time,
                        weatherList?.get(0)?.hourly?.relative_humidity_2m
                    ),
                    windSpeed = getCurrentWind(
                        weatherList?.get(0)?.hourly?.time,
                        weatherList?.get(0)?.hourly?.wind_speed_10m
                    ),
                    temperature = getCurrentTemperature(
                        weatherList?.get(0)?.hourly?.time,
                        weatherList?.get(0)?.hourly?.temperature_2m
                    ),
                    weatherIcon = getCurrentWeatherIcon(
                        weatherList?.get(0)?.hourly?.time,
                        weatherList?.get(0)?.hourly?.weather_code
                    )

                ) { onClick(1) }
                Spacer(modifier = Modifier.height(24.dp))
                WeatherCard(
                    cityName = "Paris",
                    weatherCondition = getWeatherNameFromCode(
                        weatherList?.get(1)?.hourly?.time,
                        weatherList?.get(1)?.hourly?.weather_code
                    ),
                    humidity = getCurrentHumidity(
                        weatherList?.get(1)?.hourly?.time,
                        weatherList?.get(1)?.hourly?.relative_humidity_2m
                    ),
                    windSpeed = getCurrentWind(
                        weatherList?.get(1)?.hourly?.time,
                        weatherList?.get(1)?.hourly?.wind_speed_10m
                    ),
                    temperature = getCurrentTemperature(
                        weatherList?.get(1)?.hourly?.time,
                        weatherList?.get(1)?.hourly?.temperature_2m
                    ),
                    weatherIcon = getCurrentWeatherIcon(
                        weatherList?.get(1)?.hourly?.time,
                        weatherList?.get(1)?.hourly?.weather_code
                    )

                ) { onClick(2) }
                Spacer(modifier = Modifier.height(24.dp))
                WeatherCard(
                    cityName = "New York",
                    weatherCondition = getWeatherNameFromCode(
                        weatherList?.get(2)?.hourly?.time,
                        weatherList?.get(2)?.hourly?.weather_code
                    ),
                    humidity = getCurrentHumidity(
                        weatherList?.get(2)?.hourly?.time,
                        weatherList?.get(2)?.hourly?.relative_humidity_2m
                    ),
                    windSpeed = getCurrentWind(
                        weatherList?.get(2)?.hourly?.time,
                        weatherList?.get(2)?.hourly?.wind_speed_10m
                    ),
                    temperature = getCurrentTemperature(
                        weatherList?.get(2)?.hourly?.time,
                        weatherList?.get(2)?.hourly?.temperature_2m
                    ),
                    weatherIcon = getCurrentWeatherIcon(
                        weatherList?.get(2)?.hourly?.time,
                        weatherList?.get(2)?.hourly?.weather_code
                    )
                ) { onClick(3) }
            }
        }

        // Weather Card Example for Tashkent

    }
}

@Composable
fun WeatherCard(
    cityName: String,
    weatherCondition: String,
    humidity: Long?,
    windSpeed: Double?,
    temperature: Double?,
    weatherIcon: Painter,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(153.dp)
            .clickable { onClick() }, // Adjust the height if needed
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFFAAA5A5B2) // Semi-transparent white
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFAAA5A5B2)) // White background covering entire Row
                .padding(16.dp), // Padding applied after background
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = cityName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White // Ensure the text is readable
                )
                Text(text = weatherCondition, color = Color.White, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(22.dp))
                Text(text = "Humidity $humidity%", color = Color.White, fontSize = 12.sp)
                Text(text = "Wind ${windSpeed}km/h", color = Color.White, fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.End) {
                Image(
                    painter = weatherIcon,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$temperature°C",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White // Ensure the text is visible
                )
            }
        }
    }
}
