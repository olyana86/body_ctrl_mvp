package com.example.bodyctrl.utils

fun getHoursFromMinutes(total: Int): Int {
    return total / 60
}

fun getMinutesRemain(total: Int, hours: Int): Int {
    return total - (hours * 60)
}

fun getSleepValueForMainScreen(total: Int): String {
    val hours = getHoursFromMinutes(total)
    val minutes = getMinutesRemain(total, hours)
    val value = "$hours ч $minutes мин"

    return value
}