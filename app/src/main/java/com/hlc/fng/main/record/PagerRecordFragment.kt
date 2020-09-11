package com.hlc.fng.main.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.hlc.fng.base.BaseDaggerFragment
import com.hlc.fng.data.record.GymInfo
import com.hlc.fng.databinding.PagerRecordFragmentBinding
import com.hlc.fng.main.record.recyclerview.GymRecyclerViewAdapter
import kotlinx.android.synthetic.main.gym_recycler_view.view.*
import timber.log.Timber

class PagerRecordFragment : BaseDaggerFragment() {
    companion object {
        const val TAB_KIND = "TAB_KIND"
        fun newInstance(kind: Int): PagerRecordFragment {
            var fragment = PagerRecordFragment().apply {
                arguments = Bundle().apply { putInt(TAB_KIND, kind) }
            }
            return fragment
        }
    }

    override val viewModel by viewModels<RecordFragmentViewModel> { viewModelFactory }

    override lateinit var binding: PagerRecordFragmentBinding
    private var kind: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PagerRecordFragmentBinding.inflate(inflater, null, false).apply {
            this.viewModel = this@PagerRecordFragment.viewModel
            this.lifecycleOwner = this@PagerRecordFragment
        }
        kind = arguments?.getInt(TAB_KIND, 0)!!

        initTitle()
        initDraw()

        return binding.root
    }

    var gymData = emptyList<GymInfo>()

    private fun initDraw() {
        when (kind) {
            2, 3 -> {
                binding.rvGym.visibility = View.VISIBLE
                binding.layoutLl.visibility = View.VISIBLE
                var adapter = GymRecyclerViewAdapter().apply { this.submit(gymData, this@PagerRecordFragment.viewModel) }
                binding.rvGym.adapter = adapter
                binding.rvGym.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                viewModel.bitmapEvent.observe(this, Observer {
                    Timber.d("ccccc")
                    binding.rvGym.rootView.iv_draw_gym.setImageBitmap(viewModel.bitmap)
                })

            }
            else -> {
                binding.rvGym.visibility = View.GONE
                binding.layoutLl.visibility = View.GONE
            }
        }
    }

    fun initTitle() {
        viewModel.tv_title.value = arguments?.getInt(TAB_KIND).toString()
    }
}