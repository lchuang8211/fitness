package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.hlc.fng.dagger.ViewModelBuilder
import com.hlc.fng.dagger.ViewModelKey
import com.hlc.fng.main.home.HomeFragment
import com.hlc.fng.main.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun HomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    internal abstract fun bindViewModel(viewModel: HomeFragmentViewModel): ViewModel
}
