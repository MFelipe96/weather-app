package com.example.feature_weather.list_of_cities

import android.view.LayoutInflater
import android.view.View
import com.example.feature_weather.databinding.ListOfCitiesFragmentBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.base_feature.core.BaseLocation
import com.example.base_feature.extensions.dateFormatted
import com.example.base_feature.extensions.kelvinToCelsius
import com.example.base_feature.extensions.navDirections
import com.example.domain.model.weather_info.WeatherInformationModel
import com.example.feature_weather.R
import com.example.feature_weather.WeatherNavigation
import java.util.*

class ListOfCitiesFragment : BaseLocation<ListOfCitiesFragmentBinding>() {

    private val viewModel: ListOfCitiesViewModel by viewModels()
    private val navigation: WeatherNavigation by navDirections()
    private var isToOpenDetailsScreen = false
    private val cities = Cities

    override fun setupView() {
        super.setupView()
        setupAdapter()
        setLoadingToVisible()
    }

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        ListOfCitiesFragmentBinding.inflate(inflater)

    override fun addObservers(owner: LifecycleOwner) {
        super.addObservers(owner)
        viewModel.weatherInformationLiveData.observe(owner
        ) {
            setInformation(it)
            setLoadingToGone()
            if(isToOpenDetailsScreen) navigation.goToDetails(it)
        }
    }

    private fun setInformation(data: WeatherInformationModel){
        with(binding){
            placeNome.text = data.placeName
            temp.text = data.main.temp.kelvinToCelsius()
            tempMaxAndMin.text =  getString(R.string.tempMaxAndMin, data.main.tempMax.kelvinToCelsius(), data.main.tempMin.kelvinToCelsius())
            date.text = Calendar.getInstance().time.dateFormatted()
            metric.text = getString(R.string.metric, data.weather[0].main)
        }
    }

    private fun setupAdapter(){
        with(binding.recyclerView){
            setHasFixedSize(true)
            adapter = ListOfCitiesAdapter(
                {
                    setLoadingToVisible()
                    viewModel.getWeatherInformation(it.first.longitude, it.first.latitude)
                    isToOpenDetailsScreen = it.second
                }, cities)
        }
    }

    override fun getWeatherFromCurrentLocation(latitude: Double, longitude: Double) {
        super.getWeatherFromCurrentLocation(latitude, longitude)
        viewModel.getWeatherInformation(long = longitude, lat = latitude)
    }

    private fun setLoadingToVisible(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun setLoadingToGone(){
        binding.progressBar.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isToOpenDetailsScreen = false
    }
}