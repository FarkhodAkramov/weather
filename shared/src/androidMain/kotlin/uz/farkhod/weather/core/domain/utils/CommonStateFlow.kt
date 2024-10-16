package uz.farkhod.weather.core.domain.utils

import kotlinx.coroutines.flow.StateFlow

actual class CommonStateFlow<T> actual constructor(
    private val flow: StateFlow<T>
) : StateFlow<T> by flow