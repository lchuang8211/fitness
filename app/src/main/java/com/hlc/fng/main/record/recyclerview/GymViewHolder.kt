package com.hlc.fng.main.record.recyclerview

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.R
import com.hlc.fng.data.record.GymInfo
import com.hlc.fng.databinding.GymRecyclerViewBinding
import com.hlc.fng.main.record.RecordFragmentViewModel
import com.hlc.fng.support.AppUtils
import com.hlc.fng.support.Event
import com.hlc.fng.support.EventObserver
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
    fun bind(item: GymInfo, viewModel: RecordFragmentViewModel) {

        binding.viewModel = viewModel
        binding.ivDrawGym.setImageResource(AppUtils.getResources().getIdentifier("gym","drawable","com.hlc.fng"))
        binding.tvFloor.text = item.floor.toString() ?: "0"
        binding.ivDrawGym.setOnTouchListener(View.OnTouchListener { view : View, motionEvent: MotionEvent ->
            viewModel.drawHeight.value = binding.ivDrawGym.height.toFloat()
            viewModel.drawWidth.value = binding.ivDrawGym.width.toFloat()
            viewModel.drawClickPosition_X.value = motionEvent.getX()
            viewModel.drawClickPosition_Y.value = motionEvent.getY()
            Timber.d("ddddddddddddd ${item.name}/${item.floor}")
            return@OnTouchListener false
        })
    }
}