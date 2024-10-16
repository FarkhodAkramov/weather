@file:OptIn(ExperimentalSerializationApi::class)

package uz.farkhod.weather.core.data.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import uz.farkhod.geedbro_kmm.core.data.remote.CustomHttpLogger

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(Android) {
            install(WebSockets)
            install(ContentNegotiation) {
                json(Json {
                    encodeDefaults = true
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    explicitNulls = false

                })
                json()
            }
            install(Logging) {
                logger = CustomHttpLogger()
                level = LogLevel.ALL
            }
        }
    }

}