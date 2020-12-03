package com.hogentessentials1.essentials.ui.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.FragmentHomeScreenBinding

/**
 * @author Ziggy Moens
 */

class HomeScreenFragment : Fragment() {

    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeScreenBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        binding.viewModel = viewModel

//        binding.surveysHomescreen.setOnClickListener { view: View ->
//            (binding.root.findNavController().navigate(
//                HomeScreenFragmentDirections.actionHomeScreenFragmentToAllSurveysFragment(
//                    viewModel.getSurveys().toTypedArray()
//                )
//            ))
//        }

        /**
         * @author Simon De Wilde
         * navigatie naar Change Initiatives
         */
        viewModel.navigateToChangeInitiatives.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    navController.navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToChangeInitiativesFragment()
                    )
                    viewModel.onNavigatedToChangeInitiatives()
                }
            }
        )

        /**
         * @author Simon De Wilde
         * navigatie naar Dashborad
         */
        viewModel.navigateToDasboard.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    navController.navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToDashboardFragment()
                    )
                    viewModel.onNavigatedToDasboard()
                }
            }
        )

        /**
         * @author Simon De Wilde
         * navigatie naar Surveys
         */
        viewModel.navigateToSurveys.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToAllSurveysFragment()
                    )
                    viewModel.onNavigatedToSurveys()
                }
            }
        )

        /**
         * @author Simon De Wilde
         * navigatie naar Teams
         */
        viewModel.navigateToTeams.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToTeamsFragment()
                    )
                    viewModel.onNavigatedToTeams()
                }
            }
        )

        /**
         * @author Simon De Wilde
         * navigatie naar My Change Initiatives
         */
        viewModel.navigateToMyChangeInitiatives.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToTeamsFragment()
                    )
                    viewModel.onNavigatedToMyChangeInitiatives()
                }
            }
        )

        (activity as AppCompatActivity).supportActionBar?.title = "Essentials"

        binding.labelName.text = getString(R.string.hello, "Sukrit")

        return binding.root
    }
}