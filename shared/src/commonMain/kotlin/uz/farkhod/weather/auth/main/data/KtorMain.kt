package uz.farkhod.weather.auth.main.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.utils.io.errors.IOException
import uz.farkhod.geedbro_kmm.core.domain.util.CommonError
import uz.farkhod.geedbro_kmm.core.domain.util.CommonException
import uz.farkhod.geedbro_kmm.core.domain.util.throwCommonException
import uz.farkhod.weather.NetworkConstant
import uz.farkhod.weather.auth.main.domain.MainData

class KtorMain(private val httpClient: HttpClient) : MainData {
    override suspend fun getWeatherInfo(): List<MainDto> {
        val result = try {
            httpClient.get {
                url(NetworkConstant.BASE_URL)
                parameter("latitude", "41.2647,51.5085,40.7143,48.8534")
                parameter("longitude", "69.2163,-0.1257,-74.006,2.3488")
                parameter(
                    "hourly",
                    "temperature_2m,relative_humidity_2m,rain,weather_code,wind_speed_10m"
                )
            }
        } catch (e: IOException) {
            throw CommonException(CommonError(10, "server is unavailable"))
        }

        throwCommonException(result.status)

        return try {
            result.body()
        } catch (e: Exception) {
            throw CommonException(CommonError(11, e.message ?: "error convert response body"))
        }
    }


}