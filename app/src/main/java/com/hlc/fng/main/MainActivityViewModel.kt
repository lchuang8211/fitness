package com.hlc.fng.main

import com.example.fng.base.BaseViewModel
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.data.source.local.MyDataDao
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private var myDataDao: MyDataDao
): BaseViewModel(){



}