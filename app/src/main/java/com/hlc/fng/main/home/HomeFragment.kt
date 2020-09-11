package com.hlc.fng.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.base.BaseDaggerFragment
import com.google.android.material.appbar.AppBarLayout
import com.hlc.fng.databinding.HomeFragmentBinding

import com.hlc.fng.main.MainActivityViewModel
import com.hlc.fng.main.autotextbanner.TextBannerAdapter
import com.hlc.fng.main.imagebanner.CircleIndicator
import com.youth.banner.Banner

class HomeFragment : BaseDaggerFragment() {

    override val viewModel by viewModels<HomeFragmentViewModel> { viewModelFactory }
    private val activityViewModel by activityViewModels<MainActivityViewModel> { viewModelFactory }
    override lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater, null, false).apply {
            this.viewModel = this@HomeFragment.viewModel
            this.activityViewModel = this@HomeFragment.activityViewModel
            this.lifecycleOwner = this@HomeFragment
        }

        initHeader()
        initScroll()
        initObserver()
        initAutoBanner()
        initImageBanner()
        initComponent()

        return binding.root
    }

    private fun initScroll() {
        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalY ->
            /** 自訂義三種狀態，操作AppBar， verticalY 為 View 的 Y 軸位移量，向上為負數
             *  1.完全展開 verticalY = 0
             *  2.完全折疊 verticalY = -總高
             *  3.中間狀態 -總高 < verticalY < 0
             *  */
            val totalScrollRange = appBarLayout.totalScrollRange
            if (verticalY == 0) {
//                Log.i(TAG, "appBarLayout 完全展開: $verticalY")
                viewModel.gotoTopEvent.value = false
            } else if (verticalY == (-1 * totalScrollRange)) {
//                Log.i(TAG, "appBarLayout 完全折疊: $verticalY")
            } else {
//                Log.i(TAG, "appBarLayout 中間狀態: $verticalY")
                viewModel.gotoTopEvent.value = true
            }
        })
        /**
         * Called when the scroll position of a view changes.
         *
         * @param v The view whose scroll position has changed.
         * @param scrollX Current horizontal scroll origin.
         * @param scrollY Current vertical scroll origin.
         * @param oldScrollX Previous horizontal scroll origin.
         * @param oldScrollY Previous vertical scroll origin.
         */
        binding.nestedSv.setOnScrollChangeListener { view: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
//            Log.i(TAG, "initScroll: y: " + scrollY + "old y: " + oldScrollY)
            viewModel.gotoTopEvent.value = scrollY > 0
//            if (scrollY > 0){
//                viewModel.gotoTopEvent.value = true }
//            else {
//                viewModel.gotoTopEvent.value = false }
        }
    }

    private fun initHeader() {
        activityViewModel.headerTitle.value = " Hello "
        activityViewModel.headerBackVisiable.value = false
        activityViewModel.headerLeftMenuVisiable.value = true
    }

    private fun initObserver() {

    }

    private fun initAutoBanner() {
        var BannerList = arrayListOf<String>("11", "22", "33", "44")
        val adapter = TextBannerAdapter(viewModel).apply { this.submit(BannerList) }
        binding.rvAotuBanner.adapter = adapter
        binding.rvAotuBanner.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvAotuBanner.start()
    }

    private fun initImageBanner() {
//        var adapter = ImageBannerAdapter(viewModel.ImageBannerList, viewModel)
        binding.ivYouBanner.apply {
            this.adapter = viewModel.adapter
            this.setLoopTime(3000)
            this.setOrientation(Banner.HORIZONTAL)
            var indicator = CircleIndicator(context)
            this.setIndicator(indicator, true)
            //設定畫廊模式 setBannerGalleryEffect( int 左邊顯示寬度, int 右邊顯示寬度, int 圖片間隔寬度)
            binding.ivYouBanner.setBannerGalleryEffect(30, 30, 10)
        }
    }

    private fun initComponent() {
        binding.btnGotoTop.setOnClickListener(View.OnClickListener {
            binding.appBar.setExpanded(true)
            binding.nestedSv.scrollTo(0, 0)
        })
    }


}