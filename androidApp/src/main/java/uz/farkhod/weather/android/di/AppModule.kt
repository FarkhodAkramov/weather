package uz.farkhod.weather.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.*
import io.ktor.client.engine.cio.*

import uz.farkhod.weather.core.data.remote.HttpClientFactory

import javax.inject.Singleton

import uz.farkhod.weather.auth.main.data.KtorMain
import uz.farkhod.weather.auth.main.domain.MainData
import uz.farkhod.weather.auth.main.domain.MainUseCase


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }
//    @Provides
//    @Singleton
//    fun provideHttpClient(): HttpClient {
//
//        return HttpClientFactory().create()
//
//    }


    @Provides
    @Singleton
    fun provideMain(httpClient: HttpClient): MainData {
        return KtorMain(httpClient)
    }

    @Provides
    @Singleton
    fun provideMainUseCase(client: MainData): MainUseCase {
        return MainUseCase(client)
    }







}