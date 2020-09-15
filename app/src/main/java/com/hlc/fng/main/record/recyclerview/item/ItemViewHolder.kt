package com.hlc.fng.main.record.recyclerview.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.ItemParent
import com.hlc.fng.databinding.RvLayoutRecordItemBinding
import com.hlc.fng.main.record.RecordFragmentViewModel
import com.hlc.fng.support.AppUtils
import timber.log.Timber

class ItemViewHolder(val binding: RvLayoutRecordItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): ItemViewHolder {
            val binding =
                RvLayoutRecordItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ItemViewHolder(binding)
        }
    }

    var rvPool = RecyclerView.RecycledViewPool()
    //顯示資料的規則/邏輯
    fun bind(item: ItemParent, viewModel: RecordFragmentViewModel, life: LifecycleOwner) {
        binding.viewModel = viewModel
        binding.item = item
//        binding.lifecycleOwner = life
        binding.btnItem.text = item.id

        var childItem =
            ArrayList<ItemParent.ItemChild>().apply { this.add(ItemParent.ItemChild(cid = item.id + " CCC")) }
        Timber.i("childItem : ${childItem[0]}")

        var childAdapter =
            ItemChildRecyclerViewAdapter().apply { this.submit(childItem, viewModel) }
        rvPool.putRecycledView(childAdapter.createViewHolder(binding.rvItemChild, 0))
        binding.rvItemChild.setRecycledViewPool(rvPool)
        binding.rvItemChild.adapter = childAdapter
        binding.rvItemChild.layoutManager =
            LinearLayoutManager(AppUtils.getContext(), LinearLayout.VERTICAL, false)
        binding.btnItem.setOnClickListener(View.OnClickListener {
            item.vis = item.vis == false
//            viewModel.childFlag.value = item.vis
            if (item.vis)
                binding.rvItemChild.visibility = View.VISIBLE
            else
                binding.rvItemChild.visibility = View.GONE
            Timber.i("flag : ${item.vis}")
        })
    }
}