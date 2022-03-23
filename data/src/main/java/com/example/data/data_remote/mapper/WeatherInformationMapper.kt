package com.example.data.data_remote.mapper

import com.example.data.data_remote.model.WeatherInformationResponse
import com.example.domain.model.weather_info.*
import retrofit2.Response

object WeatherInformationMapper {

    fun toDomain(data: Response<WeatherInformationResponse>) = WeatherInformationModel(
        coordinates = Coordinates(
            longitude = data.body()?.coordinates?.longitude ?: 0.0,
            latitude = data.body()?.coordinates?.latitude ?: 0.0
        ),
        main = Main(
            temp = data.body()?.main?.temp ?: 0.0,
            tempMax = data.body()?.main?.tempMax ?: 0.0,
            tempMin = data.body()?.main?.tempMin ?: 0.0,
            humidity = data.body()?.main?.humidity ?: 0,
            pressure = data.body()?.main?.pressure ?: 0,
            feelsLike = data.body()?.main?.feelsLike ?: 0.0
        ),
        weather = listOf(
            Weather(
            id = data.body()?.weather?.first()?.id ?: 0,
            main = data.body()?.weather?.first()?.main ?: "",
            description = data.body()?.weather?.first()?.description ?: "",
            icon = data.body()?.weather?.first()?.icon ?: ""
        )
        ),
        wind = Wind(
            speed = data.body()?.wind?.speed ?: 0F,
            deg = data.body()?.wind?.deg ?: 0
        ),
        placeName = data.body()?.placeName ?: "Sem nome",
        visibility = data.body()?.visibility ?: 0
    )
}