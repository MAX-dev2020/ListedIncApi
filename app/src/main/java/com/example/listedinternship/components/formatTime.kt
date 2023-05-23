package com.example.listedinternship.components

import java.text.SimpleDateFormat
import java.util.*

fun formatTime(time: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val date = inputFormat.parse(time)
    return outputFormat.format(date!!)
}

