package com.example.di

import androidx.fragment.app.Fragment
import com.example.feature_weather.WeatherNavigation
import com.example.navigation.weather.WeatherNavigationImpl
import org.koin.dsl.module

val navigationModule = module {

    factory<WeatherNavigation> {
            (fragment: Fragment) ->
        WeatherNavigationImpl(fragment)
    }
}