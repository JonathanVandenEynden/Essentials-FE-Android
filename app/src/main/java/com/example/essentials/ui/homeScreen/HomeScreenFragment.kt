package com.example.essentials.ui.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.essentials.R
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

        viewModel.navigateToChangeInitiatives.observe(
            viewLifecycleOwner,
            Observer<Boolean> { shouldNavigate ->
                if (shouldNavigate == true) {
                    val navController = binding.root.findNavController()
                    navController.navigate(R.id.action_homeScreenFragment_to_changeInitiativesFragment)
                    viewModel.onNavigatedToChangeInitiatives()
                }
            }
        )
        return binding.root
    }
}
