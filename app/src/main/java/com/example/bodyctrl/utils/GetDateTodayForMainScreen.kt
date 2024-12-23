package com.example.bodyctrl.utils

import androidx.compose.material3.CalendarLocale
import java.util.Calendar

fun getDateTodayForMainScreen(): String {
    val calendar = Calendar.getInstance(CalendarLocale("RU"))
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

    val dateToday = "$day ${monthIntToText(month)} $year г."
    return dateToday
}

fun monthIntToText(monthInt: Int): String {
    var monthText = ""
    when (monthInt) {
        0 -> monthText = "января"
        1 -> monthText = "февраля"
        2 -> monthText = "марта"
        3 -> monthText = "апреля"
        4 -> monthText = "мая"
        5 -> monthText = "июня"
        6 -> monthText = "июля"
        7 -> monthText = "августа"
        8 -> monthText = "сентября"
        9 -> monthText = "октября"
        10 -> monthText = "ноября"
        11 -> monthText = "декабря"
    }
    return monthText
}

