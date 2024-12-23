package com.example.bodyctrl.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bodyctrl.data.BodyCtrlRepository
import com.example.bodyctrl.data.Parameters
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ParametersViewModel @Inject constructor(
    private val bodyCtrlRepository: BodyCtrlRepository
) : ViewModel() {

    private val _parameters = MutableLiveData<List<Parameters>>()
    val parameters: LiveData<List<Parameters>> = _parameters

    init {
        getAllParameters()
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

    fun updateParameters(parameters: Parameters) {
        bodyCtrlRepository.updateParameters(parameters)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}