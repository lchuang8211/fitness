package com.hlc.fng.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RoomDemo")
data class MyData @JvmOverloads constructor(


    //Colum nInfo = schema name 欄位名稱
    @PrimaryKey
    @ColumnInfo(name = "gname") var name: String,

    @ColumnInfo(name = "ImgName") var imageName: String,

    @ColumnInfo(name = "ImgFloor") var imageFloor: String,

    @ColumnInfo(name = "ImgUri") var imageUri: String


)