package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.DayActivities
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DayActivityEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {

    private val dayActivityId: Int = checkNotNull(savedStateHandle["dayActivityId"])

    val dayActivity = bodyCtrlRepository.getDayActivityById(dayActivityId).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        DayActivities(0, "", "#D9E9A2", "", 0, 0)
    )

    fun updateDayActivity(dayActivity: DayActivities) {
        bodyCtrlRepository.updateDayActivity(dayActivity)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun deleteDayActivity(dayActivity: DayActivities) {
        bodyCtrlRepository.deleteDayActivity(dayActivity)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}