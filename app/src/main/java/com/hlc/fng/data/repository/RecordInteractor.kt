package com.hlc.fng.data.repository

import androidx.lifecycle.LiveData
import com.hlc.fng.data.source.local.MyData
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface RecordInteractor  {

//    fun insertImage(data: MyData)

    fun insertImage(data: MyData)

    fun getImage(): LiveData<List<MyData>>
}