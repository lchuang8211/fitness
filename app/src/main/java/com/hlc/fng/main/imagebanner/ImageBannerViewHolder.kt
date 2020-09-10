package com.hlc.fng.main.imagebanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.source.local.imagebanner.ImageBanner
import com.hlc.fng.databinding.LayoutImageBannerBinding
import com.hlc.fng.main.MainFragmentViewModel
import com.hlc.fng.support.AppUtils

class ImageBannerViewHolder(var binding: LayoutImageBannerBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup) : ImageBannerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = LayoutImageBannerBinding.inflate(layoutInflater, parent,false)
            binding.ivBannerItem.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            binding.ivBannerItem.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            return ImageBannerViewHolder(binding)
        }
    }

    fun bind(imageBanner: ImageBanner, viewModel: MainFragmentViewModel){
        binding.imagebanner = imageBanner
        binding.ivBannerItem.setBackgroundResource(AppUtils.getResources().getIdentifier(imageBanner.imgURL, "drawable", "com.hlc.fng"))
        binding.ivBannerItem.setOnClickListener(View.OnClickListener {
            Toast.makeText(AppUtils.getContext(),imageBanner.imgName,Toast.LENGTH_SHORT).show()
        })
    }
}