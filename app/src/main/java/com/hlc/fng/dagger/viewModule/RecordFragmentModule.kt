package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.hlc.fng.dagger.ViewModelBuilder
import com.hlc.fng.dagger.ViewModelKey
import com.hlc.fng.main.record.RecordFragment
import com.hlc.fng.main.record.RecordFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class RecordFragmentModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun RecordFragment(): RecordFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecordFragmentViewModel::class)
    internal abstract fun bindViewModel(viewModel: RecordFragmentViewModel): ViewModel
}
