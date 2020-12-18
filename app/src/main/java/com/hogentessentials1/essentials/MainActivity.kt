package com.hogentessentials1.essentials

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.navigation.NavigationView
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.iid.InstanceIdResult
import com.google.firebase.messaging.FirebaseMessaging
import com.hogentessentials1.essentials.data.network.EssentialsDatabase
import com.hogentessentials1.essentials.databinding.ActivityMainBinding
import com.hogentessentials1.essentials.ui.homeScreen.HomeScreenFragmentDirections
import com.hogentessentials1.essentials.ui.login.ui.login.LoginActivity
import com.hogentessentials1.essentials.util.Globals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Simon De Wilde
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    companion object{
        val CHANNEL_ID: String = "essentialstoolkit_notifs"
    }
    val CHANNEL_NAME: String = "essentialstoolkit notifs"
    val CHANNEL_DESC: String = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = CHANNEL_DESC
            val manager: NotificationManagerCompat = NotificationManagerCompat.from(this)
            manager.createNotificationChannel(channel)
        }
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener {
                if (it.isSuccessful) {
                    Timber.e(it.result)
                }
                else
                {
                    Timber.e("nope")
                }

            }
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
            Globals.bearerToken = ""
            // Remove all data from logged in user
            CoroutineScope(Dispatchers.IO).launch {
                EssentialsDatabase.getInstance(applicationContext).truncate()
            }
            toLoginActivity()
        }
    }

    private fun toLoginActivity() {
        Toast.makeText(
            applicationContext,
            "Logged out successfully",
            Toast.LENGTH_LONG
        ).show()

        val toLoginActivity = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(toLoginActivity)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true

        binding.drawerLayout.closeDrawers()

        when (item.itemId) {
            R.id.changeInitiativesDrawer -> navController.navigate(
                HomeScreenFragmentDirections.actionHomeScreenFragmentToChangeInitiativesFragment(
                    false
                )
            )
            R.id.allSurveysDrawer -> navController.navigate(
                HomeScreenFragmentDirections.actionHomeScreenFragmentToRoadMapListFragment(
                    true,
                    false,
                    null
                )
            )
            R.id.teamsDrawer -> navController.navigate(R.id.teamsFragment)
            R.id.logout -> {
                Globals.bearerToken = ""
                // Remove all data from logged in user when explicitly logged out
                CoroutineScope(Dispatchers.IO).launch {
                    EssentialsDatabase.getInstance(applicationContext).truncate()
                }
                toLoginActivity()
            }
        }
        return true
    }
}
