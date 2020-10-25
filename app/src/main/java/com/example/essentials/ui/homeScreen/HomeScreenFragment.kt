package com.example.essentials.ui.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.essentials.databinding.FragmentHomeScreenBinding

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

        binding.surveysHomescreen.setOnClickListener { view: View ->
            (
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToAllSurveysFragment(
                            viewModel.getSurveys().toTypedArray()
                        )
                    )
                    )
        }

        viewModel.navigateToChangeInitiatives.observe(
            viewLifecycleOwner,
            { shouldNavigate ->
                if (shouldNavigate == true) {
                    val navController = binding.root.findNavController()
                    navController.navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToChangeInitiativesFragment(
                            viewModel.changeInitiatives.toTypedArray()
                        )
                    )
                    viewModel.onNavigatedToChangeInitiatives()
                }
            }
        )

        (activity as AppCompatActivity).supportActionBar?.title = "Essentials"

        return binding.root
    }
}
