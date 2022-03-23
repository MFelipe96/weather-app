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
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_SPEED_WIND
import com.example.feature_weather.WeatherNavigation.Companion.ARG_WEATHER_VISIBILITY
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
        val weatherVisibility = arguments?.getInt(ARG_WEATHER_VISIBILITY) ?: 0
        val speed = arguments?.getFloat(ARG_WEATHER_SPEED_WIND)

            with(binding){
                placeNome.text = placeName
                this.description.text = description.toString().replaceFirstChar{it.uppercase()}
                this.temp.text = temp?.kelvinToCelsius()
                tempMaxAndMin.text =  getString(R.string.tempMaxAndMin, tempMax?.kelvinToCelsius(), tempMin?.kelvinToCelsius())
                date.text = Calendar.getInstance().time.dateFormatted()
                metric.text = getString(R.string.metric, weatherMain)

                with(line1){
                    field1.text = getString(R.string.feels_like_title)
                    value1.text = getString(R.string.feels_like, feelsLike?.kelvinToCelsius())
                    field2.text = getString(R.string.humidity_title)
                    value2.text = "${humidity.toString()}%"
                }
                with(line2){
                    field1.text = getString(R.string.speed_title)
                    value1.text = getString(R.string.speed, speed.toString())
                    field2.text = getString(R.string.temp_max_title)
                    value2.text = getString(R.string.temp_max, tempMax?.kelvinToCelsius())
                }
                with(line3){
                    field1.text = getString(R.string.visibility_title)
                    value1.text = getString(R.string.visibility, (weatherVisibility/1000).toString())
                    field2.text = getString(R.string.pressure_title)
                    value2.text = getString(R.string.pressure, pressure.toString())
                }
            }
    }

}