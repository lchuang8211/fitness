package com.hlc.fng.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fng.base.BaseViewModel
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(): BaseViewModel(){

    var gotoTopEvent = MutableLiveData<Boolean>().apply { value = false }

    fun gotoTop(){
        gotoTopEvent.value = true
    }
}