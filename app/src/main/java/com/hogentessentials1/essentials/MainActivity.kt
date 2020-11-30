package com.hogentessentials1.essentials

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.hogentessentials1.essentials.databinding.ActivityMainBinding
import com.hogentessentials1.essentials.ui.homeScreen.HomeScreenFragmentDirections

/**
 * @author Simon De Wilde
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        // TODO De logged in user opslaan en publicly available maken voor de requests
        val loggedInUser = intent.getSerializableExtra("loggedInUser")

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.navView.setNavigationItemSelectedListener(this)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true

        binding.drawerLayout.closeDrawers()

        when (item.itemId) {
            R.id.changeInitiativesDrawer -> navController.navigate(R.id.changeInitiatives)
            R.id.dashboardDrawer -> navController.navigate(R.id.dashboardFragment)
            R.id.allSurveysDrawer -> navController.navigate(
                HomeScreenFragmentDirections.actionHomeScreenFragmentToRoadMapListFragment(
                    true,
                    false,
                    null
                )
            )
            R.id.teamsDrawer -> navController.navigate(R.id.teamsFragment)
        }
        return true
    }
}
