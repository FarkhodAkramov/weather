package uz.farkhod.weather.core.data.remote

import io.ktor.client.*

expect class HttpClientFactory {
    fun create(): HttpClient
}