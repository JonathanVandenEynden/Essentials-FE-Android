package com.example.essentials

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.essentials.databinding.ActivityMainBinding
import com.example.essentials.ui.changeInitiatives.ChangeInitiativesFragment
import com.example.essentials.ui.dashboard.DashboardFragment
import com.example.essentials.ui.surveyScreen.SurveyFragment
import com.example.essentials.ui.teams.TeamsFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navigationView: NavigationView
    private lateinit var binding: ActivityMainBinding

    private val navController by lazy {
        Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        drawerLayout = binding.drawerLayout
        navigationView = binding.navView;

        navigationView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

//        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
//            if (nd.id == nc.graph.startDestination) {
//                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//            } else {
//                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
//            }
//        }


        // TODO EXPERIMENTAL - make drawer navigate - does not work properly yet
//        var nvDrawer = findViewById<NavigationView>(R.id.navView)
//        // Setup drawer view
//        setupDrawerContent(nvDrawer)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    private fun setupDrawerLayout() {
        navigationView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    // TODO EXPERIMENTAL - make drawer navigate - does not work properly yet
//    private fun setupDrawerContent(navigationView: NavigationView) {
//        navigationView.setNavigationItemSelectedListener(
//            object : NavigationView.OnNavigationItemSelectedListener {
//                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//                    selectDrawerItem(menuItem)
//                    return true
//                }
//            })
//    }
//
//    fun selectDrawerItem(menuItem: MenuItem) {
//        // Create a new fragment and specify the fragment to show based on nav item clicked
//        var fragment: Fragment? = null
//        val fragmentClass: Class<*>
//        fragmentClass = when (menuItem.getItemId()) {
//            R.id.changeInitiativesDrawer -> ChangeInitiativesFragment::class.java
//            R.id.dashBoardDrawer -> DashboardFragment::class.java
//            R.id.surveysDrawer -> SurveyFragment::class.java
//            R.id.teamsDrawer -> TeamsFragment::class.java
//            R.id.myChangeInitiativesDrawer -> ChangeInitiativesFragment::class.java // TODO veranderen naar de juiste fragment
//            else -> ChangeInitiativesFragment::class.java
//        }
//        try {
//            fragment = fragmentClass.newInstance() as Fragment
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//        // Insert the fragment by replacing any existing fragment
//        val fragmentManager: FragmentManager = supportFragmentManager
//        fragment?.let {
//            fragmentManager.beginTransaction().replace(
//                R.id.navHostFragment,
//                it
//            ).commit()
//        }
//
//        // Set action bar title
//        setTitle(menuItem.getTitle())
//        // Close the navigation drawer
//        drawerLayout.closeDrawers()
//    }
}
