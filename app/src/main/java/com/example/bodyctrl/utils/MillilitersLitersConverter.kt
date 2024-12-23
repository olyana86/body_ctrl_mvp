package com.example.bodyctrl.utils

fun getLitersFromMilliliters(total: Int): Int {
    return total / 1000
}

fun getMillilitersRemain(total: Int, liters: Int): Int {
    return total - (liters * 1000)
}

fun getWaterValueForMainScreen(total: Int): String {
    val liters = getLitersFromMilliliters(total)
    val milliliters = getMillilitersRemain(total, liters)
    val value = "$liters л $milliliters мл"

    return value
}