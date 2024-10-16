package uz.farkhod.weather.auth.main.presentation


sealed class MainEvent {
    data class GetArguments(val cntCode: Int, val currentDate: String) :
        MainEvent()


    data class CtnChange(val cntCode: Int) : MainEvent()


    data object DrawerClick : MainEvent()
}
