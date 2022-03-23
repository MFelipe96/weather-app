package com.example.feature_weather.list_of_cities

import com.example.domain.model.city.CityModel

object Cities {
    fun getList() =
        mutableListOf(
            CityModel("Local atual", 0.0, 0.0),
            CityModel("Lisboa", 38.72726950047539, -9.138576752676844),
            CityModel("Madrid", 40.428984775380435, -3.704266974888834),
            CityModel("Paris", 48.950230528813705, 2.368661904005507),
            CityModel("Berlim", 52.80474162501, 13.238654586375631),
            CityModel("Copenhaga", 55.72348817842143, 12.591418527835867),
            CityModel("Roma", 41.902908787350626, 12.492866446788984),
            CityModel("Londres", 51.516345368180936, -0.12635417580366473),
            CityModel("Dublin", 53.387759905715065, -6.263565727073136),
            CityModel("Praga", 50.12302145550871, 14.427162291816876),
            CityModel("Viena", 48.257185743976436, 16.36837718429578),
        )
}