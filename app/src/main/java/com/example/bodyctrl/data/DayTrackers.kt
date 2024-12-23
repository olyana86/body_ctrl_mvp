package com.example.bodyctrl.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_trackers")
data class DayTrackers (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "sleep")
    val sleep: Int,

    @ColumnInfo(name = "water")
    val water: Int,

    @ColumnInfo(name = "calories")
    val calories: Int
)