package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.databinding.TeamdetailsListitemBinding

/**
 * Adapter for the list of Teams
 * @author Jonathan Vanden Eynden Van Lysebeth
 */

class TeamDetailsListAdapter(val clickListener: TeamDetailsClickListener) : ListAdapter<Employee, TeamDetailsListAdapter.ViewHolder>(TeamDetailsDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: TeamdetailsListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: TeamDetailsClickListener, item: Employee) {
            binding.employee = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    TeamdetailsListitemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class TeamDetailsDiffCallback : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}

class TeamDetailsClickListener(val clickListener: (employee: Employee) -> Unit) {
    fun onClick(employee: Employee) = clickListener(employee)
}
