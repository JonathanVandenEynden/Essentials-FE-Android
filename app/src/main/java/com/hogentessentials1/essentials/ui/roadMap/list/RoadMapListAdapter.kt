package com.hogentessentials1.essentials.ui.roadMap.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.RoadmapItemBinding

/**
 * @author Ziggy Moens
 */

class RoadMapAdapter(val clickListener: RoadMapListener) :
    ListAdapter<RoadMapItem, RoadMapAdapter.ViewHolder>(RoadMapDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RoadmapItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: RoadMapListener, item: RoadMapItem) {
            binding.roadmapItem = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    RoadmapItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class RoadMapDiffCallback : DiffUtil.ItemCallback<RoadMapItem>() {
    override fun areItemsTheSame(oldItem: RoadMapItem, newItem: RoadMapItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RoadMapItem, newItem: RoadMapItem): Boolean {
        return oldItem == newItem
    }
}

class RoadMapListener(val clickListener: (roadMapItem: RoadMapItem) -> Unit) {
    fun onClick(roadMapItem: RoadMapItem) = clickListener(roadMapItem)
}
