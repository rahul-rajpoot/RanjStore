package com.alps.ranjstore.dashboard

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.alps.ranjstore.R
import com.alps.ranjstore.activities.LoginActivity
import com.alps.ranjstore.dashboard.ui.profile.ProfileActivity
import com.alps.ranjstore.dashboard.ui.profile.ProfileUpdateActivity
import com.alps.ranjstore.dashboard.ui.shop.CartActivity
import com.alps.ranjstore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var linearoutdashfooter1: LinearLayout? =
        null
    var linearoutdashfooter2:LinearLayout? = null
     var linearoutdashfooter4:LinearLayout? = null
    var linearoutdashfooter5:LinearLayout? = null

    private val _context: Context? = null
    private val _listDataHeader: List<String>? = null // header titles


    private val _listDataChild: HashMap<String, List<String>>? = null
    var listView: ExpandableListView? = null
    private val blueColorList: ColorStateList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val blueColor = resources.getColor(R.color.menu_blue)
        val grayColor = resources.getColor(R.color.gray_color)
        val grayColorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_enabled),
                intArrayOf(android.R.attr.state_pressed),
                intArrayOf(android.R.attr.state_focused),
                intArrayOf(android.R.attr.state_pressed)
            ), intArrayOf(
                grayColor,
                grayColor,
                grayColor,
                grayColor,
                grayColor
            )
        )

        val blueColorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_enabled),
                intArrayOf(android.R.attr.state_pressed),
                intArrayOf(android.R.attr.state_focused),
                intArrayOf(android.R.attr.state_pressed)
            ), intArrayOf(
                blueColor,
                blueColor,
                blueColor,
                blueColor,
                blueColor
            )
        )

        linearoutdashfooter1 = findViewById(R.id.linearoutdashfooter1)
        linearoutdashfooter2 = findViewById(R.id.linearoutdashfooter2)
        linearoutdashfooter4 = findViewById(R.id.linearoutdashfooter4)
         linearoutdashfooter5 = findViewById(R.id.linearoutdashfooter5)


          linearoutdashfooter1!!.setOnClickListener(View.OnClickListener { v: View? ->
              val intent = Intent(
                  applicationContext,
                  CartActivity::class.java
              )
              startActivity(intent)
          })
        linearoutdashfooter5!!.setOnClickListener(View.OnClickListener { v: View? ->
            val intent = Intent(
                applicationContext,
                LoginActivity::class.java
            )
            startActivity(intent)
        })

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val view = binding.navView.getHeaderView(0)
        binding.navView.getHeaderView(0)

        val textusername = view.findViewById<TextView>(R.id.profile)
        textusername.setText("Pramodkumarp6")
        textusername.setOnClickListener {
            val intent = Intent(MainActivity@ this, ProfileUpdateActivity::class.java)
            startActivity(intent)
        }





       /* val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cart -> {
                val intent = Intent(this@MainActivity, CartActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.notifications -> {
                intent = Intent(this@MainActivity, NotificationActivity::class.java)
                startActivity(intent)
                return true
            }
            *//*R.id.action_exit ->{
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }*//*
            else -> super.onOptionsItemSelected(item)
        }
    }*/

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    private fun displaySelectedScreen(itemId: Int) {
        when (itemId) {
            /* R.id.document -> {
                 val docu = Intent(this, Document_View::class.java)
                 startActivity(docu)
             }*/

        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }*/
