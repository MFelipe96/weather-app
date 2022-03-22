package com.example.feature_weather.list_of_cities

import android.view.LayoutInflater
import com.example.base_feature.core.BaseFragment
import com.example.feature_weather.databinding.ListOfCitiesFragmentBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.base_feature.extensions.dateFormatted
import com.example.base_feature.extensions.kelvinToCelsius
import com.example.base_feature.extensions.navDirections
import com.example.domain.model.WeatherInformationModel
import com.example.feature_weather.R
import com.example.feature_weather.WeatherNavigation
import java.util.*

class ListOfCitiesFragment : BaseFragment<ListOfCitiesFragmentBinding>() {

    private val viewModel: ListOfCitiesViewModel by viewModels()
    private val navigation: WeatherNavigation by navDirections()
    private var currentLocation = true

    override fun setupView() {
        super.setupView()
        setupAdapter()
        viewModel.getWeatherInformation(
            Cities.getList().first().longitude,  Cities.getList().first().latitude
        )
    }

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        ListOfCitiesFragmentBinding.inflate(inflater)

    override fun addObservers(owner: LifecycleOwner) {
        super.addObservers(owner)
        viewModel.weatherInformationLiveData.observe(owner
        ) {
            setInformation(it)
            if(!currentLocation) navigation.goToDetails(it)
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
            adapter = ListOfCitiesAdapter {
                viewModel.getWeatherInformation(it.longitude, it.latitude)
                currentLocation = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentLocation = true
    }
}