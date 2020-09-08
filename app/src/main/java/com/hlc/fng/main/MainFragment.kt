package com.hlc.fng.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.fng.base.BaseDaggerFragment
import com.hlc.fng.databinding.MainFragmentBinding

class MainFragment : BaseDaggerFragment(){

    override val viewModel by viewModels<MainFragmentViewModel> { viewModelFactory }
    val activityViewModel by activityViewModels<MainActivityViewModel> { viewModelFactory }
    override lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MainFragmentBinding.inflate(inflater, null, false).apply {
            this.viewModel = this@MainFragment.viewModel
            this.lifecycleOwner = this@MainFragment
        }
        return binding.root
    }
}