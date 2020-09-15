package com.hlc.fng.main.record.recyclerview.item

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.ItemParent
import com.hlc.fng.main.record.RecordFragmentViewModel

class ItemChildRecyclerViewAdapter : RecyclerView.Adapter<ItemChildViewHolder>() {

    lateinit var viewModel: RecordFragmentViewModel
    var Datas = emptyList<ItemParent.ItemChild>()

    fun submit(data: List<ItemParent.ItemChild>, viewModel: RecordFragmentViewModel) {
        this.viewModel = viewModel
        this.Datas = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemChildViewHolder {
        return ItemChildViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return Datas.size
    }

    override fun onBindViewHolder(holder: ItemChildViewHolder, position: Int) {
        holder.bind(Datas[position], this.viewModel)
    }

}