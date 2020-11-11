package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.TeamDetailsFragmentBinding

class TeamDetailsFragment : Fragment() {

    private lateinit var viewModel: TeamDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<TeamDetailsFragmentBinding>(inflater, R.layout.team_details_fragment, container, false)

        viewModel = ViewModelProvider(this).get(TeamDetailsViewModel::class.java)

        return binding.root
    }
}