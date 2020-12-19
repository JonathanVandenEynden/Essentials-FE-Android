package com.hogentessentials1.essentials.ui.homeScreen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.FragmentHomeScreenBinding
import com.hogentessentials1.essentials.util.Globals
import timber.log.Timber

/**
 * @author Ziggy Moens
 */

class HomeScreenFragment : Fragment() {

    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
         * @author Ziggy Moens, added safeArgs
         * navigatie naar Change Initiatives
         */
        viewModel.navigateToChangeInitiatives.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    navController.navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToChangeInitiativesFragment(
                            false
                        )
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
                    if (!isOnline(requireContext())) {
                        Toast.makeText(
                            requireContext(),
                            "no internet available",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val navController = binding.root.findNavController()
                        navController.navigate(
                            HomeScreenFragmentDirections.actionHomeScreenFragmentToDashboardFragment()
                        )
                    }
                    viewModel.onNavigatedToDasboard()
                }
            }
        )

        /**
         * @author Simon De Wilde
         * @author Ziggy Moens, added safeArgs
         * navigatie naar Surveys
         */
        viewModel.navigateToSurveys.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToRoadMapListFragment(
                            true,
                            false,
                            null
                        )
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
         * @author Ziggy Moens, added safeArgs
         * navigatie naar My Change Initiatives
         */
        viewModel.navigateToMyChangeInitiatives.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        HomeScreenFragmentDirections.actionHomeScreenFragmentToChangeInitiativesFragment(
                            true
                        )
                    )
                    viewModel.onNavigatedToMyChangeInitiatives()
                }
            }
        )

        /**
         * @author Ziggy Moens
         */
        if (Globals.type != "changeManager") {
            binding.myChanges.visibility = View.GONE
            binding.dashboard.visibility = View.GONE
            binding.titleCm.visibility = View.GONE
        }

        /**
         * @author Ziggy Moens
         */
        (activity as AppCompatActivity).supportActionBar?.title = "Essentials"

        /**
         * @author Ziggy Moens: Remove dark theme from the app
         */
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.labelName.text = getString(R.string.hello, Globals.username)

        return binding.root
    }

    /**
     * @author Simon De Wilde
     * https://stackoverflow.com/questions/51141970/check-internet-connectivity-android-in-kotlin
     * @param context
     */
    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Timber.i("Internet NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Timber.i("Internet NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Timber.i("Internet NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
        return false
    }
}
