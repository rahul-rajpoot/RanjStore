package com.alps.ranjstore.dashboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.alps.ranjstore.R
import com.alps.ranjstore.activities.LoginActivity
import com.alps.ranjstore.adapter.ImageAdapter
import com.alps.ranjstore.dashboard.ui.profile.ProfileUpdateActivity
import com.alps.ranjstore.dashboard.ui.shop.CartActivity
import com.alps.ranjstore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlin.math.abs


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var linearoutdashfooter1: LinearLayout? =
        null
    var linearoutdashfooter2: LinearLayout? = null
    var linearoutdashfooter4: LinearLayout? = null
    var linearoutdashfooter5: LinearLayout? = null

    private lateinit var  viewPager2: ViewPager2
    private lateinit var handler : Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable , 2000)
            }
        })


        linearoutdashfooter1 = findViewById(R.id.linearoutdashfooter1)
        linearoutdashfooter2 = findViewById(R.id.linearoutdashfooter2)
        linearoutdashfooter4 = findViewById(R.id.linearoutdashfooter4)
        linearoutdashfooter5 = findViewById(R.id.linearoutdashfooter5)




        linearoutdashfooter1!!.setOnClickListener {
            val intent = Intent(MainActivity@ this, CartActivity::class.java)
            startActivity(intent)
        }

        linearoutdashfooter2!!.setOnClickListener {
            val intent = Intent(MainActivity@ this, MainActivity::class.java)
            startActivity(intent)
        }
        linearoutdashfooter4!!.setOnClickListener {
            val intent = Intent(MainActivity@ this, WhishListActivity::class.java)
            startActivity(intent)
        }

        linearoutdashfooter5!!.setOnClickListener {
            val intent = Intent(MainActivity@ this, LoginActivity::class.java)
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val view = binding.navView.getHeaderView(0)
        binding.navView.getHeaderView(0)

        val textusername = view.findViewById<TextView>(R.id.profile)
        textusername.setText("My Menu")
        textusername.setOnClickListener {
            val intent = Intent(MainActivity@ this, ProfileUpdateActivity::class.java)
            startActivity(intent)
        }




        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 4000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.98f + r * 0.7f
        }

        viewPager2.setPageTransformer(transformer)

    }
    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.ranj1)
        imageList.add(R.drawable.ranj2)
        imageList.add(R.drawable.ranj3)
        imageList.add(R.drawable.ranj4)
        imageList.add(R.drawable.ranj5)
        /*   imageList.add(R.drawable.six)
           imageList.add(R.drawable.seven)
           imageList.add(R.drawable.eight)*/


        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 5
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }



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


