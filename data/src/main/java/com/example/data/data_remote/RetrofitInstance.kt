package com.example.data.data_remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client : OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()


    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(WeatherService.WeatherAPI.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val WEATHER_SERVICE: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}