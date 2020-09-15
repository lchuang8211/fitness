package com.hlc.fng.main.record.recyclerview.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.ItemParent
import com.hlc.fng.databinding.RvLayoutRecordItemChildBinding
import com.hlc.fng.main.record.RecordFragmentViewModel
import timber.log.Timber

class ItemChildViewHolder(val binding: RvLayoutRecordItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): ItemChildViewHolder {
            val binding =
                RvLayoutRecordItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemChildViewHolder(binding)
        }
    }

    //顯示資料的規則/邏輯
    fun bind(item: ItemParent.ItemChild, viewModel: RecordFragmentViewModel) {
        binding.viewModel = viewModel
        binding.btnItem.text = item.cid
        Timber.i("ItemChild cid: ${item.cid}")
    }
}