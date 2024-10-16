package uz.farkhod.weather.auth.main.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.farkhod.geedbro_kmm.core.domain.util.CommonException
import uz.farkhod.geedbro_kmm.core.domain.util.Resource
import uz.farkhod.weather.auth.main.domain.MainUseCase
import uz.farkhod.weather.core.domain.utils.toCommonStateFlow



class MainViewModel(
    private val mainUseCase: MainUseCase,
    private val coroutineScope: CoroutineScope?
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)
    private val _state = MutableStateFlow(MainState())
    val state = _state
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainState())
        .toCommonStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {


            is MainEvent.GetArguments -> {
                _state.update {
                    it.copy(
                        isRequesting = true,
                        error = null,
                        cntCode=event.cntCode,
                        date=event.currentDate
                    )
                }
                getWeather(state.value, event.cntCode);
            }
            is MainEvent.CtnChange->{
                _state.update {
                    it.copy(
                        cntCode = event.cntCode,
                    )
                }
            }







            else -> Unit
        }
    }


    private fun getWeather(state: MainState, cntCode: Int) {

        viewModelScope.launch {
            val result =
                mainUseCase.getWeatherInfo()
            when (result) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isRequesting = false,
                            weatherList = result.data,
                            cntName = getCityName(cntCode),
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            error = (result.throwable as? CommonException)?.error,
                            isRequesting = false
                        )
                    }
                }
            }
        }
    }

    fun getCityName(code: Int): String {
        return when (code) {
            1 -> "Tashkent"
            2 -> "Paris"
            3 -> "New York"
            else -> ""
        }
    }



}