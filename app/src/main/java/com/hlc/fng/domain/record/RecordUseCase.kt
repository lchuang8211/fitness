package com.hlc.fng.domain.record

import androidx.lifecycle.LiveData
import com.hlc.fng.data.repository.RecordRepository
import com.hlc.fng.data.source.local.MyData
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecordUseCase @Inject constructor(
    private val repo: RecordRepository
) {
    fun insertImg(data: MyData){  //: Single<Long> : Observable<Long>
         repo.insertImage(data)
    }

    fun getImg(): LiveData<List<MyData>> {
        return repo.getImage()
    }


}