package uz.farkhod.weather.android.core.domain.utils

import android.os.Build

import androidx.annotation.RequiresApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.farkhod.weather.android.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecastDay(day: String?, temperature: Double?, windSpeed: Double?, weatherCode: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(60.dp)) {
        Text(
            text = day?.substring((day?.length ?: 10) - 5) ?: "",
            fontSize = 14.sp,
            color = Color.White
        )
        Image(
            painter = getWeatherIcon(weatherCode),
            contentDescription = "",
            modifier = Modifier.size(24.dp),

            )
        Text(text = "${temperature}°" ?: "", fontSize = 16.sp, color = Color.White)
        Text(text = "${windSpeed} km/h" ?: "", fontSize = 12.sp, color = Color.White)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentTemperature(timeList: List<String>?, temperatureList: List<Double>?): Double? {
    // Get the current time
    val currentTime = LocalDateTime.now()

    // Define the formatter used in the timeList ("yyyy-MM-dd'T'HH:mm")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val formattedDate = currentTime.format(formatter)

    // Find the closest matching time in the list
    val index = timeList?.indexOfFirst { timeString ->
        val timeFromList = LocalDateTime.parse(timeString, formatter)
        ChronoUnit.HOURS.between(currentTime, timeFromList) == 0L
    }
    // Return the temperature at the found index, or null if not found
    return if (index != -1) index?.let { temperatureList?.get(it) } else null
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentWind(timeList: List<String>?, windList: List<Double>?): Double? {
    // Get the current time
    val currentTime = LocalDateTime.now()

    // Define the formatter used in the timeList ("yyyy-MM-dd'T'HH:mm")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val formattedDate = currentTime.format(formatter)

    // Find the closest matching time in the list
    val index = timeList?.indexOfFirst { timeString ->
        val timeFromList = LocalDateTime.parse(timeString, formatter)
        ChronoUnit.HOURS.between(currentTime, timeFromList) == 0L
    }
    // Return the temperature at the found index, or null if not found
    return if (index != -1) index?.let { windList?.get(it) } else null
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentHumidity(timeList: List<String>?, humidityList: List<Long>?): Long? {
    // Get the current time
    val currentTime = LocalDateTime.now()

    // Define the formatter used in the timeList ("yyyy-MM-dd'T'HH:mm")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val formattedDate = currentTime.format(formatter)

    // Find the closest matching time in the list
    val index = timeList?.indexOfFirst { timeString ->
        val timeFromList = LocalDateTime.parse(timeString, formatter)
        ChronoUnit.HOURS.between(currentTime, timeFromList) == 0L
    }
    // Return the temperature at the found index, or null if not found
    return if (index != -1) index?.let { humidityList?.get(it) } else null
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getCurrentWeatherIcon(timeList: List<String>?, humidityList: List<Int>?): Painter {
    // Get the current time
    val currentTime = LocalDateTime.now()

    // Define the formatter used in the timeList ("yyyy-MM-dd'T'HH:mm")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

    // Find the closest matching time in the list
    val index = timeList?.indexOfFirst { timeString ->
        val timeFromList = LocalDateTime.parse(timeString, formatter)
        ChronoUnit.HOURS.between(currentTime, timeFromList) == 0L
    }

    // Get the humidity value at the found index
    val humidity = if (index != -1 && index != null) {
        humidityList?.get(index)
    } else {
        null
    }

    // Return corresponding icon based on humidity level (or other weather codes)
    return when(humidity) {
        0 -> painterResource(id = R.drawable.ic_default)
        1, 2, 3 -> painterResource(id = R.drawable.fog)
        45, 48 -> painterResource(id = R.drawable.fog)
        51, 53, 55 -> painterResource(id = R.drawable.thunder_shower)
        56, 57 -> painterResource(id = R.drawable.thunder_shower)
        61, 63, 65 -> painterResource(id = R.drawable.ic_rain)
        66, 67 -> painterResource(id = R.drawable.thunder_shower)
        71, 73, 75 -> painterResource(id = R.drawable.snow)
        77 -> painterResource(id = R.drawable.snow)
        80, 81, 82 -> painterResource(id = R.drawable.thunder_shower)
        85, 86 ->  painterResource(id = R.drawable.snow)
        95 -> painterResource(id = R.drawable.thunder_shower)
        96, 99 -> painterResource(id = R.drawable.thunder_shower)
        else -> painterResource(id = R.drawable.yang_sha_11)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getWeatherIcon(code: Int): Painter {


    return when(code) {

        0 -> painterResource(id = R.drawable.ic_default)
        1, 2, 3 -> painterResource(id = R.drawable.fog)
        45, 48 -> painterResource(id = R.drawable.fog)
        51, 53, 55 -> painterResource(id = R.drawable.thunder_shower)
        56, 57 -> painterResource(id = R.drawable.thunder_shower)
        61, 63, 65 -> painterResource(id = R.drawable.ic_rain)
        66, 67 -> painterResource(id = R.drawable.thunder_shower)
        71, 73, 75 -> painterResource(id = R.drawable.snow)
        77 -> painterResource(id = R.drawable.snow)
        80, 81, 82 -> painterResource(id = R.drawable.thunder_shower)
        85, 86 ->  painterResource(id = R.drawable.snow)
        95 -> painterResource(id = R.drawable.thunder_shower)
        96, 99 -> painterResource(id = R.drawable.thunder_shower)
        else -> painterResource(id = R.drawable.yang_sha_11)
    }
}


@Composable
fun backgroundImage(cntCount: Int): Painter {
    return when (cntCount) {
        1 -> painterResource(id = R.drawable.tashkent)
        2 -> painterResource(id = R.drawable.paris)
        3 -> painterResource(id = R.drawable.newyork)
        else -> painterResource(id = R.drawable.newyork)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getWeatherNameFromCode(timeList: List<String>?, humidityList: List<Int>?): String {

    val currentTime = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val index = timeList?.indexOfFirst { timeString ->
        val timeFromList = LocalDateTime.parse(timeString, formatter)
        ChronoUnit.HOURS.between(currentTime, timeFromList) == 0L
    }
    val humidity = if (index != -1 && index != null) {
        humidityList?.get(index)
    } else {
        null
    }

    return when (humidity) {
        0 -> "Clear sky"
        1, 2, 3 -> "Partly cloudy"
        45, 48 -> "Fog"
        51, 53, 55 -> "Drizzle"
        56, 57 -> "Freezing drizzle"
        61, 63, 65 -> "Rain"
        66, 67 -> "Freezing rain"
        71, 73, 75 -> "Snow fall"
        77 -> "Snow grains"
        80, 81, 82 -> "Rain showers"
        85, 86 -> "Snow showers"
        95 -> "Thunderstorm"
        96, 99 -> "Thunderstorm with hail"
        else -> "Unknown weather"
    }
}
