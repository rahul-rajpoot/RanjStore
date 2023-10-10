package com.alps.ranjstore.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alps.ranjstore.R
import com.alps.ranjstore.dashboard.ui.profile.ProfileUpdateActivity
import com.alps.ranjstore.dashboard.ui.shop.CartActivity
import com.alps.ranjstore.dashboard.ui.shop.NotificationActivity
import com.alps.ranjstore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val view = binding.navView.getHeaderView(0)
         binding.navView.getHeaderView(0)

        val textusername = view.findViewById<TextView>(R.id.profile)
        textusername.setText("Pramodkumarp6")
        textusername.setOnClickListener {
            val intent = Intent(MainActivity@this,ProfileUpdateActivity::class.java)
            startActivity(intent)
        }






        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cart -> {
                val   intent = Intent(this@MainActivity, CartActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.notifications ->{
                intent = Intent(this@MainActivity, NotificationActivity::class.java)
                startActivity(intent)
                return true
            }
            /*R.id.action_exit ->{
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}