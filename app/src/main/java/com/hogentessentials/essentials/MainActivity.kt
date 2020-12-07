package com.hogentessentials.essentials

import android.content.Intent
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
import com.hogentessentials.essentials.databinding.ActivityMainBinding
import com.hogentessentials.essentials.ui.homeScreen.HomeScreenFragmentDirections
import com.hogentessentials.essentials.ui.login.ui.login.LoginActivity
import com.hogentessentials.essentials.util.Globals

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

    override fun onResume() {
        super.onResume()

        /**
         * @author Simon De Wilde
         *  If the app is resumed after a long time, and the stored bearertoken has become invalid,
         *  the application will return to the loginscreen
         */
        if (!Globals.bearertokenIsValid()) {
            val toLoginActivity = Intent(this@MainActivity, LoginActivity::class.java)
            toLoginActivity
            startActivity(toLoginActivity)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true

        binding.drawerLayout.closeDrawers()

        when (item.itemId) {
            R.id.changeInitiativesDrawer -> navController.navigate(R.id.changeInitiatives)
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
