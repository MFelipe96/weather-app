package com.example.domain.model.weather_info

data class WeatherInformationModel(
    val coordinates: Coordinates,
    val weather: List<Weather>,
    val wind: Wind,
    val main: Main,
    val placeName: String,
    val visibility: Int
)

data class Coordinates(
    val longitude: Double,
    val latitude: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Wind(
    val deg: Int,
    val speed: Float,
)

data class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)