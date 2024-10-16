package uz.farkhod.weather.di

import uz.farkhod.weather.auth.sign_in.data.KtorSignInClient
import uz.farkhod.weather.auth.sign_in.domain.SignInClient
import uz.farkhod.weather.auth.sign_in.domain.SignInUseCase
import uz.farkhod.weather.core.data.remote.HttpClientFactory

class AppModule {

    private val signInClient: SignInClient by lazy {
        KtorSignInClient(HttpClientFactory().create())
    }

    val signInUseCase: SignInUseCase by lazy {
        SignInUseCase(signInClient)
    }
}