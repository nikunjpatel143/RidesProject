package com.example.myweatherapp.di


import com.example.rides.ridesApis.RidesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Singleton
    @Provides
    fun provideApi(): Retrofit {
        return Retrofit.Builder().baseUrl("https://random-data-api.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideRidesApi(retrofit: Retrofit): RidesApi {
        return retrofit.create(RidesApi::class.java)
    }

}