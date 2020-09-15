package com.hlc.fng.main.record.recyclerview.item

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.ItemParent
import com.hlc.fng.main.record.RecordFragmentViewModel

class ItemRecyclerViewAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    lateinit var viewModel: RecordFragmentViewModel
    var Datas = emptyList<ItemParent>()
    lateinit var life : LifecycleOwner

    fun submit(data: List<ItemParent>, viewModel: RecordFragmentViewModel, life: LifecycleOwner) {
        this.viewModel = viewModel
        this.Datas = data
        this.life = life
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return Datas.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(Datas[position], viewModel, life )
    }

}