package com.hogentessentials1.essentials.ui.changeInitiatives

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.databinding.ChangeInitiativeListItemBinding

/**
 * @author Simon De Wilde
 *
 * Converts Change Initiatives to views
 */
class ChangeInitiativeAdapter(val clickListener: ChangeInitiativeListener) :
    ListAdapter<ChangeInitiative, ChangeInitiativeAdapter.ViewHolder>(ChangeInitiativeDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ChangeInitiativeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: ChangeInitiativeListener, item: ChangeInitiative) {
            binding.changeInitiative = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ChangeInitiativeListItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
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
