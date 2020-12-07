package com.hogentessentials.essentials.ui.changeGroup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hogentessentials.essentials.data.model.ChangeGroup
import com.hogentessentials.essentials.databinding.TeamListItemBinding

/**
 * @author Simon De Wilde
 *
 * Adapter to convert change group to a view
 */
class ChangeGroupAdapter(private var clickClickListener: ChangeGroupClickListener) :
    ListAdapter<ChangeGroup, ChangeGroupViewHolder>(ChangeGroupDIffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChangeGroupViewHolder {
        return ChangeGroupViewHolder(TeamListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ChangeGroupViewHolder, position: Int) {
        val changeGroup = getItem(position)
        holder.bindData(changeGroup)
        holder.itemView.setOnClickListener {
            clickClickListener.onClick(changeGroup)
        }
    }
}

class ChangeGroupDIffCallback : DiffUtil.ItemCallback<ChangeGroup>() {
    override fun areItemsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem == newItem
    }
}

interface ChangeGroupClickListener {
    fun onClick(changeGroup: ChangeGroup)
}
