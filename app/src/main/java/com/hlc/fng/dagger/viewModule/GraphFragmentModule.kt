package com.hlc.fng.dagger.viewModule

import androidx.lifecycle.ViewModel
import com.hlc.fng.dagger.ViewModelBuilder
import com.hlc.fng.dagger.ViewModelKey
import com.hlc.fng.main.graph.GraphFragment
import com.hlc.fng.main.graph.GraphFragmentViewModel
import com.hlc.fng.main.record.RecordFragment
import com.hlc.fng.main.record.RecordFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class GraphFragmentModule {

    @ContributesAndroidInjector( modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun GraphFragment(): GraphFragment

    @Binds
    @IntoMap
    @ViewModelKey(GraphFragmentViewModel::class)
    internal abstract fun bindViewModel(viewModel: GraphFragmentViewModel): ViewModel
}
