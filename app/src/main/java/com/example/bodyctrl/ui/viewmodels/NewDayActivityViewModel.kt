package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.DayActivities
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewDayActivityViewModel @Inject constructor(
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {

    fun insertDayActivity(dayActivity: DayActivities) {
        bodyCtrlRepository.insertDayActivity(dayActivity)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}