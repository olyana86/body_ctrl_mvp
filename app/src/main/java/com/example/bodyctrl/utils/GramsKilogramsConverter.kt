package com.example.bodyctrl.utils

fun getKilogramsFromGrams(total: Int): Int {
    return total / 1000
}

fun getGramsRemain(total: Int, kilograms: Int): Int {
    return total - (kilograms * 1000)
}
