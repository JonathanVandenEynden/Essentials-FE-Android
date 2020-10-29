package com.example.essentials

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.essentials.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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
            R.id.changeInitiativesDrawer -> navController.navigate(R.id.changeInitiativesDrawer)
            R.id.dashBoardDrawer -> navController.navigate(R.id.dashboardFragment)
     }
        return true
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
