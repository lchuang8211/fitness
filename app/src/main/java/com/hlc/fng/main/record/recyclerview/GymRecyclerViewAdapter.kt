package com.hlc.fng.main.record.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.GymInfo
import com.hlc.fng.main.record.RecordFragmentViewModel

class GymRecyclerViewAdapter : RecyclerView.Adapter<GymViewHolder>() {

    lateinit var viewModel: RecordFragmentViewModel
    var Datas = emptyList<GymInfo>()
    fun submit(data: List<GymInfo>, viewModel: RecordFragmentViewModel) {
        this.viewModel = viewModel
//        this.Datas = data
        this.Datas = listOf(
            GymInfo(
                name = "gym",
                floor = 1
            ),
            GymInfo(
                name = "yoga1",
                floor = 2
            ),
            GymInfo(
                name = "gym",
                floor = 3
            ),
            GymInfo(
                name = "yoga4",
                floor = 4
            )
        )
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        return GymViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return Datas.size
    }

    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        holder.bind(Datas[position], viewModel)
    }

}