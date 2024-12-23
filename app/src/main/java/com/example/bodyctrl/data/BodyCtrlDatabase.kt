package com.example.bodyctrl.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(
    entities = [Parameters::class, DayTrackers::class, DayActivities::class],
    version = BodyCtrlDatabase.DB_VERSION,
    exportSchema = false
)
abstract class BodyCtrlDatabase : RoomDatabase() {
    abstract fun bodyCtrlDao(): BodyCtrlDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "app.db"

        @Volatile
        private var INSTANCE: BodyCtrlDatabase? = null

        fun getInstance(context: Context): BodyCtrlDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context)
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BodyCtrlDatabase::class.java, DB_NAME
            ).addCallback(dbCreateCallback(context)).build()

        fun dbCreateCallback(context: Context) = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    getInstance(context).bodyCtrlDao()
                        .insertParameters(PrepopulateData.parameters)
                    getInstance(context).bodyCtrlDao()
                        .insertDayTrackers(PrepopulateData.dayTrackers)
                    getInstance(context).bodyCtrlDao()
                        .insertDayActivities(PrepopulateData.dayActivities)
                }
            }
        }

        object PrepopulateData {
            val parameters = listOf(
                Parameters(
                    id = 1,
                    type = "Цель",
                    height = 160,
                    weight = 60000,
                    chest = 90,
                    waist = 60,
                    hip = 90
                ),
                Parameters(
                    id = 2,
                    type = "Сейчас",
                    height = 160,
                    weight = 70000,
                    chest = 100,
                    waist = 80,
                    hip = 100
                )
            )
            val dayTrackers = listOf(
                DayTrackers(
                    id = 1,
                    type = "Цель",
                    sleep = 480,
                    water = 2000,
                    calories = 1600
                ),
                DayTrackers(
                    id = 2,
                    type = "Сейчас",
                    sleep = 400,
                    water = 500,
                    calories = 500
                )
            )
            val dayActivities = listOf(
                DayActivities(
                    id = 1,
                    name = "Сделать 30 приседаний",
                    color = "#E9C8A2",
                    details = "Можно разделить на части",
                    isActive = 1,
                    isChecked = 0
                ),
                DayActivities(
                    id = 2,
                    name = "Пройтись по воздуху",
                    color = "#A2BBE9",
                    details = "Лучше до темноты",
                    isActive = 1,
                    isChecked = 0
                )
            )
        }
    }
}