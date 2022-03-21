package com.example.data.data_remote

import com.example.data.data_remote.WeatherService.WeatherAPI.GET_WEATHER_INFO
import com.example.data.data_remote.model.WeatherInformationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(GET_WEATHER_INFO)
    suspend fun getWeatherInformation(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String
    ): Response<WeatherInformationResponse>

    object WeatherAPI{
        const val BASE_URL = "https://api.openweathermap.org/"
        const val GET_WEATHER_INFO = BASE_URL + "data/2.5/weather"
    }
}