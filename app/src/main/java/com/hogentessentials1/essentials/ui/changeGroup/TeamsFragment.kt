package com.hogentessentials1.essentials.ui.changeGroup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.TeamsFragmentBinding

class TeamsFragment : Fragment() {

    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: TeamsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.teams_fragment, container, false)

        val application = requireNotNull(this.activity).application

        // TODO dao's
//        val dataSource = EssentialsDatabase.getInstance(application).ChangeGroupDao

        viewModel = ViewModelProvider(this).get(TeamsViewModel::class.java)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this

        viewModel.navigateToTeam.observe(viewLifecycleOwner, Observer {
            it?.let {
                // TODO changegroup ophalen uit dao en meegeven in navigatie
                // TODO navigeer naar het teamdetailscherm
//                this.findNavController().navigate()

                viewModel.onNavigatedToTeamDetail();
            }
        })

        val manager = LinearLayoutManager(activity)
        binding.teamsLV.layoutManager = manager

        val adapter = ChangeGroupAdapter(ChangeGroupListener { teamId ->
            viewModel.onTeamClicked(teamId)
        })

        binding.teamsLV.adapter = adapter;


        return binding.root
    }

}