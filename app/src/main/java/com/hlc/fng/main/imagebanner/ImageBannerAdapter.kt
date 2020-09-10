package com.hlc.fng.main.imagebanner

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.source.local.imagebanner.ImageBanner
import com.hlc.fng.main.MainFragmentViewModel
import com.youth.banner.adapter.BannerAdapter

private const val TAG = "ImageBannerAdapter"

class ImageBannerAdapter(
    imageBanner: ArrayList<ImageBanner>,
    var viewModel: MainFragmentViewModel
) : BannerAdapter<ImageBanner, ImageBannerViewHolder>(imageBanner) {

    var ImageList = ArrayList<ImageBanner>()

    fun submit(list: ArrayList<ImageBanner>) {
        this.ImageList = list
    }

    init {
        this.ImageList = imageBanner
        Log.i(TAG, "init size: " + this.ImageList.size)
    }

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): ImageBannerViewHolder {
        return ImageBannerViewHolder.from(parent)
    }

    override fun onBindView(
        holder: ImageBannerViewHolder,
        data: ImageBanner?,
        position: Int,
        size: Int
    ) {
        holder.bind(ImageList[position], viewModel)
    }


}



