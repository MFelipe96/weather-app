package com.example.feature_weather.list_of_cities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.base_feature.extensions.*
import com.example.domain.model.weather_info.WeatherInformationModel
import com.example.domain.use_case.WeatherInformationUseCase
import com.example.feature_weather.BuildConfig
import org.koin.core.component.KoinComponent

class ListOfCitiesViewModel : ViewModel(), KoinComponent {

    private val weatherInformationUseCase: WeatherInformationUseCase by useCase()

    private val _weatherInformation = MutableLiveData<WeatherInformationModel>()

    val weatherInformationLiveData = _weatherInformation.asLiveData()

    fun getWeatherInformation(long: Double, lat: Double){
        weatherInformationUseCase(
            params = WeatherInformationUseCase.Params(
                longitude = long,
                latitude = lat,
                apiId = BuildConfig.API_KEY
            ),
            onSuccess = {
               _weatherInformation.value = it
            },
            onError = {}
        )
    }
}