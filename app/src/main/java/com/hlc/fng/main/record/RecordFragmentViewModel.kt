package com.hlc.fng.main.record

import androidx.lifecycle.MutableLiveData
import com.hlc.fng.base.BaseViewModel
import javax.inject.Inject

class RecordFragmentViewModel @Inject constructor(): BaseViewModel(){
    var tv_title = MutableLiveData<String>()
}