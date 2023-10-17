package com.alps.ranjstore.userAccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityUserDashBoardBinding
import com.google.android.material.navigation.NavigationView

class UserDashBoardActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUserDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityUserDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarUser.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.appBarUser.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    }
