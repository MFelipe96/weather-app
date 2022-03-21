package com.example.di

import com.example.feature_weather.ListOfCitiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module{
    viewModel { ListOfCitiesViewModel() }
}