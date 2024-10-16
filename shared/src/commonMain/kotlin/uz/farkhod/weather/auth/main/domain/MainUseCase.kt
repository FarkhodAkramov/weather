package uz.farkhod.weather.auth.main.domain

import uz.farkhod.geedbro_kmm.core.domain.util.CommonException
import uz.farkhod.geedbro_kmm.core.domain.util.Resource
import uz.farkhod.weather.auth.main.data.MainDto

class MainUseCase(
    private val client: MainData
) {
    suspend fun getWeatherInfo(): Resource<List<MainDto>> {
        return try {
            val result = client.getWeatherInfo()
            Resource.Success(result)
        } catch (e: CommonException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }


}