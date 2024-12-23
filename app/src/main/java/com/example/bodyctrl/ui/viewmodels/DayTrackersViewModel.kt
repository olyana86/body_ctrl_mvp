package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.DayTrackers
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DayTrackersViewModel @Inject constructor(
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {

    private val _dayTrackers = MutableLiveData<List<DayTrackers>>()
    val dayTrackers: LiveData<List<DayTrackers>> = _dayTrackers

    init {
        getAllDayTrackers()
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

    fun updateDayTrackers(dayTrackers: DayTrackers) {
        bodyCtrlRepository.updateDayTrackers(dayTrackers)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}