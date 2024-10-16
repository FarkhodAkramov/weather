package uz.farkhod.geedbro_kmm.core.domain.util

data class CommonError(
    val code: Int,
    val description: String
)

class CommonException(val error: CommonError) : Exception(
    "An error occurred: $error"
)