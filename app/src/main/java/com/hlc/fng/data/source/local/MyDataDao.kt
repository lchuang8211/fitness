package com.hlc.fng.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hlc.fng.data.source.local.MyData

@Dao
interface MyDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(list: List<MyData>)

    @Query("SELECT * From RoomDemo")
    fun selectAll(): List<MyData>
}