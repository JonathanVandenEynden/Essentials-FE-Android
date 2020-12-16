package com.hogentessentials1.essentials.ui.changeinitiative

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.ChangeinitiativeBinding
import com.hogentessentials1.essentials.ui.LoadingFragment

/**
 * @author Ziggy Moens
 */

class ChangeInitiativeFragment : Fragment() {

    lateinit var viewModel: ChangeinitiativeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: ChangeinitiativeBinding =
            DataBindingUtil.inflate(inflater, R.layout.changeinitiative, container, false)

        viewModel = ViewModelProvider(this).get(ChangeinitiativeViewModel::class.java)

        binding.viewModel = viewModel

        val args =
            ChangeInitiativeFragmentArgs.fromBundle(requireArguments()) // TODO controle op niet null

        val ci = args.changeinitiative
        val changemanager = args.changemanager

        viewModel.changeInitiative = ci

        binding.lifecycleOwner = this

        viewModel.navigateToRoadmap.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    navController.navigate(
                        ChangeInitiativeFragmentDirections.actionChangeInitiativeFragmentToRoadMapListFragment(
                            false,
                            changemanager,
                            ci.roadMap
                        )
                    )
                    viewModel.onRoadmapNavigated()
                }
            }
        )

        binding.surveysCIName.text = getString(R.string.ci_screen, viewModel.changeInitiative.title)

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.changeInitiative.title
        return binding.root
    }

}
