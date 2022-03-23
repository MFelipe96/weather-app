package com.example.data.data_remote.model

import com.google.gson.annotations.SerializedName

data class WeatherInformationResponse(
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val placeName: String,
    @SerializedName("visibility")
    val visibility: Int
)

data class Coordinates(
    @SerializedName("lon")
    val longitude: Double,
    @SerializedName("lat")
    val latitude: Double
)

data class Weather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)

data class Wind(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("speed")
    val speed: Float,
)

data class Main(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("humidity")
    val humidity: Int
)