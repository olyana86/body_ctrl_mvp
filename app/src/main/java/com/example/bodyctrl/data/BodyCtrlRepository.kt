package com.example.bodyctrl.data

import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BodyCtrlRepository @Inject constructor(private val bodyCtrlDao: BodyCtrlDao) {
    suspend fun insertParameters(parameters: List<Parameters>) =
        bodyCtrlDao.insertParameters(parameters)


    fun updateParameters(parameters: Parameters): Completable {
        return bodyCtrlDao.updateParameters(parameters)
    }

    fun getAllParameters(): Observable<List<Parameters>> = bodyCtrlDao.getAllParameters()

    suspend fun insertDayTrackers(dayTrackers: List<DayTrackers>) =
        bodyCtrlDao.insertDayTrackers(dayTrackers)

    fun updateDayTrackers(dayTrackers: DayTrackers): Completable {
        return bodyCtrlDao.updateDayTrackers(dayTrackers)
    }

    fun getAllDayTrackers(): Observable<List<DayTrackers>> = bodyCtrlDao.getAllDayTrackers()

    fun insertDayActivity(dayActivity: DayActivities): Completable {
        return bodyCtrlDao.insertDayActivity(dayActivity)
    }

    suspend fun insertDayActivities(dayActivities: List<DayActivities>) =
        bodyCtrlDao.insertDayActivities(dayActivities)


    fun updateDayActivity(dayActivity: DayActivities): Completable {
        return bodyCtrlDao.updateDayActivity(dayActivity)
    }

    fun deleteDayActivity(dayActivity: DayActivities): Completable {
        return bodyCtrlDao.deleteDayActivity(dayActivity)
    }

    fun getAllDayActivities(): Observable<List<DayActivities>> = bodyCtrlDao.getAllDayActivities()

    fun getActiveDayActivities(): Observable<List<DayActivities>> =
        bodyCtrlDao.getActiveDayActivities()

    fun getDayActivityById(dayActivityId: Int): Flow<DayActivities> =
        bodyCtrlDao.getDayActivityById(dayActivityId)
}