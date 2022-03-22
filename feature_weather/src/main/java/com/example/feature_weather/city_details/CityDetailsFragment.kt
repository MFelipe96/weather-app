package com.example.feature_weather.city_details

import android.view.LayoutInflater
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.extensions.dateFormatted
import com.example.base_feature.extensions.kelvinToCelsius
import com.example.feature_weather.R
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_DESCRIPTION
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_FEELSLIKE
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_HUMIDITY
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_NAME
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_PRESSURE
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP_MAX
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_INFORMATION_TEMP_MIN
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_MAIN
import com.example.feature_weather.databinding.FragmentCityDetailsBinding
import java.util.*

class CityDetailsFragment : BaseFragment<FragmentCityDetailsBinding>() {

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        FragmentCityDetailsBinding.inflate(inflater)

    override fun setupView() {
        super.setupView()

        val placeName = arguments?.getString(ARG_WEATHER_INFORMATION_NAME)
        val description = arguments?.getString(ARG_WEATHER_INFORMATION_DESCRIPTION)
        val feelsLike = arguments?.getDouble(ARG_WEATHER_INFORMATION_FEELSLIKE)
        val humidity = arguments?.getInt(ARG_WEATHER_INFORMATION_HUMIDITY)
        val temp = arguments?.getDouble(ARG_WEATHER_INFORMATION_TEMP)
        val tempMax = arguments?.getDouble(ARG_WEATHER_INFORMATION_TEMP_MAX)
        val tempMin = arguments?.getDouble(ARG_WEATHER_INFORMATION_TEMP_MIN)
        val pressure = arguments?.getInt(ARG_WEATHER_INFORMATION_PRESSURE)
        val weatherMain = arguments?.getString(ARG_WEATHER_MAIN)

            with(binding){
                placeNome.text = placeName
                this.description.text = description
                this.temp.text = temp?.kelvinToCelsius()
                tempMaxAndMin.text =  getString(R.string.tempMaxAndMin, tempMax?.kelvinToCelsius(), tempMin?.kelvinToCelsius())
                date.text = Calendar.getInstance().time.dateFormatted()
                metric.text = getString(R.string.metric, weatherMain)

                line1.field1.text = "Sensação térmica de"
                line1.value1.text = feelsLike?.kelvinToCelsius()

                line1.field2.text = "Umidade"
                line1.value2.text = humidity.toString()

                line2.field1.text = "Vento sul"
                line2.value1.text = feelsLike?.kelvinToCelsius()

                line2.field2.text = "UV"
                line2.value2.text = humidity.toString()

                line3.field1.text = "Visibilidade"
                line3.value1.text = feelsLike?.kelvinToCelsius()

                line3.field2.text = "Pressão atmosférica"
                line3.value2.text = pressure.toString()


            }
    }

}