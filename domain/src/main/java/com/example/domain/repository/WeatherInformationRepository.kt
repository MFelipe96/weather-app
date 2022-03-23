package com.example.domain.repository

import com.example.domain.model.weather_info.WeatherInformationModel
import kotlinx.coroutines.flow.Flow

interface WeatherInformationRepository {
    fun getWeatherInformation(lon: Double, lat: Double, appId: String): Flow<WeatherInformationModel>
}