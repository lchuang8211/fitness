package com.hlc.fng.main.autotextbanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.databinding.AutoTextBannerBinding
import com.hlc.fng.main.MainFragmentViewModel

class TextBannerViewHolder constructor(var binding: AutoTextBannerBinding) : RecyclerView.ViewHolder(binding.root){
    companion object{
        fun from(parent: ViewGroup): TextBannerViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = AutoTextBannerBinding.inflate(layoutInflater,parent,false)
            return TextBannerViewHolder(binding)
        }

    }
    fun bind(item: String, viewModel: MainFragmentViewModel){
        binding.viewModel = viewModel
        binding.tvBanner.text = item
    }
}