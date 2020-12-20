package com.hogentessentials1.essentials.ui.changeGroup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.databinding.TeamListItemBinding

/**
 * Adapter to convert change group to a view
 * @author Simon De Wilde
 *
 * @property clickListener
 */
class ChangeGroupAdapter(private var clickListener: ChangeGroupClickListener) :
    ListAdapter<ChangeGroup, ChangeGroupViewHolder>(ChangeGroupDIffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChangeGroupViewHolder {
        return ChangeGroupViewHolder(
            TeamListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    /**
     * binds a new item in the viewholder
     */
    override fun onBindViewHolder(holder: ChangeGroupViewHolder, position: Int) {
        val changeGroup = getItem(position)
        holder.bindData(changeGroup)
        holder.itemView.setOnClickListener {
            clickListener.onClick(changeGroup)
        }
    }
}

class ChangeGroupDIffCallback : DiffUtil.ItemCallback<ChangeGroup>() {
    /**
     * @param newItem
     * @param oldItem
     * @return true if the id's of the items are the same
     * are 2 items the same?
     */
    override fun areItemsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * @param newItem
     * @param oldItem
     * @return true if the 2 items are the same
     * are the contents 2 items the same?
     */
    override fun areContentsTheSame(oldItem: ChangeGroup, newItem: ChangeGroup): Boolean {
        return oldItem == newItem
    }
}

/**
 * @author Simon De Wilde
 * simple click listener for a change group
 */
interface ChangeGroupClickListener {
    fun onClick(changeGroup: ChangeGroup)
}
