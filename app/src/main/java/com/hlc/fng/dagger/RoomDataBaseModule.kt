package com.example.fng.dagger

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

import androidx.room.Room
import com.hlc.fng.data.RoomDataBase
import com.hlc.fng.data.source.local.MyDataDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object RoomDataBaseModule {

    // 自訂資料庫名稱
    private val DB_NAME = "HLC_DataBase.db"

    @JvmStatic
    @Singleton
    @Provides
    fun provideRoomDataBase(context: Context): RoomDataBase {

        // 實作 RoomDataBase -> Biuld()
        return Room.databaseBuilder(context.applicationContext, RoomDataBase::class.java,DB_NAME)
//            .allowMainThreadQueries()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPreferences(
        context: Context
    ): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
    }

    // Dagger Dao 操作實體

    @JvmStatic
    @Singleton
    @Provides
    fun providesUserInfoDao(roomDataBase: RoomDataBase): MyDataDao{
        return roomDataBase.myDataDao()
    }

}