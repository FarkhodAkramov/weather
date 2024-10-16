package uz.farkhod.geedbro_kmm.core.data.remote

import android.util.Log
import io.ktor.client.plugins.logging.Logger

class CustomHttpLogger: Logger {
    override fun log(message: String) {
        Log.d("ktor_logger", "log: $message")
    }
}