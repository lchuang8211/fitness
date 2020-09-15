package com.hlc.fng.main.record.recyclerview

import android.net.Uri
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.GymInfo
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.databinding.GymRecyclerViewBinding
import com.hlc.fng.main.record.RecordFragmentViewModel
import com.hlc.fng.support.AppUtils
import timber.log.Timber

class GymViewHolder(val binding: GymRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): GymViewHolder {
            val binding =
                GymRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GymViewHolder(binding)
        }
    }

    //顯示資料的規則/邏輯
    fun bind(item: MyData, viewModel: RecordFragmentViewModel) {

        binding.viewModel = viewModel
        binding.ivDrawGym.setImageResource(
            AppUtils.getResources().getIdentifier("had", "drawable", "com.hlc.fng")
        )
        if (item.imageUri.isNotEmpty()) {
            binding.ivDrawGym.setImageURI(Uri.parse(item.imageUri))
        }

        binding.tvGName.text = item.name
        binding.tvFloor.text = item.imageFloor.toString() ?: "0"
//        if (item.imageName.isNotEmpty())
//            binding.viewModel.ImgName.value = item.imageName ?: return

        binding.ivDrawGym.setOnTouchListener(View.OnTouchListener { view: View, motionEvent: MotionEvent ->
            viewModel.drawHeight.value = binding.ivDrawGym.height.toFloat()
            viewModel.drawWidth.value = binding.ivDrawGym.width.toFloat()
            viewModel.drawClickPosition_X.value = motionEvent.getX()
            viewModel.drawClickPosition_Y.value = motionEvent.getY()
            viewModel.ImgName.value = item.imageName
            Timber.d("ddddddddddddd ${item.name}/${item.imageFloor}")
            return@OnTouchListener false
        })
    }
}