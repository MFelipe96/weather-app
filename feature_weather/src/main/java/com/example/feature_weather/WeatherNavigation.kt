package com.example.feature_weather

import com.example.domain.model.WeatherInformationModel

interface WeatherNavigation {

    companion object{
        const val ARG_WEATHER_INFORMATION_NAME = "arg_weather_info_place_name"
        const val ARG_WEATHER_INFORMATION_TEMP = "arg_weather_info_temp"
        const val ARG_WEATHER_INFORMATION_TEMP_MAX = "arg_weather_info_temp_max"
        const val ARG_WEATHER_INFORMATION_TEMP_MIN = "arg_weather_info_temp_min"
        const val ARG_WEATHER_INFORMATION_HUMIDITY = "arg_weather_info_humidity"
        const val ARG_WEATHER_INFORMATION_FEELSLIKE = "arg_weather_info_feelsLike"
        const val ARG_WEATHER_INFORMATION_PRESSURE = "arg_weather_info_pressure"
        const val ARG_WEATHER_INFORMATION_DESCRIPTION = "arg_weather_info_description"
        const val ARG_WEATHER_MAIN = "arg_weather_main"

    }

    fun goToDetails(weatherInformationModel: WeatherInformationModel)
}