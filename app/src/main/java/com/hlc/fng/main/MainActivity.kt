package com.hlc.fng.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.PopupWindow
import android.widget.Toast
import androidx.activity.viewModels
import androidx.constraintlayout.widget.Constraints
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.hlc.fng.base.BaseActivity
import com.hlc.fng.R
import com.hlc.fng.databinding.ActivityMainBinding
import com.hlc.fng.databinding.LeftPopupWindowBinding
import com.hlc.fng.databinding.RightPopupWindowBinding

class MainActivity : BaseActivity() {

    override val viewModel by viewModels<MainActivityViewModel> { viewModelFactory }
    override lateinit var binding: ActivityMainBinding

    lateinit var leftPopupWindowBinding: LeftPopupWindowBinding
    lateinit var leftPopupWindow: PopupWindow

    lateinit var rightPopupWindowBinding: RightPopupWindowBinding
    lateinit var rightPopupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initHeader()
        initComponent()
        initPopupWindow()
        initObserver()
        initBottomNavigation()
    }

    private fun initObserver() {
        viewModel.leftPopupWindowOpen.observe(this, Observer {
            leftPopupWindow.showAtLocation(
                binding.layoutHeader.ivHeaderLeftMenu,
                Gravity.LEFT or Gravity.TOP,
                0,
                binding.layoutHeader.layoutHeaderBar.height
            )
        })
        viewModel.rightPopupWindowOpen.observe(this, Observer {
            rightPopupWindow.showAtLocation(
                binding.layoutHeader.ivHeaderRightMenu,
                Gravity.TOP,
                0,
                binding.layoutHeader.layoutHeaderBar.height
            )
        })
    }

    private fun initPopupWindow() {
        /** 懸浮框 PopupWindow
         * 1.建立 Layout 的 xml
         * 2.DataBinding with view/layout
         * 3.Binding ViewModel
         * 4.把 Layout 丟給 PopupWindow
         * 5.設定 PopupWindow 相關設定
         * */

        leftPopupWindowBinding =
            LeftPopupWindowBinding.inflate(LayoutInflater.from(this), null, false)
        leftPopupWindowBinding.viewModel = this.viewModel

        leftPopupWindow = PopupWindow(
            leftPopupWindowBinding.root,
            Constraints.LayoutParams.WRAP_CONTENT,
            Constraints.LayoutParams.WRAP_CONTENT,
            true
        )
        leftPopupWindow.isOutsideTouchable = true

        rightPopupWindowBinding =
            RightPopupWindowBinding.inflate(LayoutInflater.from(this), null, false)
        rightPopupWindowBinding.viewModel = this.viewModel

        rightPopupWindow = PopupWindow(
            rightPopupWindowBinding.root,
            Constraints.LayoutParams.WRAP_CONTENT,
            Constraints.LayoutParams.MATCH_PARENT,
            true
        )
        rightPopupWindow.isOutsideTouchable = true

    }

    private fun initHeader() {
        viewModel.headerBackArrow.observe(this, Observer {
            onBackPressed()
        })
        viewModel.headerLeftMenu.observe(this, Observer {
            Toast.makeText(this, "LeftMenu", Toast.LENGTH_SHORT).show()
        })
    }

    fun initComponent() {

        Navigation.findNavController(this, R.id.frg_under_activity).apply {
            var navGraph = this.navInflater.inflate(R.navigation.fngnavigation).apply {
                this.startDestination = R.id.start_fragment
            }
            this.setGraph(navGraph)
        }
    }

    @SuppressLint("ResourceType")
    private fun initBottomNavigation() {
        var navController = Navigation.findNavController(this, R.id.frg_under_activity)
        viewModel.botNavHome.observe(this, Observer {
            navController.navigate(R.id.start_fragment)
            viewModel.headerTitle.value = this.resources.getString(R.string.home_fragment)
        })
        viewModel.botNavRecord.observe(this, Observer {
            navController.navigate(R.id.record_fragment)
            viewModel.headerTitle.value = this.resources.getString(R.string.record_fragment)
        })
        viewModel.botNavGraph.observe(this, Observer {
            navController.navigate(R.id.graph_fragment)
            viewModel.headerTitle.value = this.resources.getString(R.string.graph_fragment)
        })
    }


}