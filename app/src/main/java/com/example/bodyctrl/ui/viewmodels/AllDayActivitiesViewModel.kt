package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.DayActivities
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AllDayActivitiesViewModel @Inject constructor(
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {


    private val _dayActivities = MutableLiveData<List<DayActivities>>()
    val dayActivities: LiveData<List<DayActivities>> = _dayActivities

    init {
        getAllDayActivities()
    }

    fun getAllDayActivities() {
        bodyCtrlRepository.getAllDayActivities()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetAllDayActivities,
                this::onDayActivitiesFail
            )
    }

    private fun onGetAllDayActivities(listOfDayActivities: List<DayActivities>) {
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