package uz.farkhod.weather.core.data.remote

import io.ktor.client.plugins.logging.*

class IOSLogger: Logger {
    override fun log(message: String) {
        print(message)
    }

}