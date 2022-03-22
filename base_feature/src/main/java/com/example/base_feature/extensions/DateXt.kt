package com.example.base_feature.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateFormatted(): String{
    val dateFormat = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
    return dateFormat.format(this);
}