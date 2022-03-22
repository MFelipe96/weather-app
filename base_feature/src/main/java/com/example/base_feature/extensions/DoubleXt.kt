package com.example.base_feature.extensions

fun Double.kelvinToCelsius() : String =
    (this - 273.15).toInt().toString()
