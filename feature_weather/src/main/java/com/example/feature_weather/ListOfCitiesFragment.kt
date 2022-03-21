package com.example.feature_weather

import android.util.Log
import android.view.LayoutInflater
import com.example.base_feature.core.BaseFragment
import com.example.feature_weather.databinding.ListOfCitiesFragmentBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner

class ListOfCitiesFragment : BaseFragment<ListOfCitiesFragmentBinding>() {

    private val viewModel: ListOfCitiesViewModel by viewModels()

    override fun setupView() {
        super.setupView()
        viewModel.getWeatherInformation(-9.328432784654337, 38.69283916557216)
    }

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        ListOfCitiesFragmentBinding.inflate(inflater)

    override fun addObservers(owner: LifecycleOwner) {
        super.addObservers(owner)
        viewModel.weatherInformationLiveData.observe(owner
        ) {
            Log.i("teste", "addObservers: ${it.placeName} - ${it.main.temp}") }
    }
}