package com.hlc.fng.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RoomDemo")
data class MyData(
    @PrimaryKey
    var uid: String,

    //Colum nInfo = schema name 欄位名稱
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "number")var number: Int

)