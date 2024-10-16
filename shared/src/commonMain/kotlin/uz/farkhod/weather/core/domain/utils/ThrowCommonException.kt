package uz.farkhod.geedbro_kmm.core.domain.util

import io.ktor.http.*

fun throwCommonException(status: HttpStatusCode) {
    when (status.value) {
        in 200..299 -> Unit
        else -> throw  CommonException(CommonError(status.value,status.description))
    }
}