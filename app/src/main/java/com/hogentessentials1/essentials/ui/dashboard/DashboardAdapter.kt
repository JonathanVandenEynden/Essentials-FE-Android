package com.hogentessentials1.essentials.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.databinding.ChangeInitiativeListItemBinding
import kotlin.coroutines.coroutineContext

/**
 */
class DashboardAdapter() :
    ListAdapter<ChangeInitiative, DashboardAdapter.ViewHolder>(ChangeInitiativeDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: TextView) :
        RecyclerView.ViewHolder(binding.rootView) {

        fun bind(item: ChangeInitiative) {
            binding.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }
}

class ChangeInitiativeDiffCallback : DiffUtil.ItemCallback<ChangeInitiative>() {
    override fun areItemsTheSame(oldItem: ChangeInitiative, newItem: ChangeInitiative): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ChangeInitiative, newItem: ChangeInitiative): Boolean {
        return oldItem == newItem
    }
}

class ChangeInitiativeListener(val clickListener: (changeInitiative: ChangeInitiative) -> Unit) {
    fun onClick(changeInitiative: ChangeInitiative) = clickListener(changeInitiative)
}
