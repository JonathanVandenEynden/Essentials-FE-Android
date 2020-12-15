package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.TeamDetailsFragmentBinding

/**
 * @author Simon De Wilde
 *
 * Fragment for showing the team members of a change group
 */
class TeamDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<TeamDetailsFragmentBinding>(
            inflater,
            R.layout.team_details_fragment,
            container,
            false
        )

        var changeGroupMembers = arrayListOf<String>().toTypedArray()

        arguments?.getStringArray("changeGroupMembers")?.let {
            changeGroupMembers = it
        }

        val adapter = activity?.let { ArrayAdapter<String>(it, R.layout.change_group_member_item, changeGroupMembers) }

        binding.membersListView.adapter = adapter

        (activity as AppCompatActivity).supportActionBar?.title = "Team members"

        return binding.root
    }
}
