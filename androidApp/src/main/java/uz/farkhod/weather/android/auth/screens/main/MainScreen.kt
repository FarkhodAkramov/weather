package uz.farkhod.weather.android.auth.screens.main

import ProgressBar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.farkhod.weather.android.R
import uz.farkhod.weather.android.auth.screens.main.components.HumburgerButton
import uz.farkhod.weather.android.core.domain.utils.SharedPref
import uz.farkhod.weather.android.core.domain.utils.WeatherForecastDay
import uz.farkhod.weather.android.core.domain.utils.backgroundImage
import uz.farkhod.weather.android.core.domain.utils.getCurrentHumidity
import uz.farkhod.weather.android.core.domain.utils.getCurrentTemperature
import uz.farkhod.weather.android.core.domain.utils.getCurrentWeatherIcon
import uz.farkhod.weather.android.core.domain.utils.getCurrentWind
import uz.farkhod.weather.android.core.domain.utils.getWeatherNameFromCode
import uz.farkhod.weather.auth.main.presentation.MainEvent
import uz.farkhod.weather.auth.main.presentation.MainState
import java.time.LocalDateTime
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(
    state: MainState, onEvent: (MainEvent) -> Unit
) {

    val context = LocalContext.current

    val cntCode = SharedPref.getCountryCode(context)

    LaunchedEffect(key1 = Unit, key2 = state.cntCode) {
        val currentTime = LocalDateTime.now()  // This includes both date and time
        println("current time $currentTime")
        val updateDateFormatter =
            DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a") // Correct format
        val formattedDate = currentTime.format(updateDateFormatter)
        onEvent(MainEvent.GetArguments(cntCode, formattedDate))
    }




    val currentDate = LocalDate.now()
    val formatter =
        DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH)

    val formattedDate = currentDate.format(formatter)

    if (!state.isRequesting) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black) // Set a background color if needed
        ) {
            // Background Image
            Image(
                painter = backgroundImage(cntCount = state.cntCode), // Replace with your image resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // UI elements layered on top of the background image
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Location row with icon and text
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Hamburger menu button
                    HumburgerButton(
                        onClick = {
                            onEvent(MainEvent.DrawerClick)
                        },
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(id = R.drawable.location_icon), // Replace with your location icon
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = state.cntName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.White
                    )

                }

                Spacer(modifier = Modifier.height(32.dp))

                // Date and Time
                Text(
                    text = formattedDate,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Updated ${state.date}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Weather Icon and Temperature
                Column(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = getCurrentWeatherIcon(
                            state.weatherList?.get(state.cntCode)?.hourly?.time,
                            state.weatherList?.get(state.cntCode)?.hourly?.weather_code
                        ), // Replace with your weather icon
                        contentDescription = null,
                        modifier = Modifier.size(96.dp),

                        )
                    Text(
                        text = getWeatherNameFromCode(
                                state.weatherList?.get(state.cntCode)?.hourly?.time,
                                state.weatherList?.get(state.cntCode)?.hourly?.weather_code
                            ),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "${
                            getCurrentTemperature(
                                state.weatherList?.get(state.cntCode)?.hourly?.time,
                                state.weatherList?.get(state.cntCode)?.hourly?.temperature_2m
                            )
                        }°C",
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Additional Weather Info
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.humidity_icon), // Replace with your icon
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "HUMIDITY",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = "${
                                getCurrentHumidity(
                                    state.weatherList?.get(state.cntCode)?.hourly?.time,
                                    state.weatherList?.get(state.cntCode)?.hourly?.relative_humidity_2m
                                )
                            }%" ?: "NO data",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.wind_icon), // Replace with your icon
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "WIND",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = "${
                                getCurrentWind(
                                    state.weatherList?.get(state.cntCode)?.hourly?.time,
                                    state.weatherList?.get(state.cntCode)?.hourly?.wind_speed_10m
                                )
                            } km/h",
                            color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium,

                            )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.feels_like_icon), // Replace with your icon
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "FEELS LIKE",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = "${
                                getCurrentTemperature(
                                    state.weatherList?.get(state.cntCode)?.hourly?.time,
                                    state.weatherList?.get(state.cntCode)?.hourly?.temperature_2m
                                )
                            }°", color = Color.White, fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Forecast Row
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(
                            Color(0x83535353),
                            shape = RoundedCornerShape(24.dp)
                        ) // Set background color and border radius
                        .padding(16.dp), // Padding inside the row
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    item {
                        state.weatherList?.get(state.cntCode)?.hourly?.time?.forEachIndexed { index, s ->
                            val weather = state.weatherList?.get(state.cntCode)
                            val currentTime = LocalDateTime.now()

                            // Define the formatter used in the timeList ("yyyy-MM-dd'T'HH:mm")
                            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

                            val time = LocalDateTime.parse(s, formatter)
                            if (index!=0){

                                val oldTime = LocalDateTime.parse( state.weatherList?.get(state.cntCode)?.hourly?.time!![index-1], formatter)
                                time.dayOfMonth!=oldTime.dayOfMonth
                                println("TIMEEEE${time.dayOfMonth }${oldTime.dayOfMonth}")
                                if (time.dayOfMonth!=oldTime.dayOfMonth) {
                                    if (state.weatherList?.get(state.cntCode)?.hourly?.time!![index-1]!=s)
                                        weather?.hourly?.temperature_2m?.getOrNull(index)
                                            ?.let { temperature ->
                                                weather.hourly.weather_code.getOrNull(index)
                                                    ?.let { code ->
                                                        weather.hourly.wind_speed_10m.getOrNull(index)
                                                            ?.let { wind ->
                                                                WeatherForecastDay(
                                                                    "${time.dayOfMonth}.${time.monthValue}",
                                                                    temperature,
                                                                    wind,
                                                                    code
                                                                )

                                                            }

                                                    }

                                            }
                                }
                            }

                        }


                    }


                }
            }
        }

    }

    if (state.isRequesting) {
        ProgressBar()
    }

}




