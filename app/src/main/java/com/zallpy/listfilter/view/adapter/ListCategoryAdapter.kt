package com.zallpy.listfilter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zallpy.listfilter.databinding.ResItemListBinding
import com.zallpy.listfilter.model.Categories

class ListCategoryAdapter(private val list: MutableList<Categories>) : Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ListViewHolder(
            ResItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ListViewHolder -> {
                holder.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListViewHolder constructor(
        itemView: ResItemListBinding
        ) : ViewHolder(itemView.root) {
        private val titleList = itemView.title
        private val descList = itemView.desc

        fun bind(categories: Categories) {
            titleList.text = categories.title
            descList.text = categories.description
        }
    }
}