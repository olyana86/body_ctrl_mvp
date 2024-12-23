package com.example.bodyctrl.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_activities")
data class DayActivities (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "color")
    val color: String,

    @ColumnInfo(name = "details")
    val details: String,

    @ColumnInfo(name = "is_active")
    var isActive: Int,

    @ColumnInfo(name = "is_checked")
    var isChecked: Int
)