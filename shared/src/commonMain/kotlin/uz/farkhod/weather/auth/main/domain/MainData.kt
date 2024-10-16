package uz.farkhod.weather.auth.main.domain

import uz.farkhod.weather.auth.main.data.MainDto

interface MainData {

    suspend fun getWeatherInfo():List<MainDto>


}