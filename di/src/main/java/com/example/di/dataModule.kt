package com.example.di

import com.example.data.data_remote.RetrofitInstance
import com.example.data.repository.WeatherInformationRepositoryImpl
import com.example.domain.repository.WeatherInformationRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        RetrofitInstance.WEATHER_SERVICE
    }

    single<WeatherInformationRepository>{ WeatherInformationRepositoryImpl(get()) }
}