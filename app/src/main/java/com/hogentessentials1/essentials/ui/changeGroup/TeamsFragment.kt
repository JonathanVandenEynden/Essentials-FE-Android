package com.hogentessentials1.essentials.ui.changeGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.util.Status
import com.hogentessentials1.essentials.databinding.TeamsFragmentBinding
import org.koin.android.ext.android.inject

/**
 * @author Simon De Wilde
 *
 * Fragment for showing the overview of teams
 */
class TeamsFragment : Fragment(), ChangeGroupClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Teams"

        val binding: TeamsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.teams_fragment, container, false)

        val application = requireNotNull(this.activity).application

        // TODO dao's
//        val dataSource = EssentialsDatabase.getInstance(application).ChangeGroupDao

        val viewModel: TeamsViewModel by inject()

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this

        val adapter = ChangeGroupAdapter(this)

        binding.teamsRV.adapter = adapter

        viewModel.changeGroups.observe(
            viewLifecycleOwner,
            Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            adapter.submitList(resource.data)
                        }
                    }
                }
            }
        )

        return binding.root
    }

    override fun onClick(changeGroup: ChangeGroup) {
        navigateToDetail(changeGroup)
    }

    private fun navigateToDetail(changeGroup: ChangeGroup) {

        val directions =
            TeamsFragmentDirections.actionTeamsFragmentToTeamDetailsFragment(changeGroup.users!!.map { u -> u.firstName.plus(" ").plus(u.lastName) }.toTypedArray())
        findNavController().navigate(directions)
    }
}
