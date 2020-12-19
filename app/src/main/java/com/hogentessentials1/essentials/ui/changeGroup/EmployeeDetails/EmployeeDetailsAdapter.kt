package com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.databinding.ChangeGroupMemberItemBinding

class EmployeeDetailsAdapter(val clickListener: EmployeeListener) :
    ListAdapter<Employee, EmployeeDetailsAdapter.ViewHolder>(EmployeeDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ChangeGroupMemberItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(clickListener: EmployeeListener, item: Employee){
            binding.employee = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ChangeGroupMemberItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class EmployeeDiffCallback : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}

class EmployeeListener(val clickListener: (employee: Employee ) -> Unit) {
    fun onClick(employee: Employee) = clickListener(employee)
}

