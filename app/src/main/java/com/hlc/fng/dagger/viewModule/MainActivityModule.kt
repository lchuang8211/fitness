package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.example.fng.dagger.ViewModelBuilder
import com.example.fng.dagger.ViewModelKey
import com.hlc.fng.main.MainActivity
import com.hlc.fng.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun MainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindViewModel(viewModel: MainActivityViewModel): ViewModel
}