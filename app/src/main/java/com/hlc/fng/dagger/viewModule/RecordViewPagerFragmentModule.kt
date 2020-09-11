package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.hlc.fng.dagger.ViewModelBuilder
import com.hlc.fng.dagger.ViewModelKey
import com.hlc.fng.main.home.HomeFragment
import com.hlc.fng.main.home.HomeFragmentViewModel
import com.hlc.fng.main.record.PagerRecordFragment
import com.hlc.fng.main.record.PagerRecordFragmentViewModel
import com.hlc.fng.main.record.RecordFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PagerRecordFragmentModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun PagerRecordFragment(): PagerRecordFragment

    @Binds
    @IntoMap
    @ViewModelKey(PagerRecordFragmentViewModel::class)
    internal abstract fun bindViewModel(viewModel: PagerRecordFragmentViewModel): ViewModel
}
