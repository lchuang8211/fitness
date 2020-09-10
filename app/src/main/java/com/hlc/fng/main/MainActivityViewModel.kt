package com.hlc.fng.main

import androidx.lifecycle.MutableLiveData
import com.example.fng.base.BaseViewModel
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.data.source.local.MyDataDao
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private var myDataDao: MyDataDao
) : BaseViewModel() {

    var headerTitle = MutableLiveData<String>()
    var headerIcon = MutableLiveData<String>()
    var headerBackArrow = MutableLiveData<Boolean>()
    var headerBackVisiable = MutableLiveData<Boolean>().apply { value = false }
    var headerLeftMenu = MutableLiveData<Boolean>()
    var headerLeftMenuVisiable = MutableLiveData<Boolean>().apply { value = false }
    var headerMenuList = MutableLiveData<String>()

    var rightPopupWindowOpen = MutableLiveData<Boolean>().apply { value = false }
    var leftPopupWindowOpen = MutableLiveData<Boolean>()

    fun goBackClick() {
        headerBackArrow.value = null
    }

    fun onLeftMenuClick() {
        headerLeftMenu.value = null
    }

    fun rightPopupWindowClick() {
        rightPopupWindowOpen.value = null
    }

    fun leftPopupWindowClick() {
        leftPopupWindowOpen.value = null
    }


}