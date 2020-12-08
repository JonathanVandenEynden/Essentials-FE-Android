package com.hogentessentials1.essentials.ui.changeGroup

import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.databinding.TeamListItemBinding

/**
 * @author Simon De Wilde
 *
 * The viewholder for a changeGroup (team)
 */
class ChangeGroupViewHolder(val binding: TeamListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: ChangeGroup) {
        binding.changeGroup = item
    }
}
