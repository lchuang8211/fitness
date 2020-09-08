package com.example.fng.dagger

import android.content.Context

import com.hlc.fng.dagger.viewModule.*
import com.hlc.fng.main.HLCApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// Component 提供所要使用的 Module 給 APP 使用
// Singleton 避免建立多個實體 僅能一次 (上下層一至)
@Singleton
@Component(
    modules = [
//        DataModule::class,
        RepositoryModule::class,
        ApplicationModule::class,
        RoomDataBaseModule::class,
        AndroidSupportInjectionModule::class,
        //以下 View 與 ViewModel 的 Module
        MainActivityModule::class,
        MainFragmentModule::class

    ]
)
interface ApplicationComponent : AndroidInjector<HLCApplication> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance applicationContext: Context): ApplicationComponent

    }


}