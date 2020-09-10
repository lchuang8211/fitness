package com.hlc.fng.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fng.base.BaseViewModel
import com.hlc.fng.data.source.local.imagebanner.ImageBanner
import com.hlc.fng.main.imagebanner.ImageBannerAdapter
import com.youth.banner.adapter.BannerAdapter
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor() : BaseViewModel() {

    var gotoTopEvent = MutableLiveData<Boolean>().apply { value = false }
    var adapter : ImageBannerAdapter

    fun gotoTop() {
        gotoTopEvent.value = true
    }

    var ImageBannerList = ArrayList<ImageBanner>().apply {
        this.add(ImageBanner(imgName = "GYM", imgURL = "gym"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga1"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga2"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga3"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga4"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga5"))
        this.add(ImageBanner(imgName = "YOGA", imgURL = "yoga6"))
        adapter = ImageBannerAdapter(this,this@MainFragmentViewModel)
    }
}