package com.example.navigation.weather

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.domain.model.WeatherInformationModel
import com.example.feature_weather.WeatherNavigation
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_DESCRIPTION
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_FEELSLIKE
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_NAME
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_PRESSURE
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP_MAX
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP_MIN
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_MAIN
import com.example.navigation.R

class WeatherNavigationImpl(
    private val fragment: Fragment
) : WeatherNavigation {

    override fun goToDetails(weatherInformationModel: WeatherInformationModel) {
        fragment.findNavController().navigate(
            R.id.action_listOfCitiesFragment_to_cityDetailsFragment,
            bundleOf(
                ARG_WEATHER_INFORMATION_NAME to weatherInformationModel.placeName,
                ARG_WEATHER_INFORMATION_DESCRIPTION to weatherInformationModel.weather[0].description,
                ARG_WEATHER_INFORMATION_TEMP to weatherInformationModel.main.temp,
                ARG_WEATHER_INFORMATION_TEMP_MIN to weatherInformationModel.main.tempMin,
                ARG_WEATHER_INFORMATION_TEMP_MAX to weatherInformationModel.main.tempMax,
                ARG_WEATHER_INFORMATION_FEELSLIKE to weatherInformationModel.main.feelsLike,
                ARG_WEATHER_INFORMATION_PRESSURE to weatherInformationModel.main.pressure,
                ARG_WEATHER_MAIN to weatherInformationModel.weather[0].main

            )
        )
    }
}