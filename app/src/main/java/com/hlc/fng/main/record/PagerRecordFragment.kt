package com.hlc.fng.main.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hlc.fng.base.BaseDaggerFragment
import com.hlc.fng.data.record.ItemParent
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.databinding.PagerRecordFragmentBinding
import com.hlc.fng.main.record.recyclerview.GymRecyclerViewAdapter
import com.hlc.fng.main.record.recyclerview.item.ItemRecyclerViewAdapter
import com.hlc.fng.support.AppUtils
import kotlinx.android.synthetic.main.gym_recycler_view.view.*
import timber.log.Timber

class PagerRecordFragment :
    BaseDaggerFragment() {
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
        initRecyclerView()

        return binding.root
    }

    var gymData = ArrayList<MyData>()

    private fun initDraw() {
//        viewModel.getImg()

        viewModel.getImg.observe(this, Observer {
            if (it.isEmpty()) {
                Timber.d("444444 ${it.size}")
                binding.btnNew.setOnClickListener(View.OnClickListener {
                    //alertDialog 1.image 2.info 3,room

                    binding.rvGym.rootView.iv_draw_gym.apply {
                        this.setImageResource(
                            AppUtils.getResources().getIdentifier("had", "drawable", "com.hlc.fng")
                        )
                        viewModel.drawHeight.value = this.height.toFloat()
                        viewModel.drawWidth.value = this.width.toFloat()
                    }
                    //viewModel.一件事()
                })
            }
        })

        when (kind) {
            2, 3 -> {
                binding.rvGym.visibility = View.VISIBLE
                binding.layoutLl.visibility = View.VISIBLE
                var adapter = GymRecyclerViewAdapter().apply {
                    this.submit(
                        gymData,
                        this@PagerRecordFragment.viewModel
                    )
                }
                binding.rvGym.adapter = adapter
                binding.rvGym.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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

        viewModel.btnAddImageEvent.observe(this, Observer {
            gymData.add(
                MyData(
                    name = "",
                    imageName = binding.rvGym.rootView.tv_g_name.toString(),
                    imageFloor = binding.rvGym.rootView.tv_floor.toString(),
                    imageUri = ""
                )
            )
            GymRecyclerViewAdapter().apply { this.submit(gymData, viewModel) }
        })

    }

    fun initTitle() {
        viewModel.tv_title.value = arguments?.getInt(TAB_KIND).toString()
    }

    fun initRecyclerView(){
        var dataList = ArrayList<ItemParent>().apply {
            this.add(ItemParent(id = "1",vis = false))
            this.add(ItemParent(id = "2",vis = false))
            this.add(ItemParent(id = "3",vis = false))
            this.add(ItemParent(id = "4",vis = false))
        }
        var adapter = ItemRecyclerViewAdapter().apply {
            this.submit(dataList, this@PagerRecordFragment.viewModel, this@PagerRecordFragment)
        }
        binding.rvItem.adapter = adapter
        binding.rvItem.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    }

}