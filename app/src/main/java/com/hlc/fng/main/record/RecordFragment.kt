package com.hlc.fng.main.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.hlc.fng.base.BaseDaggerFragment
import com.hlc.fng.databinding.RecordFragmentBinding
import com.hlc.fng.main.MainActivityViewModel

class RecordFragment : BaseDaggerFragment() {
    override val viewModel by viewModels<RecordFragmentViewModel> { viewModelFactory }
    val activityViewModel by activityViewModels<MainActivityViewModel> { viewModelFactory }
    override lateinit var binding: RecordFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RecordFragmentBinding.inflate(inflater, container, false).apply {
            this.viewModel = this@RecordFragment.viewModel
            this.activityViewModel = this@RecordFragment.activityViewModel
            this.lifecycleOwner = this@RecordFragment
        }

        initViewPager()

        return binding.root
    }

    private fun initViewPager() {
        var adapter = RecordViewPagerAdapter(
            this.context!!,
            childFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        binding.vpRecord.adapter = adapter
        binding.layoutTab.setupWithViewPager(binding.vpRecord)
    }

}