package uz.farkhod.weather.auth.main.presentation

import uz.farkhod.geedbro_kmm.core.domain.util.CommonError
import uz.farkhod.weather.auth.main.data.MainDto

data class MainState(
    val firebaseToken: String = "",
    val phoneNumber: String = "",
    val weatherList: List<MainDto>? = null,
    val cntName:String="",
    val cntCode:Int=1,
    val day:String="",
    val password: String = "",
    val isPasswordFieldDone: Boolean = false,
    val isRequesting: Boolean = false,
    val isSuccess: Boolean = false,
    val token: String = "",
    val role: String = "",
    val error: CommonError? = null,
    val date:String=""
)
