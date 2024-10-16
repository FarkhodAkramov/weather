package uz.farkhod.weather.core.data.remote

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json


actual class HttpClientFactory {
    @OptIn(ExperimentalSerializationApi::class)
    actual fun create(): HttpClient {
        return HttpClient(Darwin) {
            install(ContentNegotiation) {
                json(
                    Json {
                        encodeDefaults = true
                        prettyPrint = true
                        ignoreUnknownKeys = true
                        explicitNulls = false
                    }
                )
            }
            install(Logging) {
                logger = IOSLogger()
                level = LogLevel.ALL
            }
        }
    }
}