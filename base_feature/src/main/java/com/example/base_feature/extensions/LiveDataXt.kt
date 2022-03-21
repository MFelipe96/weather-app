package com.example.base_feature.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this
