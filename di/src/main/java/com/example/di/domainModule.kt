package com.example.di

import com.example.domain.core.ThreadContextProvider
import com.example.domain.use_case.WeatherInformationUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module{
    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        WeatherInformationUseCase(
            scope = scope,
            repository = get()
        )
    }
}