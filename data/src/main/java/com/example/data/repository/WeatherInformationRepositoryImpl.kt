package com.example.data.repository

import com.example.data.data_remote.WeatherService
import com.example.data.data_remote.mapper.WeatherInformationMapper.toDomain
import com.example.domain.repository.WeatherInformationRepository
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class WeatherInformationRepositoryImpl(
    private val webService: WeatherService
): WeatherInformationRepository, KoinComponent {

    override fun getWeatherInformation(lon: Double, lat: Double, appId: String) = flow {
         emit(
             toDomain(
                 webService.getWeatherInformation(
                 longitude = lon,
                 latitude = lat,
                 apiKey = appId
                )
             )
         )
    }
}
