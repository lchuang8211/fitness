package com.hlc.fng.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface MyDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(list: MyData): Single<Long>

    @Query("SELECT * From RoomDemo")
    fun selectAll(): LiveData<List<MyData>>    //LiveData<List<MyData>>

//    @Query("SELECT ImgName, ImgFloor, ImgUri FROM RoomDemo WHERE ImgName is :imgName AND ImgFloor is :imgFloor")
//    fun selectImg(imgName: String, imgFloor: String, imgUri: String): Observable<List<MyData>>
}