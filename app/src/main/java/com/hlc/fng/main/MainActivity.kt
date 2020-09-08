package com.hlc.fng.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.fng.base.BaseActivity
import com.hlc.fng.R
import com.hlc.fng.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    override val viewModel by viewModels<MainActivityViewModel> { viewModelFactory }

    override lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.tvFirst.text = "567890----"
    }



}