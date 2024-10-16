package uz.farkhod.weather.android.auth.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.farkhod.weather.auth.main.domain.MainUseCase
import uz.farkhod.weather.auth.main.presentation.MainEvent
import uz.farkhod.weather.auth.main.presentation.MainViewModel

import javax.inject.Inject

@HiltViewModel
class AndroidMainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {
    private val viewModel by lazy {
        MainViewModel(mainUseCase, viewModelScope)
    }
    val state = viewModel.state
    fun onEvent(event: MainEvent) {
        viewModel.onEvent(event)
    }
}