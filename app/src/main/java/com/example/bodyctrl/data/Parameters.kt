package com.example.bodyctrl.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parameters")
data class Parameters (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "height")
    val height: Int,

    @ColumnInfo(name = "weight")
    val weight: Int,

    @ColumnInfo(name = "chest")
    val chest: Int,

    @ColumnInfo(name = "waist")
    val waist: Int,

    @ColumnInfo(name = "hip")
    val hip: Int
)