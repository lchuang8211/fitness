package com.hlc.fng.data.repository

import androidx.lifecycle.LiveData
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.data.source.local.MyDataDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecordRepository @Inject constructor(
    private val myDataDao: MyDataDao
) : RecordInteractor {

    override fun insertImage(data: MyData) {  //: Single<Long>
        myDataDao.insertData(data).toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("single long : $it")
                }, {
                    Timber.d("single long : $it")
                })
    }

    override fun getImage(): LiveData<List<MyData>> {
        return myDataDao.selectAll()


    }


}