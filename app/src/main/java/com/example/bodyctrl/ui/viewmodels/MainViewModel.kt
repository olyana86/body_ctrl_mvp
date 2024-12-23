package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.DayActivities
import com.example.bodyctrl.data.DayTrackers
import com.example.bodyctrl.data.Parameters
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {

    private val _dayActivities = MutableLiveData<List<DayActivities>>()
    val dayActivities: LiveData<List<DayActivities>> = _dayActivities

    private val _parameters = MutableLiveData<List<Parameters>>()
    val parameters: LiveData<List<Parameters>> = _parameters

    private val _dayTrackers = MutableLiveData<List<DayTrackers>>()
    val dayTrackers: LiveData<List<DayTrackers>> = _dayTrackers


    init {
        getAllParameters()
        getAllDayTrackers()
        getDayActivities()
    }

    fun getAllParameters() {
        bodyCtrlRepository.getAllParameters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllParameters,
                this::onParametersFail
            )
    }

    private fun onGetAllParameters(listOfParameters: List<Parameters>) {
        _parameters.postValue(listOfParameters)
    }

    private fun onParametersFail(t: Throwable) {
    }

    fun getAllDayTrackers() {
        bodyCtrlRepository.getAllDayTrackers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllDayTrackers,
                this::onDayTrackersFail
            )
    }

    private fun onGetAllDayTrackers(listOfDayTrackers: List<DayTrackers>) {
        _dayTrackers.postValue(listOfDayTrackers)
    }

    private fun onDayTrackersFail(t: Throwable) {
    }

    fun getDayActivities() {
        bodyCtrlRepository.getActiveDayActivities()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetDayActivities,
                this::onDayActivitiesFail
            )
    }

    private fun onGetDayActivities(listOfDayActivities: List<DayActivities>) {
        _dayActivities.postValue(listOfDayActivities)
    }

    private fun onDayActivitiesFail(t: Throwable) {
    }

    fun updateDayActivity(dayActivity: DayActivities) {
        bodyCtrlRepository.updateDayActivity(dayActivity)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}