package com.example.weatherapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.di.dataModule
import com.example.di.domainModule
import com.example.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin{
            modules(
                presentationModule,
                domainModule,
                dataModule
            ).androidContext(applicationContext)
        }
    }
}