package com.hlc.fng.main.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.hlc.fng.base.BaseDaggerFragment
import com.hlc.fng.databinding.PagerRecordFragmentBinding

class PagerRecordFragment : BaseDaggerFragment(){
    companion object{
        const val TAB_KIND = "TAB_KIND"
        fun newInstance(kind: Int): PagerRecordFragment{
            var fragment = PagerRecordFragment().apply {
                arguments = Bundle().apply { putInt(TAB_KIND,kind) }
            }
            return fragment
        }
    }
    override val viewModel by viewModels<RecordFragmentViewModel> { viewModelFactory }

    override lateinit var binding: PagerRecordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PagerRecordFragmentBinding.inflate(inflater, null, false).apply {
            this.viewModel = this@PagerRecordFragment.viewModel
            this.lifecycleOwner = this@PagerRecordFragment
        }

        initTitle()

        return binding.root
    }

    fun initTitle(){
        viewModel.tv_title.value = arguments?.getInt(TAB_KIND).toString()
        viewModel.tv_title.observe(this, Observer {

        })
    }
}