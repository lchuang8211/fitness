package com.hlc.fng.main.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.hlc.fng.base.BaseDaggerFragment
import com.hlc.fng.databinding.GraphFragmentBinding
import com.hlc.fng.databinding.RecordFragmentBinding
import com.hlc.fng.main.MainActivityViewModel

class GraphFragment : BaseDaggerFragment() {
    override val viewModel by viewModels<GraphFragmentViewModel> { viewModelFactory }
    private val activityViewModel by activityViewModels<MainActivityViewModel> { viewModelFactory }
    override lateinit var binding: GraphFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = GraphFragmentBinding.inflate(inflater, container, false).apply {
            this.viewModel = this@GraphFragment.viewModel
            this.activityViewModel = this@GraphFragment.activityViewModel
            this.lifecycleOwner = this@GraphFragment
        }

        return binding.root
    }

}