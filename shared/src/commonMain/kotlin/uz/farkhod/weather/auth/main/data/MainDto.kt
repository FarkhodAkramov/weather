package uz.farkhod.weather.auth.main.data

@kotlinx.serialization.Serializable
data class MainDto(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Long,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val hourly_units: HourlyUnits,
    val hourly: Hourly,
    val location_id: Long?,
) {


    @kotlinx.serialization.Serializable
    data class HourlyUnits(
        val time: String,
        val temperature_2m: String,
        val relative_humidity_2m: String,
        val rain: String,
        val weather_code: String,
        val wind_speed_10m: String,
    )
    @kotlinx.serialization.Serializable
    data class Hourly(
        val time: List<String>,
        val temperature_2m: List<Double>,
        val relative_humidity_2m: List<Long>,
        val rain: List<Double>,
        val weather_code: List<Int>,
        val wind_speed_10m: List<Double>,
    )

}