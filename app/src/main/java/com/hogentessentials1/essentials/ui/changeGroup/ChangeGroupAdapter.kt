package com.hogentessentials1.essentials.ui.changeGroup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.databinding.TeamListItemBinding
import com.hogentessentials1.essentials.generated.callback.OnClickListener

/**
 * @author Simon De Wilde
 *
 * Adapter to convert change group to a view
 */
class ChangeGroupAdapter(val clickListener: ChangeGroupListener) : ListAdapter<ChangeGroup,
        ChangeGroupAdapter.ViewHolder>(ChangeGroupDIffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChangeGroupAdapter.ViewHolder {
        return ViewHolder.from(parent);
    }

    override fun onBindViewHolder(holder: ChangeGroupAdapter.ViewHolder, position: Int) {
        val item = getItem(position);

        holder.bind(clickListener, item);
    }

    class ViewHolder private constructor(val binding: TeamListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: ChangeGroupListener, item: ChangeGroup) {
            binding.changeGroup = item;
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TeamListItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}

class ChangeGroupDIffCallback : DiffUtil.ItemCallback<ChangeGroup>() {
    override fun areItemsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem == newItem;
    }

}

class ChangeGroupListener(val clickListener: (changeGroupIs: Long) -> Unit){
    fun onClick(changeGroup: ChangeGroup) = clickListener(changeGroup.id)
}
