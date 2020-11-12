package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.TeamDetailsFragmentBinding

/**
 * @author Simon De Wilde
 *
 * Fragment for showing the team members
 */
class TeamDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<TeamDetailsFragmentBinding>(
            inflater,
            R.layout.team_details_fragment,
            container,
            false
        )


        val changeGroupMembers = arguments?.getStringArrayList("ChangeGroupMembers")!!


        val adapter =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    R.layout.change_group_member_item,
                    changeGroupMembers
                )
            }

        binding.membersListView.adapter = adapter



        binding.membersListView.adapter = adapter

        return binding.root
    }
}