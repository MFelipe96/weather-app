package com.example.domain.use_case

import com.example.domain.core.UseCase
import com.example.domain.model.WeatherInformationModel
import com.example.domain.repository.WeatherInformationRepository
import kotlinx.coroutines.CoroutineScope

class WeatherInformationUseCase(
    private val repository: WeatherInformationRepository,
    scope: CoroutineScope
): UseCase<WeatherInformationModel, WeatherInformationUseCase.Params>(scope) {

    data class Params(
        val longitude: Double,
        val latitude: Double,
        val apiId: String
    )

    override fun run(params: Params?) = when(params){
        null -> throw Exception()
        else -> repository.getWeatherInformation(
            params.longitude,
            params.latitude,
            params.apiId)
    }

}