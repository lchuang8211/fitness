package com.hlc.fng.main

import androidx.lifecycle.MutableLiveData
import com.example.fng.base.BaseViewModel
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.data.source.local.MyDataDao
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private var myDataDao: MyDataDao
): BaseViewModel(){

    var headerTitle = MutableLiveData<String>()
    var headerIcon = MutableLiveData<String>()
    var headerBackArrow = MutableLiveData<Boolean>()
    var headerBackVisiable = MutableLiveData<Boolean>().apply { value = false }
    var headerMenuList = MutableLiveData<String>()

    fun goBackClick(){
        headerBackArrow.value = null
    }


}