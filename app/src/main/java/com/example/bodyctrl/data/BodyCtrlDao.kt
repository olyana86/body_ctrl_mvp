package com.example.bodyctrl.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface BodyCtrlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParameters(parameters: List<Parameters>)

    @Update
    fun updateParameters(parameters: Parameters) : Completable

    @Query("SELECT * FROM parameters")
    fun getAllParameters(): Observable<List<Parameters>>

    @Query("SELECT * FROM parameters WHERE id = :parametersId")
    fun getParametersById(parametersId: Int): Observable<Parameters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayTrackers(dayTrackers: List<DayTrackers>)

    @Update
    fun updateDayTrackers(dayTrackers: DayTrackers) : Completable

    @Query("SELECT * FROM day_trackers")
    fun getAllDayTrackers(): Observable<List<DayTrackers>>

    @Query("SELECT * FROM day_trackers WHERE id = :dayTrackersId")
    fun getDayTrackersById(dayTrackersId: Int): Observable<DayTrackers>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDayActivity(dayActivity: DayActivities) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayActivities(dayActivities: List<DayActivities>)

    @Update
    fun updateDayActivity(dayActivity: DayActivities) : Completable

    @Delete
    fun deleteDayActivity(dayActivity: DayActivities) : Completable

    @Query("SELECT * FROM day_activities")
    fun getAllDayActivities(): Observable<List<DayActivities>>

    @Query("SELECT * FROM day_activities WHERE is_active = 1")
    fun getActiveDayActivities(): Observable<List<DayActivities>>

    @Query("SELECT * FROM day_activities WHERE id = :dayActivityId")
    fun getDayActivityById(dayActivityId: Int): Flow<DayActivities>
}