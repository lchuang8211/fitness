package com.example.fng.dagger

import android.app.Application
import com.hlc.fng.main.HLCApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

// Provide 整個 Application
@Module
abstract class ApplicationModule {

    @Singleton
    @Binds   //@Binds works on an abstract method
    abstract fun application(hlcApplication: HLCApplication): Application

}

/** Binds 與 Provides 等義
 * 不過 Binds 只能綁定抽象方法，所以皆要 abstract
 * 而 Provides 則需要實作
 * */

// @Module
// class ApplicationModule {
//
//    @Singleton
//    @Provides
//    fun provideAppliaction(): Application {
//        return HHHApplication()
//    }
//
//}