package com.example.feature_weather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import com.example.base_feature.core.BaseFragment
import com.example.feature_weather.databinding.ListOfCitiesFragmentBinding

class ListOfCitiesFragment : BaseFragment<ListOfCitiesFragmentBinding>() {

    private lateinit var viewModel: ListOfCitiesViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfCitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        ListOfCitiesFragmentBinding.inflate(inflater)
}