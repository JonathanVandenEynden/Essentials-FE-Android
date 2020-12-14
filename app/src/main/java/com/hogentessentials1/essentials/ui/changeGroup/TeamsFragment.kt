package com.hogentessentials1.essentials.ui.changeGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.databinding.TeamsFragmentBinding
import com.hogentessentials1.essentials.util.Status
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
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Teams"

        val binding: TeamsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.teams_fragment, container, false)

        val viewModel: TeamsViewModel by inject()

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this

        val adapter = ChangeGroupAdapter(this)

        binding.teamsRV.adapter = adapter

        viewModel.changeGroups.observe(
            viewLifecycleOwner,
            {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            if (resource.data?.isEmpty() == true) {
                                binding.noTeamsBanner.visibility = View.VISIBLE
                                binding.logoLayout.visibility = View.GONE
                            } else {
                                binding.noTeamsBanner.visibility = View.GONE
                                binding.logoLayout.visibility = View.GONE
                            }
                            adapter.submitList(resource.data)
                        }
                        Status.LOADING -> {
                            binding.logoLayout.visibility = View.VISIBLE
                            val rotate = AnimationUtils.loadAnimation(context, R.anim.rotate_logo)
                            binding.imageView2.animation = rotate
                            binding.noTeamsBanner.visibility = View.GONE
                        }
                        Status.ERROR -> {
                            binding.logoLayout.visibility = View.VISIBLE
                            val rotate = AnimationUtils.loadAnimation(context, R.anim.rotate_logo)
                            binding.imageView2.animation = rotate
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
