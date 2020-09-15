package com.hlc.fng.main.record.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlc.fng.data.record.GymInfo
import com.hlc.fng.data.source.local.MyData
import com.hlc.fng.main.record.RecordFragmentViewModel

class GymRecyclerViewAdapter : RecyclerView.Adapter<GymViewHolder>() {

    lateinit var viewModel: RecordFragmentViewModel
    var Datas = emptyList<MyData>()
    fun submit(data: List<MyData>, viewModel: RecordFragmentViewModel) {
        this.viewModel = viewModel
        this.Datas = data
        this.Datas = listOf(
            MyData(
                name = "gym",
                imageName = "你",
                imageFloor = "1" ,
                imageUri = ""
            ),
            MyData(
                name = "yoga1",
                imageName = "好",
                imageFloor = "2" ,
                imageUri = ""
            ),
            MyData(
                name = "gym",
                imageName = "嗎",
                imageFloor = "3" ,
                imageUri = ""
            ),
            MyData(
                name = "yoga4",
                imageName = "他",
                imageFloor = "4" ,
                imageUri = ""
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