package uz.farkhod.weather

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform