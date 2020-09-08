package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.example.fng.dagger.ViewModelBuilder
import com.example.fng.dagger.ViewModelKey
import com.hlc.fng.main.MainActivity
import com.hlc.fng.main.MainActivityViewModel
import com.hlc.fng.main.MainFragment
import com.hlc.fng.main.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun MainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    internal abstract fun bindViewModel(viewModel: MainFragmentViewModel): ViewModel
}
